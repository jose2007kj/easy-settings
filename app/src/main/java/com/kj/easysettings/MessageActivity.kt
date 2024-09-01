package com.kj.easysettings

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
import androidx.activity.ComponentActivity

class MessageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        val editTextMessage: EditText = findViewById(R.id.editTextMessage)
        val textViewPreview: TextView = findViewById(R.id.textViewPreview)
        val btnPreviewMessage: Button = findViewById(R.id.btnPreviewMessage)
        val btnSendToWhatsApp: Button = findViewById(R.id.btnSendToWhatsApp)

        btnPreviewMessage.setOnClickListener {
            val message = editTextMessage.text.toString()
            textViewPreview.text = message

            // Enable the WhatsApp button only if there's a message
            btnSendToWhatsApp.isEnabled = message.isNotEmpty()
        }

        btnSendToWhatsApp.setOnClickListener {
            val message = textViewPreview.text.toString()
            if (message.isNotEmpty()) {
                sendToWhatsApp(message)
            }
        }
    }

    private fun sendToWhatsApp(message: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.setPackage("com.whatsapp")
        intent.putExtra(Intent.EXTRA_TEXT, message)
        try {
            startActivity(intent)
        } catch (ex: android.content.ActivityNotFoundException) {
            // WhatsApp is not installed, handle it here
        }
    }
}