package com.selsoft.kyurx.model

class Patient {

    var patientId = 0
    var roleId = 0
    var userRole: UserRole? = null
    var firstName: String? = null
    var lastName: String? = null
    var imageUrl: String? = null
    var gender: String? = null
    var emailId: String? = null
    var phoneNumber: String? = null
    var createdAt: Long = 0
    var updatedAt: Long = 0

}