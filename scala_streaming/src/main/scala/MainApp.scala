import zio.*
import zio.stream.ZStream
import com.github.tototoshi.csv.*
import models.Artist
import zio.Console.*



object SpotifyMergeStreams extends ZIOAppDefault {
  
  override val run: ZIO[Any & ZIOAppArgs & Scope, Throwable, Unit] =
    for {
      artistStream <- createArtistStream("Artists.csv")
      artist <- artistStream.foreach(artist => Console.printLine(artist.toString))
    } yield ()

  private def createArtistStream(fileName: String): ZIO[Any, Throwable, ZStream[Any, Throwable, Artist]] =
    for {
      url <- ZIO.succeed(getClass.getClassLoader.getResource(fileName))
      source <- ZIO.succeed(CSVReader.open(url.getFile))
      artists <- ZIO.succeed(source.toStream
        .map(row => Artist(row.head, row(1), row(2), row(3), row(4), row(5), row(6), row(7), row(8))))
    } yield ZStream.fromIterable(artists)

}