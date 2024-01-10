package models

final case class Artist(
                   name: String,
                   ID: String,
                   gender: String,
                   age: Int,
                   country: String,
                   genres: List[String],
                   popularity: Int,
                   followers: Int,
                   URI: String
                 )