name := "homework9"

version := "0.1"

scalaVersion := "2.12.10"

val sparkVersion = "3.0.1"
val scalaTestVersion = "3.2.1"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-core" % sparkVersion % "provided",

  // logging
  "log4j" % "log4j" % "1.2.17",
  "org.slf4j" % "slf4j-log4j12" % "1.7.30",

  "org.scalacheck" %% "scalacheck" % "1.14.3" ,
  "org.scalatestplus" %% "scalacheck-1-14" % "3.2.2.0",

  "org.flywaydb"            % "flyway-core"                         % "7.3.2",
  "org.postgresql"          % "postgresql"                            % "42.2.2" ,
)
