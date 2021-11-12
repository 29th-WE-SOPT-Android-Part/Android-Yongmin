package org.sopt.study.againassignment

import android.app.DownloadManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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

        setContentView(binding.root)
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
                if(response.isSuccessful){
                    val data = response.body()?.data

                    Toast.makeText(this@MainActivity, "${data?.email}님 반갑습니다!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@MainActivity, HomeActivity::class.java))
                } else
                    Toast.makeText(this@MainActivity, "로그인에 실패하셨습니다", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                Log.e("NetWorkTest", "error:$t")
            }
        })
    }
}