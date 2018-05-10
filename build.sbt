name          := "datasets.illumina"
organization  := "ohnosequences"
description   := "datasets.illumina project"
bucketSuffix  := "era7.com"

crossScalaVersions := Seq("2.11.12", "2.12.6")
scalaVersion  := crossScalaVersions.value.max

libraryDependencies ++= Seq(
  "ohnosequences" %% "datasets" % "0.5.3"
)
