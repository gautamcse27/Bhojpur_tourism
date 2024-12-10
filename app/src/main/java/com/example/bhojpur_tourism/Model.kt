package com.example.bhojpur_tourism

import java.io.Serializable


class Model : Serializable {
    var name:String? =null
    var image:Int? =null

    constructor( name:String,image:Int){
        this.name=name;
        this.image=image;
    }
}