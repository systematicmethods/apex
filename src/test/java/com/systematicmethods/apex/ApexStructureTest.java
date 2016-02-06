package com.systematicmethods.apex;

import static org.junit.Assert.fail;

import org.apache.tinkerpop.gremlin.GraphProviderClass;
import org.apache.tinkerpop.gremlin.structure.StructureStandardSuite;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.systematicmethods.apex.structure.ApexGraph;

//XXXStructureStandardTest
//Structure API tests
@RunWith(StructureStandardSuite.class)
@GraphProviderClass(provider = ApexGraphProvider.class, graph = ApexGraph.class)

public class ApexStructureTest {

  @Test
  public void test() {
    fail("Not yet implemented");
  }

}
