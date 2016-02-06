package com.systematicmethods.apex.structure

import org.apache.tinkerpop.gremlin.structure.Property
import org.apache.tinkerpop.gremlin.structure.Element

class ApexProperty[V] extends Property[V] {
  
  // Members declared in Property
  override def element(): Element = ???
  override def isPresent(): Boolean = ???
  override def key(): String = ???
  override def remove(): Unit = ???
  override def value(): V = ???
  
}