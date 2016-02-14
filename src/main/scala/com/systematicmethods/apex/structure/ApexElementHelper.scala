package com.systematicmethods.apex.structure

import org.apache.tinkerpop.gremlin.structure.util.ElementHelper

object ApexElementHelper {
  
  def getProps(keyValues: Array[Object]): List[(String, Object)] = {
    val id = Option(ElementHelper.getIdValue(keyValues: _*).orElse(null))
    val label = Option(ElementHelper.getLabelValue(keyValues: _*).orElse(null))
//    if (null != idValue) {
//            if (this.vertices.containsKey(idValue))
//                throw Exceptions.vertexWithIdAlreadyExists(idValue);
//        } else {
//            idValue = vertexIdManager.getNextId(this);
//        }

    //    var props: List[(String, Object)] = List.empty
//    for ( ix <- 0 until keyValues.size) {
//      if (ix % 2 == 0) {
//        keyValues(ix) match {
//          case other:String => props = props :+ (other, keyValues(ix+1))
//          case unknown => log.error(s"Don't know what to do with ${unknown}")
//        }
//      }
//    }
    
//    var label: Option[(T, Object)] = None
//    var props: List[(String, Object)] = List.empty
//    for ( ix <- 0 until keyValues.size) {
//      if (ix % 2 == 0) {
//        keyValues(ix) match {
//          case t:T => {
//            label = Option(t, keyValues(ix+1))
//          }
//          case other:String => props = props :+ (other, keyValues(ix+1))
//          case unknown => log.error(s"Don't know what to do with ${unknown}")
//        }
//      }
//    }   
    null
  }
}