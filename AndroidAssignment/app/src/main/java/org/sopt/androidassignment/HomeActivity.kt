package org.sopt.androidassignment

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.Intent.createChooser
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.sopt.androidassignment.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        val address : Intent = Uri.parse("https://github.com/briandr97").let{webpage->Intent(Intent.ACTION_VIEW, webpage)}

        //val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/briandr97"))


        binding.btHomeGit.setOnClickListener{
            //val intent = Intent(Intent.ACTION_SEND)
            //val title = resources.getString(R.string.chooser_title)
            //val chooser = createChooser(intent, title)
            try{
                startActivity(address)
            }catch(e:ActivityNotFoundException){
                Toast.makeText(this, "실행할 수 있는 앱이 없습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        setContentView(binding.root)
    }
}