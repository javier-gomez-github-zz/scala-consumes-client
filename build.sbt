name := "scala-consumes-client"

version := "1.0"

scalaVersion := "2.10.3"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/"
)

libraryDependencies ++= {
  val sprayVersion = "1.2-RC4"
  Seq(
    "io.spray" % "spray-can" % sprayVersion,
    "io.spray" % "spray-routing" % sprayVersion,
    "io.spray" % "spray-testkit" % sprayVersion,
    "io.spray" % "spray-client" % sprayVersion,
    "io.spray" %%  "spray-json" % "1.2.5",
    "org.killbill" %% "killbill-api-client-scala" % "0.1"
  )
}