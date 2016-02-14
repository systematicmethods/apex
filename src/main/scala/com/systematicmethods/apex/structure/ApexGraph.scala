package com.systematicmethods.apex.structure

import org.apache.commons.configuration.Configuration
import org.apache.tinkerpop.gremlin.process.computer.GraphComputer
import org.apache.tinkerpop.gremlin.structure.{ Edge, Graph, Transaction, Vertex }
import org.apache.tinkerpop.gremlin.structure.util.StringFactory
import org.apache.tinkerpop.gremlin.structure.Graph.Features
import org.apache.tinkerpop.gremlin.structure.util.GraphFactoryClass
import org.apache.tinkerpop.gremlin.structure.util.ElementHelper
import org.apache.tinkerpop.gremlin.structure.T
import scala.collection.JavaConverters._
import org.slf4j.LoggerFactory
import org.apache.tinkerpop.gremlin.structure.Graph.Exceptions
import java.util.UUID

@GraphFactoryClass(classOf[ApexGraphFactory])
@Graph.OptIn(Graph.OptIn.SUITE_STRUCTURE_STANDARD)
class ApexGraph(configuration: Configuration) extends Graph {

  private val log = LoggerFactory.getLogger(classOf[ApexGraph])
  private var vertices = Map[String, Vertex]()
  
  // Members declared in Graph
  override def addVertex(keyValues: Object*): Vertex = {
    ElementHelper.legalPropertyKeyValueArray(keyValues: _*) // throws exception
    val idopt = Option(ElementHelper.getIdValue(keyValues: _*).orElse(null))
    val id = idopt.map(anid => {
      if (vertices.contains(anid.toString)) {
        throw Exceptions.vertexWithIdAlreadyExists(anid);
      } else {
        UUID.randomUUID().toString()
      }
    })
    val label = Option(ElementHelper.getLabelValue(keyValues: _*).orElse(null))
    val vertex = new ApexVertex(id, label, this)
    vertices = vertices.+ (id.toString() -> vertex)
    vertex
  }
  
  override def close(): Unit = ???
  override def compute(): GraphComputer = ???
  override def compute[C <: GraphComputer](graphComputerClass: Class[C]): C = ???
  override def configuration(): Configuration = ???
  override def edges(edgeIds: Object*): java.util.Iterator[Edge] = ???
  override def tx(): Transaction = null
  override def variables(): Graph.Variables = ???
  override def vertices(vertexIds: Object*): java.util.Iterator[Vertex] = {
    vertices.valuesIterator.asJava
  }

  override def toString: String = StringFactory.graphString(this, "Apex");

  override def features(): Features = {
    ApexGraphFeatures
  }
}


