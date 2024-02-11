package com.tanish.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.tanish.todoapp.databinding.ActivitySplashSceenBinding

class SplashSceenActivity : AppCompatActivity() {

    private val binding : ActivitySplashSceenBinding by lazy {
        ActivitySplashSceenBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this,SIgnInActivity::class.java))
            finish()
        },2500)
    }

}