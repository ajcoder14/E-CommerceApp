package com.aniket.e_commerceapp.ui.product

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.aniket.e_commerceapp.R

class LauncherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        Handler(Looper.getMainLooper()).postDelayed({

            startActivity(
                Intent(
                    this,
                    ProductActivity::class.java
                )
            )

            finish()

        }, 2000)
    }
}