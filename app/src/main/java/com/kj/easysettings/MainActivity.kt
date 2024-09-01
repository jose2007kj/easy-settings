package com.kj.easysettings

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import androidx.activity.ComponentActivity

//import androidx.appcompat.app.AppCompatActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // This links your activity to the XML layout

        // Airplane Mode Button
        val airplaneModeButton: Button = findViewById(R.id.btn_airplane_mode)
        airplaneModeButton.setOnClickListener {
            val intent = Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS)
            startActivity(intent)
        }

        // Mobile Data Button
        val mobileDataButton: Button = findViewById(R.id.btn_mobile_data)
        mobileDataButton.setOnClickListener {

            val intent = Intent(Settings.ACTION_DATA_ROAMING_SETTINGS)
            startActivity(intent)
        }

        val volumeControlButton: Button = findViewById(R.id.btn_volume_control)
        volumeControlButton.setOnClickListener {
            val intent = Intent(Settings.ACTION_SOUND_SETTINGS)
            startActivity(intent)
        }
        val openMessageActivityButton: Button = findViewById(R.id.btnOpenMessageActivity)
        openMessageActivityButton.setOnClickListener {
            val intent = Intent(this, MessageActivity::class.java)
            startActivity(intent)
        }
    }
}