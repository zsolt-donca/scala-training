name := "scala-training"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  // Testing
  "org.scalatest" %% "scalatest" % "3.0.0-M16-SNAP3" % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.0" % "test",
  "com.github.alexarchambault" %% "scalacheck-shapeless_1.13" % "1.1.0-RC1" % "test"
)