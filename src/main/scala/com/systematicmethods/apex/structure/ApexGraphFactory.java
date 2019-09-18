package com.systematicmethods.apex.structure;

import org.apache.commons.configuration.Configuration;

public class ApexGraphFactory {

  private ApexGraphFactory() {
  }

  public static ApexGraph open(Configuration configuration) {
      return new ApexGraph(configuration);
    }

}
