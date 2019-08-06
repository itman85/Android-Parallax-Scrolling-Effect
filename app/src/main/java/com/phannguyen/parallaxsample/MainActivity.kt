package com.phannguyen.parallaxsample

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.AppBarLayout
import com.phannguyen.parallaxsample.gallery.GalleryAdapter

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var galleryAdapter:GalleryAdapter? =null

    private val imageUrls = listOf(R.drawable.airplane,R.drawable.arctichare,R.drawable.baboon,R.drawable.boat,R.drawable.frymire)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(true)

        toolbar.title = "Apps"

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        initGallery()
    }

    private fun initGallery(){
        gallery.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        galleryAdapter = GalleryAdapter(this,imageUrls)
        gallery.adapter = galleryAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.share -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
