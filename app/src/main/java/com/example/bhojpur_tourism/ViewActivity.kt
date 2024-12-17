package com.example.bhojpur_tourism

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view)
       var modelItem:Model= intent.getSerializableExtra("data")as Model;
        modelItem.name?.let { Log.e("name", it) };

        val viewName=findViewById<TextView>(R.id.viewName)
        viewName.text=modelItem.name;
        val viewName1=findViewById<TextView>(R.id.viewName1)
        viewName1.text=modelItem.name1;
        viewName1.setMovementMethod(ScrollingMovementMethod());
        val viewImage=findViewById<ImageView>(R.id.viewImage)
        viewImage.setImageResource(modelItem.image!!);
    }
}