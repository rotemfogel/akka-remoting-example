name := "akka-remoting-example"

version := "0.1"

scalaVersion := "2.12.8"


lazy val shared = project.in(file("shared"))

lazy val client = project.in(file("client"))
  .dependsOn(shared)

lazy val server = project.in(file("server"))
  .dependsOn(shared)

lazy val root = project.in(file("."))
  .settings(name := "akka-remoting-example", publishArtifact := false, publish := {}, publishLocal := {})
  .aggregate(shared, client, server)

