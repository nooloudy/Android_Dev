package Models

import com.google.gson.annotations.SerializedName

data class CatModel(
    @SerializedName("image_link") var imageLink: String? = null,
    @SerializedName("family_friendly") var familyFriendly: Int? = null,
    @SerializedName("shedding") var shedding: Int? = null,
    @SerializedName("min_weight") var minWeight: Float? = null,
    @SerializedName("max_weight") var maxWeight: Float? = null,
    @SerializedName("name") var name: String? = null
)
