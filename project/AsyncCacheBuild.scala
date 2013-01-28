import sbt._
import sbt.Keys._

object AsyncCacheBuild extends Build {

  lazy val asynccache = Project(
    id = "asynccache",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "AsyncCache",
      organization := "org.async",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.0",
      resolvers += "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases",
      libraryDependencies += "com.typesafe.akka" % "akka-actor_2.10" % "2.1.0"
    )
  )
}
