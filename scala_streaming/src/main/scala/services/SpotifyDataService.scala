package services

import com.github.tototoshi.csv.*
import models.Artist
import zio.*
import zio.Console.*
import zio.stream.ZStream
import utils.CSVReaderUtils
object SpotifyDataService{

  def createArtistStream(fileName: String): ZIO[Any, Throwable, ZStream[Any, Throwable, Artist]] =
    for {
      url <- ZIO.succeed(getClass.getClassLoader.getResource(fileName))
      source <- ZIO.succeed(CSVReaderUtils.openCSVReader(url.getFile))
      artists <- ZIO.succeed(source.toStream.drop(1)
        .map(row => Artist(row.head, row(1), row(2), row(3).toInt, row(4), row(5).split(',').toList, row(6).toInt, row(7).toInt, row(8))))
    } yield ZStream.fromIterable(artists)
}

/* example of display :
  Artist(Vertical Horizon,6Hizgjo92FnMp8wGaRUNTn,mixed,29,,List(['neo mellow',  'pop rock',  'post-grunge']),
  48,431277,spotify:artist:6Hizgjo92FnMp8wGaRUNTn)
*/