name := "client"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq (
  "org.slf4j"          % "slf4j-api"       % "1.7.26",
  "ch.qos.logback"     % "logback-classic" % "1.2.3",
  "com.typesafe.akka" %% "akka-slf4j"      % "2.5.22",
  "com.typesafe.akka" %% "akka-remote"     % "2.5.22"
)