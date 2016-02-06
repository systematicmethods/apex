package com.systematicmethods.apex.structure

import org.apache.tinkerpop.gremlin.structure.Element
import org.apache.tinkerpop.gremlin.structure.Property
import org.apache.tinkerpop.gremlin.structure.Graph
import org.apache.tinkerpop.gremlin.structure.util.StringFactory

trait ApexElement extends Element {
  
  // Members declared in Element
  override def graph(): Graph = ???
  override def id(): Object = ???
  override def label(): String = ???
  override def properties[V](propertyKeys: String*): java.util.Iterator[_ <: Property[V]] = ???
  override def remove(): Unit = ???
  
}