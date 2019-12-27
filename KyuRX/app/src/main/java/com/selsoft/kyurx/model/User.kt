package com.selsoft.kyurx.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {

    @SerializedName("firstName")
    @Expose
    var firstName: String? = null

    @SerializedName("lastName")
    @Expose
    var lastName: String? = null

    @SerializedName("phoneNumber")
    @Expose
    var phoneNumber: String? = null

    @SerializedName("role")
    @Expose
    var role: String? = null

    @SerializedName("userStatus")
    @Expose
    var userStatus: String? = null

    @SerializedName("updatedBy")
    @Expose
    var updatedBy: Int = 0

    @SerializedName("userId")
    @Expose
    var userId: Int = 0


    @SerializedName("email")
    @Expose
    var email: String? = null

}