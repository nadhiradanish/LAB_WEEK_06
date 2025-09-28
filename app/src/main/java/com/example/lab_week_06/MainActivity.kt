package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val catAdapter by lazy {
        //Glide is used here to load the images
        //Here we are passing the onClickListener function to the Adapter
        CatAdapter(layoutInflater, GlideImageLoader(this), object :
            CatAdapter.OnClickListener {
            //When this is triggered, the pop up dialog will be shown
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Setup the adapter for the recycler view
        recyclerView.adapter = catAdapter

        //Setup the layout manager for the recycler view
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )

        //attach swipe to delete to the recycler view
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        //Add data to the model list in the adapter
        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    Gender.Female,  // Luna female
                    CatBreed.Siamese,
                    "Luna",
                    "Playful and smart",
                    "https://cdn2.thecatapi.com/images/e0sS4bZcP.jpg"
                ),
                CatModel(
                    Gender.Male,    // Leo male
                    CatBreed.Bengal,
                    "Leo",
                    "Active and agile",
                    "https://cdn2.thecatapi.com/images/iWyIaja-G.jpg"
                ),
                CatModel(
                    Gender.Male,    // Milo male
                    CatBreed.Persian,
                    "Milo",
                    "Loves naps",
                    "https://cdn2.thecatapi.com/images/e7-hS3gey.jpg"
                ),
                CatModel(
                    Gender.Female,  // Coco female
                    CatBreed.BritishShorthair,
                    "Coco",
                    "Calm and friendly",
                    "https://cdn2.thecatapi.com/images/M1Rh3CPp_.jpg"
                ),
                CatModel(
                    Gender.Female,  // Nala female
                    CatBreed.MaineCoon,
                    "Nala",
                    "Gentle giant",
                    "https://cdn2.thecatapi.com/images/MtgMsxPw9.jpg"
                ),
                CatModel(
                    Gender.Male,    // Oscar male
                    CatBreed.RussianBlue,
                    "Oscar",
                    "Shy but loving",
                    "https://cdn2.thecatapi.com/images/zK-7AFYVn.jpg"
                ),
                CatModel(
                    Gender.Female,  // Chloe female
                    CatBreed.ScottishFold,
                    "Chloe",
                    "Curious explorer",
                    "https://cdn2.thecatapi.com/images/werXZVLvS.jpg"
                )
            )
        )
    }
        // fungsi ini sekarang di luar onCreate
    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}
