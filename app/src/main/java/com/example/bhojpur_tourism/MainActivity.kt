package com.example.bhojpur_tourism

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
  var modelList = ArrayList<Model>()
    var names= arrayOf(
        "image1",
        "image2",
        "image3",
        "image4",
        "image5",
        "image6",
        "image7",
        "image8",
        "image9",
        "image10",
        "image11",
        "image12",
    )
    var images = intArrayOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8,
        R.drawable.image9,
        R.drawable.image10,
        R.drawable.image11,
        R.drawable.image12,

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in names.indices){
            modelList.add(Model(names[i],images[i]))
        }
        var customAdapter = CustomAdapter(modelList,this);
        val gridView=findViewById<GridView>(R.id.gridView)
        gridView.adapter= customAdapter
    }
    class CustomAdapter(
        var itemModel: ArrayList<Model>,
        var context:Context
    ): BaseAdapter(){

        var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        override fun getCount(): Int {
            return itemModel.size
        }

        override fun getItem(p0: Int): Any {
            return itemModel[p0]
        }

        override fun getItemId(p0: Int): Long {
           return p0.toLong()
        }

        override fun getView(position: Int, view: View?, viewGroup:  ViewGroup?): View {
           var view =view;
            if(view == null){
                view=layoutInflater.inflate(R.layout.row_items, viewGroup, false);
            }
            var tvImageName= view?.findViewById<TextView>(R.id.imageName)
            var imageView = view?.findViewById<ImageView>(R.id.imageView);
            tvImageName?.text= itemModel[position].name
            imageView?.setImageResource(itemModel[position].image!!)

            return view !!;
        }
    }
}