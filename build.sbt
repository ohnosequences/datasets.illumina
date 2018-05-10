name          := "datasets.illumina"
organization  := "ohnosequences"
description   := "datasets.illumina project"
bucketSuffix  := "era7.com"

scalaVersion  := "2.12.6"

libraryDependencies ++= Seq(
  "ohnosequences" %% "datasets" % "0.5.3"
)
