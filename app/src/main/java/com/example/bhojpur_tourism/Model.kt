package com.example.bhojpur_tourism

import java.io.Serializable


class Model : Serializable {
    var name:String? =null
    var name1:String? =null
    var image:Int? =null

    constructor( name:String,name1:String,image:Int){
        this.name=name;
        this.name1=name1;
        this.image=image;
    }
}