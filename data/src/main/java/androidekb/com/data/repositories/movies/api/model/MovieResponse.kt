package androidekb.com.data.repositories.movies.api.model

import com.google.gson.annotations.SerializedName

class MovieResponse(
    @SerializedName("id")
    val id: String,

    @SerializedName("poster")
    val poster: String?,

    @SerializedName("year")
    val year: Int?
)