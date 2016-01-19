name := "scala-consumes-client"

version := "1.0"

scalaVersion := "2.11.7"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  Seq(
    "com.typesafe.akka" % "akka-slf4j_2.11" % "2.4.0",
    "org.aria" %% "aria-api-client-scala" % "0.1",
    "com.typesafe.play" %% "play-ws" % "2.5.0-M1"
  )
}