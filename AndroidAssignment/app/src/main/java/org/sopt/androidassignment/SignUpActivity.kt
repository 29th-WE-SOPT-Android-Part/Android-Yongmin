package org.sopt.androidassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.sopt.androidassignment.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)

        binding.btSu.setOnClickListener {
            var name = binding.etName.text
            var id = binding.etSuId.text
            var pw = binding.etSuPw.text

            if(!name.isEmpty() && !id.isEmpty() && !pw.isEmpty()){
                val intent3 = Intent(this, SignInActivity::class.java)
                intent3.putExtra("id", id.toString())
                intent3.putExtra("pw", pw.toString())
                startActivity(intent3)
                Toast.makeText(this, "가입되었습니다", Toast.LENGTH_SHORT).show()
                finish()
            }
            else{
                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
            }
        }
        setContentView(binding.root)
    }
}