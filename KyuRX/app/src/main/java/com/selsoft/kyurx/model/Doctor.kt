package com.selsoft.kyurx.model

class Doctor {

    var doctorId = 0
    var roleId = 0
    var userRole: UserRole? = null
    var firstName: String? = null
    var lastName: String? = null
    var imageUrl: String? = null
    var specialist: String? = null
    var qualification: String? = null
    var gender: String? = null
    var emailId: String? = null
    var phoneNumber: String? = null
    var lat = 0.0
    var lon = 0.0
    var hospitalId: String? = null
    var availability: String? = null
    var createdAt: Long = 0
    var updatedAt: Long = 0

}