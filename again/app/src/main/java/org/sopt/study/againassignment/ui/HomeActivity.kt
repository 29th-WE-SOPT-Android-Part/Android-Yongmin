package org.sopt.study.againassignment.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.study.againassignment.R
import org.sopt.study.againassignment.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
//    private var position = FIRST_POSITION
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)

        intent = Intent(this, LoginsettingActivity::class.java)
        binding.btLoginsetting.setOnClickListener{
            startActivity(intent)
        }

        setContentView(binding.root)
    }
}