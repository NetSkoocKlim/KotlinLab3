package com.example.kotlinlab3


import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar: com.google.android.material.appbar.MaterialToolbar = findViewById(R.id.detailToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val dayNumber = intent.getIntExtra("DAY_NUMBER", 1)

        val tip = TipsDataSource.loadTips(this).find { it.dayNumber == dayNumber }

        tip?.let {
            findViewById<TextView>(R.id.tvDetailDay).text = getString(R.string.day_prefix) + it.dayNumber
            findViewById<TextView>(R.id.tvDetailTitle).setText(it.titleRes)
            findViewById<ImageView>(R.id.ivDetailImage).setImageResource(it.imageRes)
            findViewById<TextView>(R.id.tvDetailFullDescription).setText(it.fullDescRes)
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}