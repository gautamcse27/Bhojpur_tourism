package com.example.bhojpur_tourism

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.GridView
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar;
import android.widget.TextView

import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle



  var modelList = ArrayList<Model>()
    var names= arrayOf(
        "Veer Kunwar Singh",
        "Ara Temple",
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
        "Singh led the Indian Rebellion of 1857 in Bihar. He was nearly eighty and in failing health when he was called upon to take up arms. " +
                "He was assisted by both his brother,behind Kunwar Singh's initial military success.[8] He was a tough opponent " +
                "and harried British forces for nearly a year. He was an expert in the art of guerilla warfare. His tactics sometimes left the British puzzled.[9]\n" +
                "\n" +
                "Singh assumed command of the soldiers who had revolted at Danapur on 25 July. Two days later he occupied Arrah," +
                " the district headquarters.  The army of Brigadier Douglas began" +
                " to shoot at their boat. One of the bullets shattered Singh's left wrist. Singh felt that his hand had become" +
                " useless and that there was the additional risk of infection due to the bullet-shot. He drew his sword and cut off" +
                " his left hand near the elbow and offered it to the Ganges." +
                " government in the district of Shahabad. ",
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



        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false) // Disable default title

        val toolbarTitle: TextView = findViewById(R.id.toolbar_title)
        toolbarTitle.text = "Your Custom Header Title"

        drawerLayout = findViewById(R.id.my_drawer_layout)
        val navView: NavigationView = findViewById(R.id.navigation_view)


        actionBarDrawerToggle = ActionBarDrawerToggle(
            this, drawerLayout, R.string.nav_open,
            R.string.nav_close
        )

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            // Handle navigation view item clicks here.
            when (it.itemId) {
                R.id.nav_account -> {
                    // Handle the home action
                }
                R.id.nav_settings -> {
                    // Handle the gallery action
                }
                R.id.nav_logout -> {
                    // Handle the slideshow action
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }



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
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
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
