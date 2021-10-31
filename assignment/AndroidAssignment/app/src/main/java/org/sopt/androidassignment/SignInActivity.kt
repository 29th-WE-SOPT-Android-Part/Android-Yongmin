package org.sopt.androidassignment

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import org.sopt.androidassignment.databinding.ActivitySignInBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)

        val intent = Intent(this, HomeActivity::class.java)
        binding.btLogin.setOnClickListener{
            var str = binding.etId.getText()
            var pw = binding.etPw.getText()
            if(!str.isEmpty() && !pw.isEmpty()){
                 Toast.makeText(this, "${str}님 환영합니다.", Toast.LENGTH_SHORT).show()
                 startActivity(intent)
                //initNetwork()
            }
            else{
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            }
        }

        val intent2 = Intent(this, SignUpActivity::class.java)
        binding.btSignin.setOnClickListener{
            startActivity(intent2)
        }

        val id = getIntent().getStringExtra("id")
        val pw = getIntent().getStringExtra("pw")

        binding.etId.setText(id)
        binding.etPw.setText(pw)



        setContentView(binding.root)
    }

//    private fun initNetwork(){
//        val requestLoginData = RequestLoginData(
//            //email = binding.etId.text.toString(),
//            binding.etId.text.toString(),
//            //password = binding.etPw.text.toString()
//            binding.etPw.text.toString()
//        )
//
//        val call: Call<ResponseLoginData> = ServiceCreator.sampleService.postLogin(requestLoginData)
//        call.enqueue(object : Callback<ResponseLoginData> {
//            override fun onResponse(
//                call: Call<ResponseLoginData>,
//                response: Response<ResponseLoginData>
//            ){
//                if(response.isSuccessful){
//                    val data = response.body()?.data
//
//                    Toast.makeText(this@SignInActivity, "${data?.email}님 반갑습니다!", Toast.LENGTH_SHORT).show()
//                    startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
//                } else
//                    Toast.makeText(this@SignInActivity, "로그인에 실패하셨습니다", Toast.LENGTH_LONG).show()
//            }
//
//            override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
//                TODO("Not yet implemented")
//                Log.e("NetworkText", "error:$t")
//            }
//        })
//    }
}