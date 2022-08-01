package com.example.starwarswiki.model

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

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
    @Serializable(with = RomanNumberSerializer::class)
    val episode: String,

    @SerialName("director")
    val director: String,

    @SerialName("producer")
    val producer: String,

    @SerialName("release_date")
    val releaseDate: String,

    @SerialName("opening_crawl")
    val openingCrawl: String
)

@Serializer(forClass = Film::class)
object RomanNumberSerializer : KSerializer<String> {
    private val romanLetters = mapOf(
        1000 to "M",
        900 to "CM",
        500 to "D",
        400 to "CD",
        100 to "C",
        90 to "XC",
        50 to "L",
        40 to "XL",
        10 to "X",
        9 to "IX",
        5 to "V",
        4 to "IV",
        1 to "I"
    )

    override val descriptor: SerialDescriptor =
        buildClassSerialDescriptor("RomanNumberTypeSerializer")

    override fun serialize(encoder: Encoder, value: String) {
        var initialValue = value.uppercase()
        var resultArabic = 0

        while (initialValue.isNotBlank()) {
            for ((k, v) in romanLetters) {
                if (initialValue.startsWith(v)) {
                    initialValue = initialValue.substring(v.length, initialValue.length)
                    resultArabic += k
                    break
                }
            }
        }
        encoder.encodeInt(resultArabic)
    }

    override fun deserialize(decoder: Decoder): String {
        var initialValue = decoder.decodeInt()
        var resultRoman = ""

        while (initialValue > 0) {
            for ((k, v) in romanLetters) {
                if (initialValue >= k) {
                    initialValue -= k
                    resultRoman += v
                    break
                }
            }
        }
        return resultRoman
    }
}


