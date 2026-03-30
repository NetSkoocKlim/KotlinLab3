package com.example.kotlinlab3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val toolbar: com.google.android.material.appbar.MaterialToolbar = findViewById(R.id.mainToolbar)
        setSupportActionBar(toolbar)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val tipsList = TipsDataSource.loadTips(this)

        val adapter = TipsAdapter(tipsList) { clickedTip ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("DAY_NUMBER", clickedTip.dayNumber)
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }
}