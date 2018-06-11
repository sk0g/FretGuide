package com.example.sk0g.fretguide

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TuningSelectorActivity : AppCompatActivity() {
    lateinit var mRecentTextView: TextView
    lateinit var mPresetTextView: TextView
    lateinit var mCustomTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tuning_selector)

        mRecentTextView = findViewById(R.id.tuning_selector_recent_textview)
        mRecentTextView.setOnClickListener {  }

        mPresetTextView = findViewById(R.id.tuning_selector_preset_textview)
        mPresetTextView.setOnClickListener {  }

        mCustomTextView = findViewById(R.id.tuning_selector_custom_textview)
        mCustomTextView.setOnClickListener {  }
    }
}
