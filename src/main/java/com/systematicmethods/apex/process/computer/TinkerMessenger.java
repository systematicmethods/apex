/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.systematicmethods.apex.process.computer;

import java.util.Iterator;
import java.util.Optional;
import java.util.Queue;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.apache.tinkerpop.gremlin.process.computer.MessageCombiner;
import org.apache.tinkerpop.gremlin.process.computer.MessageScope;
import org.apache.tinkerpop.gremlin.process.computer.Messenger;
import org.apache.tinkerpop.gremlin.process.computer.util.VertexProgramHelper;
import org.apache.tinkerpop.gremlin.process.traversal.Traversal;
import org.apache.tinkerpop.gremlin.process.traversal.step.map.VertexStep;
import org.apache.tinkerpop.gremlin.process.traversal.util.TraversalHelper;
import org.apache.tinkerpop.gremlin.structure.Direction;
import org.apache.tinkerpop.gremlin.structure.Edge;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.util.iterator.MultiIterator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public final class TinkerMessenger<M> implements Messenger<M> {

    private final Vertex vertex;
    private final TinkerMessageBoard<M> messageBoard;
    private final MessageCombiner<M> combiner;

    public TinkerMessenger(final Vertex vertex, final TinkerMessageBoard<M> messageBoard, final Optional<MessageCombiner<M>> combiner) {
        this.vertex = vertex;
        this.messageBoard = messageBoard;
        this.combiner = combiner.isPresent() ? combiner.get() : null;
    }

    @Override
    public Iterator<M> receiveMessages() {
        final MultiIterator<M> multiIterator = new MultiIterator<>();
        for (final MessageScope messageScope : this.messageBoard.previousMessageScopes) {
            if (messageScope instanceof MessageScope.Local) {
                final MessageScope.Local<M> localMessageScope = (MessageScope.Local<M>) messageScope;
                final Traversal.Admin<Vertex, Edge> incidentTraversal = TinkerMessenger.setVertexStart(localMessageScope.getIncidentTraversal().get().asAdmin(), this.vertex);
                final Direction direction = TinkerMessenger.getDirection(incidentTraversal);
                final Edge[] edge = new Edge[1]; // simulates storage side-effects available in Gremlin, but not Java8 streams
                multiIterator.addIterator(StreamSupport.stream(Spliterators.spliteratorUnknownSize(VertexProgramHelper.reverse(incidentTraversal.asAdmin()), Spliterator.IMMUTABLE | Spliterator.SIZED), false)
                        .map(e -> this.messageBoard.receiveMessages.get((edge[0] = e).vertices(direction).next()))
                        .filter(q -> null != q)
                        .flatMap(Queue::stream)
                        .map(message -> localMessageScope.getEdgeFunction().apply(message, edge[0]))
                        .iterator());

            } else {
                multiIterator.addIterator(Stream.of(this.vertex)
                        .map(this.messageBoard.receiveMessages::get)
                        .filter(q -> null != q)
                        .flatMap(Queue::stream)
                        .iterator());
            }
        }
        return multiIterator;
    }

    @Override
    public void sendMessage(final MessageScope messageScope, final M message) {
        this.messageBoard.currentMessageScopes.add(messageScope);
        if (messageScope instanceof MessageScope.Local) {
            addMessage(this.vertex, message);
        } else {
            ((MessageScope.Global) messageScope).vertices().forEach(v -> addMessage(v, message));
        }
    }

    private void addMessage(final Vertex vertex, final M message) {
        this.messageBoard.sendMessages.compute(vertex, (v, queue) -> {
            if (null == queue) queue = new ConcurrentLinkedQueue<>();
            queue.add(null != this.combiner && !queue.isEmpty() ? this.combiner.combine(queue.remove(), message) : message);
            return queue;
        });
    }

    ///////////

    private static <T extends Traversal.Admin<Vertex, Edge>> T setVertexStart(final Traversal.Admin<Vertex, Edge> incidentTraversal, final Vertex vertex) {
        incidentTraversal.addStart(incidentTraversal.getTraverserGenerator().generate(vertex,incidentTraversal.getStartStep(),1l));
        return (T) incidentTraversal;
    }

    private static Direction getDirection(final Traversal.Admin<Vertex, Edge> incidentTraversal) {
        final VertexStep step = TraversalHelper.getLastStepOfAssignableClass(VertexStep.class, incidentTraversal).get();
        return step.getDirection();
    }
}
