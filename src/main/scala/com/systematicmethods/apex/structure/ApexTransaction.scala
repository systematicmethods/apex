package com.systematicmethods.apex.structure

import org.apache.tinkerpop.gremlin.structure.Transaction
import org.apache.tinkerpop.gremlin.structure.Graph
import java.util.function.Consumer
import java.util.function.Function

class ApexTransaction extends Transaction {
  
  // Members declared in Transaction
  override def addTransactionListener(listener: Consumer[Transaction.Status]): Unit = ???
  override def clearTransactionListeners(): Unit = ???
  override def close(): Unit = ???
  override def commit(): Unit = ???
  override def createThreadedTx[G <: Graph](): G = ???
  override def isOpen(): Boolean = ???
  override def onClose(consumer: Consumer[Transaction]): Transaction = ???
  override def onReadWrite(consumer: Consumer[Transaction]): Transaction = ???
  override def open(): Unit = ???
  override def readWrite(): Unit = ???
  override def removeTransactionListener(listener: Consumer[Transaction.Status]): Unit = ???
  override def rollback(): Unit = ???
  override def submit[R](work: Function[Graph,R]): Transaction.Workload[R] = ???
  
}