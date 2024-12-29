package com.example.bhojpur_tourism

import android.content.Intent
import android.graphics.ColorSpace
import android.net.Uri
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class ViewActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var buttonViewMore: Button
    private var isExpanded: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view)
        val buttonShowOnMap: Button = findViewById(R.id.buttonShowOnMap)
        buttonShowOnMap.setOnClickListener {
            // Replace with your desired location coordinates
            val latitude = 37.7749
            val longitude = -122.4194
            val geoUri = "geo:$latitude,$longitude?q=$latitude,$longitude(Some Place)"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(geoUri))
            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
        }
        var modelItem: Model = intent.getSerializableExtra("data")as Model;
        modelItem.name?.let { Log.e("name", it) };

        val viewName=findViewById<TextView>(R.id.viewName)
        viewName.text=modelItem.name

        val viewName1=findViewById<TextView>(R.id.viewName1)
        viewName1.text=modelItem.name1


        val viewImage=findViewById<ImageView>(R.id.viewImage)
        viewImage.setImageResource(modelItem.image!!)
        textView = findViewById(R.id.viewName1)
        buttonViewMore = findViewById(R.id.buttonViewMore)
        buttonViewMore.setOnClickListener {
            if (isExpanded) {
                textView.maxLines = 5
                buttonViewMore.text = "View More"
            } else {
                textView.maxLines = Integer.MAX_VALUE
                buttonViewMore.text = "View Less"
            }
            isExpanded = !isExpanded
        }
    }
}