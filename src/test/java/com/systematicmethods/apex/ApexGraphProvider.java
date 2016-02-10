package com.systematicmethods.apex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.configuration.Configuration;
import org.apache.tinkerpop.gremlin.AbstractGraphProvider;
import org.apache.tinkerpop.gremlin.LoadGraphWith.GraphData;
import org.apache.tinkerpop.gremlin.structure.Graph;
import com.systematicmethods.apex.structure.ApexGraph;

public class ApexGraphProvider extends AbstractGraphProvider {

  @Override
  public void clear(Graph graph, Configuration configuration) throws Exception {
    // TODO Auto-generated method stub
    
  }

  @Override
  public Set<Class> getImplementations() {
    // TODO Auto-generated method stub
    return new HashSet<Class>();
  }

  @Override
  public Map<String, Object> getBaseConfiguration(String graphName, Class<?> test, String testMethodName, GraphData loadGraphWith) {
    // TODO Auto-generated method stub
    Map res = new HashMap<String, Object>();
    res.put(Graph.GRAPH, "com.systematicmethods.apex.structure.ApexGraph");
    return res;
  }


}
