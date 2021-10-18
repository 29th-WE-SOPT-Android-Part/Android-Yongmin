package org.sopt.androidassignment

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.sopt.androidassignment.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    private var position = FIRST_FRAGMENT
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

        initTransactionEvent()
        setContentView(binding.root)
    }

    fun initTransactionEvent(){
        val fragment1 = FollowerList()
        val fragment2 = RepositoryListFragment()
        supportFragmentManager.beginTransaction().add(R.id.container_fragment, fragment1).commit()

        binding.btHomeFollower.setOnClickListener{
            val transaction = supportFragmentManager.beginTransaction()

            when(position){
                FIRST_FRAGMENT->{
                    transaction.replace(R.id.container_fragment, fragment1)
                    position = FIRST_FRAGMENT
                }
                SECOND_FRAGMENT->{
                    transaction.replace(R.id.container_fragment, fragment1)
                    position= FIRST_FRAGMENT
                }
            }
            transaction.commit()
        }
        binding.btHomeRepository.setOnClickListener{
            val transaction = supportFragmentManager.beginTransaction()
            when(position){
                FIRST_FRAGMENT->{
                    transaction.replace(R.id.container_fragment, fragment2)
                    position= SECOND_FRAGMENT
                }
                SECOND_FRAGMENT->{
                    transaction.replace(R.id.container_fragment, fragment2)
                    position= SECOND_FRAGMENT
                }
            }

            transaction.commit()
        }
    }

    companion object{
        const val FIRST_FRAGMENT = 1
        const val SECOND_FRAGMENT = 2
    }
}