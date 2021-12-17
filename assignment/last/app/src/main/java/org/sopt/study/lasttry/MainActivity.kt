package org.sopt.study.lasttry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.study.lasttry.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val intent = Intent(this, SignupActivity::class.java)
        binding.textView4.setOnClickListener{
            startActivity(intent)
        }

        setContentView(binding.root)
    }
}