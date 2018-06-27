package com.example.sk0g.fretguide

class TuningModel {
    var tuning: String?=null
    var time: Int?=null
    var type: String?=null
    var name: String?=null

    constructor(tuning: String, time: Int, type: String, name: String) {
        this.tuning = tuning
        this.time = time
        this.type = type
        this.name = name
    }
}