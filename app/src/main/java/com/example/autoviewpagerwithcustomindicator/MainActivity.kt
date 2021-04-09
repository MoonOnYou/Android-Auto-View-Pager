package com.example.autoviewpagerwithcustomindicator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var currentPage = 0
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val items = arrayListOf("안","녕","하","세","요")
        val adapter = Adapter(items)
        viewPager.adapter = adapter

        // period 반복주기 설정
        timer(period = 1000) {
            if (currentPage == items.size) {
                currentPage = 0
            }
            runOnUiThread {
                // UI 조작은 여기서
                viewPager.setCurrentItem(currentPage++, true)
            }
        }
    }
}