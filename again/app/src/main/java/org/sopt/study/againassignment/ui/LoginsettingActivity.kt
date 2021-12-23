package org.sopt.study.againassignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.study.againassignment.server.SOPTSharedPreferences
import org.sopt.study.againassignment.databinding.ActivityLoginsettingBinding
import org.sopt.study.againassignment.databinding.ActivityMainBinding
import org.sopt.study.againassignment.shortToast

class LoginsettingActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginsettingBinding
    lateinit var binding2 : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginsettingBinding.inflate(layoutInflater)
        binding2 = ActivityMainBinding.inflate(layoutInflater)

        binding.btAutoRemove.setOnClickListener{
            binding2.ivAutoLogin.isSelected=false
            SOPTSharedPreferences.removeAutoLogin(this)
            shortToast("자동로그인 해제되었습니다")
            finish()
        }
        setContentView(binding.root)
    }
}