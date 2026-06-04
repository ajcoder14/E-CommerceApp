package com.aniket.e_commerceapp.data.model

import com.google.gson.annotations.SerializedName

data class ProductResponse(

    @SerializedName("status")
    val status: Int,

    @SerializedName("message")
    val message: String,

    @SerializedName("data")
    val data: ProductDataClass

)

data class ProductDataClass(

    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("price")
    val price: String,

    @SerializedName("final_price")
    val finalPrice: String,

    @SerializedName("brand_name")
    val brandName: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("images")
    val images: List<String>,

    @SerializedName("sku")
    val sku: String,

    @SerializedName("configurable_option")
    val configurableOption: List<ConfigurableOption>
)

data class ConfigurableOption(

    @SerializedName("attribute_id")
    val attributeId: Int,

    @SerializedName("type")
    val type: String,

    @SerializedName("attribute_code")
    val attributeCode: String,

    @SerializedName("attributes")
    val attributes: List<ProductAttribute>
)

data class ProductAttribute(

    @SerializedName("value")
    val value: String,

    @SerializedName("option_id")
    val optionId: String,

    @SerializedName("price")
    val price: String,

    @SerializedName("swatch_url")
    val swatchUrl: String,

    @SerializedName("images")
    val images: List<String>
)