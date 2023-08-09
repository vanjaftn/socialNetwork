name := """socialNetwork"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.10"


libraryDependencies ++= Seq(
  guice ,

  "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
  "mysql" % "mysql-connector-java" % "8.0.28",
  "com.typesafe.play" %% "play-slick-evolutions" % "5.0.0",
  "com.pauldijou" %% "jwt-play" % "5.0.0",
  "com.pauldijou" %% "jwt-core" % "5.0.0",
  "org.mindrot"  % "jbcrypt"   % "0.3m"
)

