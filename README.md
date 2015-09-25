# scala-adobe-fla

Flash Scala API ( .fla parser for Scala )

# Usage

## `build.sbt`

    resolvers += "scala-adobe-fla" at "http://turutosiya.github.io/scala-adobe-fla/"

    libraryDependencies += "com.turutosiya" % "scala-adobe-fla_2.11" % "0.2.2"
    
## code

### list all elements in .fla

    Fla("path/to/fla.fla")
      .document
        .timelines.map(
          _.layers.map(
            _.frames.map(
              _.elements).flatten).flatten).flatten