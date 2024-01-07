// import zio._

// object MainApp extends ZIOAppDefault {
//   def run =
//     for {
//       _    <- Console.print("Please enter your name: ")
//       name <- Console.readLine
//       _    <- Console.printLine(s"Hello, $name!")
//     } yield ()
// }

// package zio_spotify.services

import zio.*
import zio.stream.ZStream
import com.github.tototoshi.csv.*
import zio.Console.*
import models.Artist

object MainApp extends ZIOAppDefault {

  override val run: ZIO[Any & ZIOAppArgs & Scope, Throwable, Unit] =
    for {
      artistStream <- createArtistStream("Artists.csv")
      _ <- artistStream.foreach(artist => Console.printLine(artist.toString))
    } yield ()

  
  private def createArtistStream(fileName: String): ZIO[Any, Throwable, ZStream[Any, Throwable, Artist]] =
    for {
      url <- ZIO.succeed(getClass.getClassLoader.getResource(fileName))
      source <- ZIO.succeed(CSVReader.open(url.getFile))
      artists <- ZIO.succeed(source.toStream
        .map(row => Artist(row.head, row(1), row(2), row(3), row(4), row(5), row(6), row(7), row(8))))
    } yield ZStream.fromIterable(artists)
}

//TODO: PART 2 Analyze -
// Popularité moyenne par Genre
// Genre (sexe) par Genre (musical) 
// Nombre de followers par Pays
// Distribution de l'age par Artiste
// Nombre de followers par Genre
