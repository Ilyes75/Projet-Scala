import zio.*
import services.SpotifyDataService.createArtistStream
import zio.Console.*


object MainApp extends ZIOAppDefault {
  
 override val run: ZIO[Any & ZIOAppArgs & Scope, Throwable, Unit] =
    for {
      artistStream <- createArtistStream("Artists.csv")
      // simple print of each artist
      artist <- artistStream.foreach(artist => Console.printLine(artist.toString))

    } yield ()
}