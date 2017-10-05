name          := "datasets.illumina"
organization  := "ohnosequences"
description   := "datasets.illumina project"
bucketSuffix  := "era7.com"

crossScalaVersions := Seq("2.11.11", "2.12.3")
scalaVersion  := crossScalaVersions.value.max

libraryDependencies ++= Seq(
  "ohnosequences" %% "datasets" % "0.5.1"
)
