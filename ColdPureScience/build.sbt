name := "ColdPureScience"

version := "1.0"

scalaVersion := "2.11.6"

lazy val root = (project in file(".")).
  settings(
    libraryDependencies ++= Seq(
      "org.scalactic" %% "scalactic" % "3.0.1",
      "org.scalatest" %% "scalatest" % "3.0.1" % "test"
    ))
