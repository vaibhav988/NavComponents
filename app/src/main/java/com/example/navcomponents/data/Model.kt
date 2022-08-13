package com.example.navcomponents.data

import com.example.navcomponents.data.Articles
import com.google.gson.annotations.SerializedName


data class Model (



  @SerializedName("status"       ) var status       : String?             = null,
  @SerializedName("totalResults" ) var totalResults : Int?                = null,
  @SerializedName("articles"     ) var articles     : List<Articles>

)
