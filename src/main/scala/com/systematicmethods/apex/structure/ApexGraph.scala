package com.systematicmethods.apex.structure

import org.apache.commons.configuration.Configuration
import org.apache.tinkerpop.gremlin.process.computer.GraphComputer
import org.apache.tinkerpop.gremlin.structure.{ Edge, Graph, Transaction, Vertex }
import org.apache.tinkerpop.gremlin.structure.util.StringFactory
import org.apache.tinkerpop.gremlin.structure.Graph.Features

@Graph.OptIn(Graph.OptIn.SUITE_STRUCTURE_STANDARD)
class ApexGraph(configuration: Configuration) extends Graph {

  // Members declared in Graph
  override def addVertex(keyValues: Object*): Vertex = ???
  override def close(): Unit = ???
  override def compute(): GraphComputer = ???
  override def compute[C <: GraphComputer](graphComputerClass: Class[C]): C = ???
  override def configuration(): Configuration = ???
  override def edges(edgeIds: Object*): java.util.Iterator[Edge] = ???
  override def tx(): Transaction = ???
  override def variables(): Graph.Variables = ???
  override def vertices(vertexIds: Object*): java.util.Iterator[Vertex] = ???

  override def toString: String = StringFactory.graphString(this, "Apex");

  override def features(): Features = {
    ApexGraphFeatures
  }
}

object ApexGraph {
  def open(configuration: Configuration): ApexGraph = {
    new ApexGraph(configuration);
  }
}
