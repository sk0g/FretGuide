package com.example.sk0g.fretguide

class TuningModel {
    var notes: String?=null
    var time: Int?=null
    var type: String?=null
    var name: String?=null

    constructor(notes: String, time: Int, type: String, name: String) {
        this.notes = notes
        this.time = time
        this.type = type
        this.name = name
    }
}