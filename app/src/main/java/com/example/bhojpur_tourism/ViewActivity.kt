package com.example.bhojpur_tourism

import android.os.Bundle
import android.util.Log
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view)
       var modelItem:Model= intent.getSerializableExtra("data")as Model;
        modelItem.name?.let { Log.e("name", it) };
        val viewName=findViewById<TextView>(R.id.viewName)
        viewName.text=modelItem.name;
        val viewImage=findViewById<ImageView>(R.id.viewImage)
        viewImage.setImageResource(modelItem.image!!);
    }
}