package com.systematicmethods.apex.structure

import org.apache.tinkerpop.gremlin.structure.Edge
import org.apache.tinkerpop.gremlin.structure.Property
import org.apache.tinkerpop.gremlin.structure.Graph
import org.apache.tinkerpop.gremlin.structure.Vertex
import org.apache.tinkerpop.gremlin.structure.Direction
import org.apache.tinkerpop.gremlin.structure.util.StringFactory

class ApexEdge(id: Object, label: Option[String], graph: Graph) extends ApexElement(id, label, graph) with Edge {

  // Members declared in Edge
  override def properties[V](propertyKeys: String*): java.util.Iterator[Property[V]] = ???
  override def vertices(direction: Direction): java.util.Iterator[Vertex] = ???

  // Members declared in Element
  override def remove(): Unit = ???
  override def property[V](key: String, value: V): Property[V] = ???
  override def removeProperty(key: String): Unit = ???

  override def toString: String = StringFactory.edgeString(this);

}