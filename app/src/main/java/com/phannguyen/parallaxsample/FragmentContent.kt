package com.phannguyen.parallaxsample

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.phannguyen.parallaxsample.gallery.GalleryAdapter
import kotlinx.android.synthetic.main.fragment_content.*

class FragmentContent:Fragment() {

    var galleryAdapter:GalleryAdapter? =null

    private val imageUrls = listOf(R.drawable.airplane,R.drawable.arctichare,R.drawable.baboon,R.drawable.boat,R.drawable.frymire)


    companion object {
        fun createInstance():FragmentContent = FragmentContent()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_content,container,false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*(activity as AppCompatActivity).setSupportActionBar(toolbar)

        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(true)

        toolbar.title = "Apps"*/

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        initGallery()
    }
    private fun initGallery(){
        gallery.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL,false)
        galleryAdapter = GalleryAdapter(this.requireContext(),imageUrls)
        gallery.adapter = galleryAdapter

    }

   /* override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }*/

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