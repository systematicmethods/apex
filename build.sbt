name := """apex"""

version := "1.0.0"

organization := "com.systematicmethods"

scalaVersion := "2.11.7"

resolvers += Resolver.mavenLocal

val tinkerVersion = "3.1.0-incubating"

libraryDependencies ++= Seq(
  "org.apache.tinkerpop" % "gremlin-core" % tinkerVersion,
  "ch.qos.logback" % "logback-classic" % "1.1.3",

  // internal

  // test
  "org.apache.tinkerpop" % "gremlin-test" % tinkerVersion % "test",
  "org.apache.tinkerpop" % "tinkergraph-gremlin" % tinkerVersion % "test",
  "junit" % "junit" % "4.12" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test",
  "org.scalatest" %% "scalatest" % "2.2.5" % "test"  
)


