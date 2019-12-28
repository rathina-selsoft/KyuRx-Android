package com.selsoft.kyurx.model

class Prescription {

    var prescriptionId = 0
    var patientId = 0
    var patient: Patient? = null
    var doctorId = 0
    var doctor: Doctor? = null
    var medicines: MutableList<Medicine> = ArrayList()
    var createdDate: String? = null


}