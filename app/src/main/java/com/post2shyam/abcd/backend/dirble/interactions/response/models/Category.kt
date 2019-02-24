package com.post2shyam.abcd.backend.dirble.interactions.response.models

import com.google.gson.annotations.SerializedName

data class Category(

  @SerializedName("id") val id: Int,
  @SerializedName("title") val title: String,
  @SerializedName("description") val description: String,
  @SerializedName("slug") val slug: String,
  @SerializedName("ancestry") val ancestry: Int
)