
name := "scala-spark-boilerplate"

version := "0.1"

scalaVersion := "2.11.11"

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
