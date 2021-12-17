package org.sopt.study.againassignment.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.sopt.study.againassignment.*
import org.sopt.study.againassignment.data.RequestLoginData
import org.sopt.study.againassignment.data.ResponseLoginData
import org.sopt.study.againassignment.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val intent = Intent(this, SignUpActivity::class.java)
        binding.tvLoginSignUp.setOnClickListener{
            startActivity(intent)
        }

        binding.btLogin.setOnClickListener{
            initNetwork()
        }

        initClickEvent()
        isAutoLogin()

        setContentView(binding.root)
    }

    private fun initClickEvent(){
        binding.ivAutoLogin.setOnClickListener{
            binding.ivAutoLogin.isSelected = !binding.ivAutoLogin.isSelected

            SOPTSharedPreferences.setAutoLogin(this, binding.ivAutoLogin.isSelected)
        }
    }

    private fun isAutoLogin(){
        if(SOPTSharedPreferences.getAutoLogin(this)){
            shortToast("자동로그인 되었습니다.")
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

    private fun initNetwork(){
        val requestLoginData = RequestLoginData(
            id = binding.etLoginId.text.toString(),
            password = binding.etLoginPw.text.toString()
        )

        val call: Call<ResponseLoginData> = ServiceCreator.sampleService.postLogin(requestLoginData)

        call.enqueue(object:Callback<ResponseLoginData> {
            override fun onResponse(
                call: Call<ResponseLoginData>,
                response: Response<ResponseLoginData>
            ) {
               shortToast("서버통신 성공")
               startActivity(Intent(this@MainActivity, HomeActivity::class.java))
            }

            override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                Log.e("NetWorkTest", "error:$t")
            }
        })
    }


}