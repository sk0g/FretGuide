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

        mRecentTextView = findViewById(R.id.welcome_screen_recent_textview)
        mRecentTextView.setOnClickListener {
            selectRecentTuning(context)
        }

        mPresetTextView = findViewById(R.id.welcome_screen_preset_textview)
        mPresetTextView.setOnClickListener {
            selectPresetTuning(context)
        }

        mCustomTextView = findViewById(R.id.welcome_screen_custom_textview)
        mCustomTextView.setOnClickListener {
            selectCustomTuning(context)
        }
    }

    fun selectRecentTuning(context: Context) {
        // TODO: Switch to Recents screen
        toastText(context,"Recent")
    }

    fun selectPresetTuning(context: Context) {
        // TODO: Switch to Presets screen
        toastText(context,"Present")
    }

    fun selectCustomTuning(context: Context) {
        // TODO: Switch to Custom Tuning Screen
        toastText(context,"Custom")
    }

    fun toastText(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}
