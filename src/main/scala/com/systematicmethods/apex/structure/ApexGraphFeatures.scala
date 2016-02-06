package com.systematicmethods.apex.structure

import org.apache.tinkerpop.gremlin.structure.Graph.Features
import org.apache.tinkerpop.gremlin.structure.Graph.Features.VertexFeatures
import org.apache.tinkerpop.gremlin.structure.Graph.Features.GraphFeatures
import org.apache.tinkerpop.gremlin.structure.util.StringFactory
import org.apache.tinkerpop.gremlin.structure.Graph.Features.EdgeFeatures
import org.apache.tinkerpop.gremlin.structure.VertexProperty

object ApexGraphFeatures extends Features {

  override def graph(): GraphFeatures = {
    ApexGraphGraphFeatures
  }

  override def edge(): EdgeFeatures = {
    ApexGraphEdgeFeatures
  }

  override def vertex(): VertexFeatures = {
    ApexGraphVertexFeatures
  }

}

object ApexGraphVertexFeatures extends Features.VertexFeatures {
  override def properties(): Features.VertexPropertyFeatures = {
    ApexGraphVertexPropertyFeatures
  }

  override def supportsCustomIds: Boolean = {
    false
  }

  override def willAllowId(id: Object): Boolean = {
    false
  }

  override def getCardinality(key: String): VertexProperty.Cardinality = {
    VertexProperty.Cardinality.single
  }
}

object ApexGraphEdgeFeatures extends Features.EdgeFeatures {

  override def supportsCustomIds(): Boolean = {
    false
  }

  override def willAllowId(id: Object): Boolean = {
    false // edgeIdManager.allow(id);
  }
}

object ApexGraphGraphFeatures extends Features.GraphFeatures {

  override def supportsConcurrentAccess: Boolean = {
    false
  }

  override def supportsTransactions: Boolean = {
    false
  }

  override def supportsPersistence: Boolean = {
    false
  }

  override def supportsThreadedTransactions(): Boolean = {
    false
  }

}

object ApexGraphVertexPropertyFeatures extends Features.VertexPropertyFeatures {

  override def supportsCustomIds(): Boolean = {
    false
  }

  override def willAllowId(id: Object): Boolean = {
    false //vertexIdManager.allow(id);
  }
}
