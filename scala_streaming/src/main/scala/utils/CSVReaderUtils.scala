package utils

import com.github.tototoshi.csv.*

import java.io.{FileNotFoundException, IOException}
import zio.Console.*

object CSVReaderUtils {
  def openCSVReader(filename: String): CSVReader = {
    try {
      CSVReader.open(new java.io.File(filename))
    } catch {
      case e: FileNotFoundException =>
        println("Couldn't find that file.")
        throw e
      case e: IOException =>
        println("Had an IOException trying to read that file")
        throw e
    }
  }
}
