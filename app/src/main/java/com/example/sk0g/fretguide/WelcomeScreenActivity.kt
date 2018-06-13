package com.example.sk0g.fretguide

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class WelcomeScreenActivity : AppCompatActivity() {
    lateinit var mRecentTextView: TextView
    lateinit var mPresetTextView: TextView
    lateinit var mCustomTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)

        val context: Context = this

        mRecentTextView = findViewById(R.id.tuning_selector_recent_textview)
        mRecentTextView.setOnClickListener {
            selectRecentTuning(context)
        }

        mPresetTextView = findViewById(R.id.tuning_selector_preset_textview)
        mPresetTextView.setOnClickListener {
            selectPresetTuning(context)
        }

        mCustomTextView = findViewById(R.id.tuning_selector_custom_textview)
        mCustomTextView.setOnClickListener {
            selectCustomTuning(context)
        }
    }

    fun selectRecentTuning(context: Context) {
        Toast.makeText(context,"Recent", Toast.LENGTH_SHORT).show()
    }

    fun selectPresetTuning(context: Context) {
        Toast.makeText(context,"Present", Toast.LENGTH_SHORT).show()
    }

    fun selectCustomTuning(context: Context) {
        Toast.makeText(context,"Custom", Toast.LENGTH_SHORT).show()
    }

}
