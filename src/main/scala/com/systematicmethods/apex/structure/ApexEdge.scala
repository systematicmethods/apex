package com.systematicmethods.apex.structure

import org.apache.tinkerpop.gremlin.structure.Edge
import org.apache.tinkerpop.gremlin.structure.Property
import org.apache.tinkerpop.gremlin.structure.Graph
import org.apache.tinkerpop.gremlin.structure.Vertex
import org.apache.tinkerpop.gremlin.structure.Direction
import org.apache.tinkerpop.gremlin.structure.util.StringFactory

class ApexEdge extends ApexElement with Edge {

  // Members declared in Edge
  override def properties[V](propertyKeys: String*): java.util.Iterator[Property[V]] = ???
  override def vertices(direction: Direction): java.util.Iterator[Vertex] = ???

  // Members declared in Element
  override def property[V](key: String, value: V): Property[V] = ???

  override def toString: String = StringFactory.edgeString(this);

}