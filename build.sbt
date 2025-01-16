import Dependencies._

ThisBuild / scalaVersion     := "2.13.12"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.TReKiE"
ThisBuild / organizationName := "TReKiE"

lazy val root = (project in file("."))
  .settings(
    name := "UpdateUserTReKiEStatus",
    libraryDependencies ++= Seq(munit, mysqlConnector, typesafeConfig)
  )