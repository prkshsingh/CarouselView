package com.prksh.carouselview

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.carouselexample.CarouselRVAdapter
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager2>(R.id.view_pager)

        viewPager.apply {
            clipChildren = false  // No clipping the left and right items
            clipToPadding = false  // Show the viewpager in full width without clipping the padding
            offscreenPageLimit = 3  // Render the left and right items
            (getChildAt(0) as RecyclerView).overScrollMode =
                RecyclerView.OVER_SCROLL_NEVER // Remove the scroll effect
        }

        val demoData = arrayListOf(
            "We have to fight with bad days to achieve to good days.",
            "Your future welcomes you if you use it your present wisely.",
            "Don't share your sorrows/stuggling part of your life to everyone. It's a feeling it can feel only by you not everyone.",
            "If you want a change the world then start from yourself.",
            "Think big then take small step everyday. Sometimes big achievement take lot of time be calm and continue, here rocket science won't work.",
            "Keep doing untill you achieve your goal.",
            "Be patient when you have nothing. Keep calm when you have everything.",
            "Birth and Death is the thing comes to you without asked. Rest of the things we have to go and ask for it.",
            "We cannot change the past. We cannot design our future But everything is possible in Present. So live in present.",
            "The thing is not meant for you doesn't last forever with you. Let go off everything.",
            "Anger is the punishment. It has a hidden logic “Use now and regret later”."
        )

        viewPager.adapter = CarouselRVAdapter(demoData)

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer((40 * Resources.getSystem().displayMetrics.density).toInt()))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = (0.80f + r * 0.20f)
        }
        viewPager.setPageTransformer(compositePageTransformer)
    }
}