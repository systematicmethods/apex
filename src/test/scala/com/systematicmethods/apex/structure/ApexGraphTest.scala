package com.systematicmethods.apex.structure

import org.apache.commons.configuration.BaseConfiguration
import org.apache.tinkerpop.gremlin.structure.Graph
import org.apache.tinkerpop.gremlin.structure.util.GraphFactory
import org.junit.Test

class ApexGraphTest {

  @Test
  def createGraph(): Unit = {
    val config = new BaseConfiguration
    config.setProperty("gremlin.graph", "com.systematicmethods.apex.structure.ApexGraph")
    config.setProperty("storage.hostname", "127.0.0.1")
    config.setProperty("storage.cassandra.keyspace", "apex")
    val graph: Graph = GraphFactory.open(config)
  }

}