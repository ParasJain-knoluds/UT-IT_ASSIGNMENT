name := "UT-IT-ParasJain"

version := "0.1"

scalaVersion := "2.13.4"

lazy val UT = project.in(file("Question"))
  .settings(
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % Test
  )

lazy val UT_IT = project.in(file("Questions"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.3" % Test,
      "org.mockito" %% "mockito-scala" % "1.5.12" % Test
    )
  )

lazy val root = project.in(file(".")).aggregate(UT,UT_IT)