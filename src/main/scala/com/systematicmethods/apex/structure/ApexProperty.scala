package com.systematicmethods.apex.structure

import org.apache.tinkerpop.gremlin.structure.Property
import org.apache.tinkerpop.gremlin.structure.Element
import org.apache.tinkerpop.gremlin.structure.util.StringFactory

class ApexProperty[V](element :Element, key: String, value: V) extends Property[V] {
  
  // Members declared in Property
  override def element(): Element = element
  override def isPresent(): Boolean =  null != value
  override def key(): String = key
  override def remove(): Unit = {
    element match {
      case e:ApexElement => e.removeProperty(key)
    }
  }

  override def value(): V = value
  
  override def toString: String = {
    StringFactory.propertyString(this)
  }

}