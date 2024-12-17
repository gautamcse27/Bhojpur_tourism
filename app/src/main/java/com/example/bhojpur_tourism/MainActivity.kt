package com.example.bhojpur_tourism

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout

class MainActivity : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

  var modelList = ArrayList<Model>()
    var names= arrayOf(
        "Veer Kunwar Singh",
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
    var names1= arrayOf(
        "Its description and greatness is written in the travelogues of Chinese travellers Fa-Hien and Huansang, " +
                "in the famous book 'A Statistical Account of Bengal, Part XII, page 214-215'" +
                " by Director General Dr W Hunter, by the then Commander of India General Cunningham, " +
                "in the famous book 'Jainism in Bihar (page 80 to 81)' by Dr PC Rai Chaudhary, " +
                "the then Special Officer of the Gazetteer Revision Branch of the Bihar Government," +
                " in the Shahabad District Census Handbook 1961 in the Shahabad District Gazetteer, " +
                "in the famous book 'Bal Brahmacharini Chandabai Abhinandan Granth', " +
                "in the famous research journal 'Tulsi Prajna', in the books of the famous Prakrit scholar " +
                "Dr Nemichand Shastri and Dr Rajaram Jain and in religious texts like Tirthkalp Vividh, Kalpasutra, Parshvanathcharitam etc.",
        "Temple1",
        "Temple2",
        "Temple3",
        "Temple4",
        "Temple5",
        "Temple6",
        "Temple7",
        "Temple8",
        "Temple9",
        "Temple10",
        "Temple11",
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

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.my_drawer_layout)
        actionBarDrawerToggle = ActionBarDrawerToggle(
            this, drawerLayout, R.string.nav_open,
            R.string.nav_close
        )

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        for (i in names.indices){
            modelList.add(Model(names[i],names1[i],images[i]))
        }
        var customAdapter = CustomAdapter(modelList,this);
        val gridView=findViewById<GridView>(R.id.gridView)
        gridView.adapter= customAdapter
        gridView.setOnItemClickListener {
            adapterView, view, i, l ->
            var intent = Intent(this, ViewActivity::class.java)
            intent.putExtra("data", modelList[i])
            startActivity(intent);
           }


        }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }
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
            //var tvImageName1= view?.findViewById<TextView>(R.id.imageName1)
            var imageView = view?.findViewById<ImageView>(R.id.imageView);

            tvImageName?.text= itemModel[position].name
           // tvImageName1?.text= itemModel[position].name1
            imageView?.setImageResource(itemModel[position].image!!)

            return view !!;
        }
    }
