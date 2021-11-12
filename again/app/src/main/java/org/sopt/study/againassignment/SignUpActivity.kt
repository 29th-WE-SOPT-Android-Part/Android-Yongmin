package org.sopt.study.againassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import org.sopt.study.againassignment.databinding.ActivitySignUpBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    lateinit var binding : ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        binding.btSignup.setOnClickListener{
            initNetwork()
        }
        setContentView(binding.root)
    }

    private fun initNetwork(){
        val requestSignupData = RequestSignupData(
            id = binding.etSignupId.text.toString(),
            name = binding.etSignupName.text.toString(),
            password = binding.etSignupPw.text.toString()
        )

        val call: Call<ResponseSignupData> = ServiceCreator.signup.postSignup(requestSignupData)

        call.enqueue(object: Callback<ResponseSignupData> {
            override fun onResponse(
                call: Call<ResponseSignupData>,
                response: Response<ResponseSignupData>
            ) {
                if(response.isSuccessful){
                    val data = response.body()?.data

                    Toast.makeText(this@SignUpActivity, "${data?.email}님 회원가입 되었습니다!", Toast.LENGTH_SHORT).show()
                    finish()
                } else
                    Toast.makeText(this@SignUpActivity, "회원가입에 실패하셨습니다", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<ResponseSignupData>, t: Throwable) {
                Log.e("NetWorkTest", "error:$t")
            }
        })
    }
}