package com.systematicmethods.apex.structure

import org.apache.tinkerpop.gremlin.structure.Vertex
import org.apache.tinkerpop.gremlin.structure.VertexProperty
import org.apache.tinkerpop.gremlin.structure.Graph
import org.apache.tinkerpop.gremlin.structure.Direction
import org.apache.tinkerpop.gremlin.structure.Edge
import org.apache.tinkerpop.gremlin.structure.VertexProperty.Cardinality
import org.apache.tinkerpop.gremlin.structure.Property
import org.apache.tinkerpop.gremlin.structure.util.StringFactory

class ApexVertex extends Vertex with ApexElement {
  
  // Members declared in Vertex
  override def addEdge(label: String, inVertex: Vertex, keyValues: Object*): Edge = ???
  override def edges(direction: Direction, edgeLabel: String*): java.util.Iterator[Edge] = ???
  override def property[V](cardinality: Cardinality, key: String, value: V, keyValues: Object*): VertexProperty[V] = ???
  override def vertices(direction: Direction, edgeLabels: String*): java.util.Iterator[Vertex] = ???
  
  override def toString: String = StringFactory.vertexString(this);

}