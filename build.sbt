name := "arrow-benchmark"
version := "0.0.1-SNAPSHOT"
scalaVersion := "2.12.8"
crossScalaVersions := Seq("2.12.8", "2.11.12")
organization := "com.azavea"
scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-language:implicitConversions",
  "-language:reflectiveCalls",
  "-language:higherKinds",
  "-language:postfixOps",
  "-language:existentials",
  "-feature"
)

enablePlugins(JmhPlugin)

headerLicense := Some(HeaderLicense.ALv2("2019", "Azavea"))

fork := true

libraryDependencies ++= Seq(
  "org.apache.arrow" % "arrow-vector"  % "0.13.0",
  "org.scodec"      %% "scodec-bits"   % "1.1.14",
  "org.typelevel"   %% "spire"         % "0.16.1",
  "org.slf4j"        % "slf4j-api"     % "1.7.26",
  "org.slf4j"        % "slf4j-log4j12" % "1.7.26",
  "org.scalatest"   %% "scalatest"     % "3.0.7" % Test
)
