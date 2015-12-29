Nice.scalaProject

name          := "datasets.illumina"
organization  := "ohnosequences"
description   := "datasets.illumina project"

bucketSuffix  := "era7.com"

libraryDependencies ++= Seq(
  "ohnosequences" %% "datasets" % "0.3.0",
  "org.scalatest" %% "scalatest" % "2.2.5" % Test
)
