package com.example.starwarswiki.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FilmsPage(
    @SerialName("count")
    val count: Int,

    @SerialName("next")
    val nextUrl: String?,

    @SerialName("previous")
    val prevUrl: String?,

    @SerialName("results")
    val results: List<Film>
)

@Serializable
data class Film(
    @SerialName("title")
    val title: String,

    @SerialName("episode_id")
    val episodeId: Int,

    @SerialName("director")
    val director: String,

    @SerialName("producer")
    val producer: String,

    @SerialName("release_date")
    val releaseDate: String,

    @SerialName("opening_crawl")
    val openingCrawl: String
)


