package com.systematicmethods.apex.structure

import org.apache.tinkerpop.gremlin.structure.Element
import org.apache.tinkerpop.gremlin.structure.Property
import org.apache.tinkerpop.gremlin.structure.Graph
import org.apache.tinkerpop.gremlin.structure.util.StringFactory
import org.apache.tinkerpop.gremlin.structure.util.ElementHelper

abstract class ApexElement(id: Object, label: String, graph: Graph) extends Element {

  // Members declared in Element
  override def graph(): Graph = graph
  override def id(): Object = id
  override def label(): String = label

  def removeProperty(key: String): Unit

  override def hashCode(): Int = {
    ElementHelper.hashCode(this)
  }

  override def equals(obj: Any): Boolean = {
    ElementHelper.areEqual(this, obj)
  }
}