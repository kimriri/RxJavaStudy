package com.rxstudy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.rxstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btObserverPattern.setOnClickListener {
            this.startActivity(Intent(this, ObserverPatternActivity::class.java))
        }

        binding.btStream.setOnClickListener {
            this.startActivity(Intent(this, StreamExampleActivity::class.java))
        }

        binding.btSubject.setOnClickListener {
            this.startActivity(Intent(this, SubjectExampleActivity::class.java))
        }
    }
}