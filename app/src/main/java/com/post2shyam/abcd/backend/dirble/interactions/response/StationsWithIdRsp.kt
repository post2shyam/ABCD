package com.post2shyam.abcd.backend.dirble.interactions.response

import com.google.gson.annotations.SerializedName
import com.post2shyam.abcd.backend.dirble.interactions.response.models.Category
import com.post2shyam.abcd.backend.dirble.interactions.response.models.Image
import com.post2shyam.abcd.backend.dirble.interactions.response.models.Streams

data class StationsWithIdRsp(
  @SerializedName("categories")
  val categories: List<Category>,
  @SerializedName("country")
  val country: String,
  @SerializedName("description")
  val description: String,
  @SerializedName("id")
  val id: Int,
  @SerializedName("image")
  val image: Image,
  @SerializedName("name")
  val name: String,
  @SerializedName("slug")
  val slug: String,
  @SerializedName("streams")
  val streams: List<Streams>,
  @SerializedName("total_listeners")
  val totalListeners: Int,
  @SerializedName("website")
  val website: String
)


