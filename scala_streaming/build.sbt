// val scala3Version = "3.3.1"

// val zioVersion = "2.0.20"

// lazy val root = project
//   .in(file("."))
//   .settings(
//     name := "scala_streaming",
//     version := "0.1.0-SNAPSHOT",

//     scalaVersion := scala3Version,

//     libraryDependencies ++= Seq(
//       "dev.zio" %% "zio"         % zioVersion,
//       "dev.zio" %% "zio-streams" % zioVersion
//     ),

//     libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test
//   )
ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

lazy val root = (project in file("."))
  .settings(
    name := "ZIO_Streams_Spotify",
      libraryDependencies += "dev.zio" %% "zio-streams" % "2.0.20",
        libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.3.10"
  )