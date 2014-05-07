name := "albatross"

version := "1.0"

scalaVersion := "2.10.4"

scalacOptions ++= Seq("-unchecked", "-deprecation")

libraryDependencies ++=  Seq(
  "org.specs2" %% "specs2" % "1.14" % "test"
)
