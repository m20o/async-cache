import sbt._
import sbt.Keys._

object AsyncCacheBuild extends Build with Dependencies{

  lazy val asynccache = Project(
    id = "asynccache",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "AsyncCache",
      organization := "org.async",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.0",
      resolvers += "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases",
      libraryDependencies ++= akka ++ scalatest

    )
  )
}

trait Versions {

  val SCALA_MAJOR = "2.10"
  val SCALA_MINOR = "0"

  val SCALA = SCALA_MAJOR + "." + SCALA_MINOR

  val AKKA = "2.1.0"

  val SCALA_TEST = "1.9.1"
}

trait Dependencies extends Build with Versions {

  def cross(artifact: String) = artifact + "_" + SCALA_MAJOR

  def module(name: String, scope: String = "compile"): ModuleID = "com.typesafe.akka" % cross(name) % AKKA % scope

  val akka = Seq(module("akka-actor"), module("akka-testkit", "test"))

  val scalatest =  Seq("org.scalatest" % cross("scalatest") % SCALA_TEST % "test")

}
