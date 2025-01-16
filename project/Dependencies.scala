import sbt._

object Dependencies {
  lazy val munit = "org.scalameta" %% "munit" % "0.7.29"
  lazy val mysqlConnector = "mysql" % "mysql-connector-java" % "8.0.27"
  lazy val typesafeConfig = "com.typesafe" % "config" % "1.4.1"
}