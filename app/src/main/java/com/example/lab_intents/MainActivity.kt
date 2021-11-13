package com.example.lab_intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val pickImage = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val explicitButton = findViewById<Button>(R.id.explicitButton)

        val textControl = findViewById<TextView>(R.id.textFromExp)

        val implicitButton = findViewById<Button>(R.id.implicitButton)

        val shareButton = findViewById<Button>(R.id.shareButton)

        val photoButton = findViewById<Button>(R.id.photoButton)


        val bundle: Bundle? = intent.extras

        if(bundle != null) {
            val editText = bundle.get("editText")
            textControl.setText(editText.toString())
        }

        explicitButton.setOnClickListener()
        {
            val explicitIntent = Intent(this, ExplicitActivity::class.java)
            val textValue = textControl.toString()
            explicitIntent.putExtra("textExp", textValue)
            startActivity(explicitIntent)
        }

        implicitButton.setOnClickListener()
        {
            val implicitIntent = Intent("mk.ukim.finki.mpip.IMPLICIT_ACTION")
            startActivity(implicitIntent)
        }

        shareButton.setOnClickListener()
        {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Content send from MainActivity")
                putExtra(Intent.EXTRA_TITLE, "MPiP Send Title")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

        photoButton.setOnClickListener()
        {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            val previewIntent = Intent(Intent.ACTION_VIEW)
            previewIntent.setDataAndType(data?.data, "image/*")
            startActivity(previewIntent)
        }
    }





}
