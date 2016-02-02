name := """apex"""

version := "1.0.0"

organization := "com.systematicmethods"

scalaVersion := "2.11.7"


libraryDependencies ++= Seq(
  "org.apache.tinkerpop" % "gremlin-core" % "3.1.0-incubating",
  "ch.qos.logback" % "logback-classic" % "1.1.3",

  // internal

  // test
  "org.apache.tinkerpop" % "gremlin-test" % "3.1.0-incubating" % "test",
  "junit" % "junit" % "4.12" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test",
  "org.scalatest" %% "scalatest" % "2.2.5" % "test"  
)


