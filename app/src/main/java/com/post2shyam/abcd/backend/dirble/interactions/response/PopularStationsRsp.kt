package com.post2shyam.abcd.backend.dirble.interactions.response

data class PopularStationsRsp(
  val id: String,

  val twitter: String,

  val updated_at: String,

  val website: String,

  val facebook: String,

  val name: String,

  val created_at: String,

    // val image: Image,

//   val streams: Streams
//  [],

//   val categories: Categories
//  [],

  val slug: String,

  val total_listeners: String,

  val country: String
)
