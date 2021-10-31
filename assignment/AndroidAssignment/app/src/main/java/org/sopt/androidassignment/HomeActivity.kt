package org.sopt.androidassignment


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import org.sopt.androidassignment.databinding.ActivityHomeBinding
import org.sopt.androidassignment.databinding.FragmentProfileBinding


class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    private var position = FOLL_FRAGMENT
    private lateinit var binding2 : FragmentProfileBinding
    private lateinit var sampleViewPagerAdapter: SampleViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)

        initAdapter()
        initBottomNavigation()
        //initTransactionEvent()
        setContentView(binding.root)
    }

    private fun initAdapter(){

        val fragmentList = listOf(ProfileFragment(), HomeFragment(), CameraFragment())

        sampleViewPagerAdapter = SampleViewPagerAdapter(this)
        sampleViewPagerAdapter.fragments.addAll(fragmentList)

        binding.vpSample.adapter = sampleViewPagerAdapter
    }

    private fun initBottomNavigation(){
        binding.vpSample.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.bnvSample.menu.getItem(position).isChecked=true
            }
        })

        binding.bnvSample.setOnItemSelectedListener{
            when(it.itemId){
                R.id.menu_android->{
                    binding.vpSample.currentItem=FIRST_FRAGMENT
                    return@setOnItemSelectedListener true
                }
                R.id.menu_list->{
                    binding.vpSample.currentItem= SECOND_FRAGMENT
                    return@setOnItemSelectedListener true
                }
                else->{
                    binding.vpSample.currentItem= THIRD_FRAGMENT
                    return@setOnItemSelectedListener true
                }
            }
        }
    }

    companion object{
        const val FIRST_FRAGMENT=0
        const val SECOND_FRAGMENT=1
        const val THIRD_FRAGMENT=2

        const val FOLL_FRAGMENT = 1
        const val REPO_FRAGMENT = 2
    }

    fun initTransactionEvent(){
        val fragment1 = FollowerList()
        val fragment2 = RepositoryListFragment()
        supportFragmentManager.beginTransaction().add(R.id.container_fragment, fragment1).commit()

        binding2.btHomeFollower.setOnClickListener{
            val transaction = supportFragmentManager.beginTransaction()

            when(position){
                FOLL_FRAGMENT->{
                    transaction.replace(R.id.container_fragment, fragment1)
                    position = FOLL_FRAGMENT
                }
                REPO_FRAGMENT->{
                    transaction.replace(R.id.container_fragment, fragment1)
                    position= FOLL_FRAGMENT
                }
            }
            transaction.commit()
        }
        binding2.btHomeRepository.setOnClickListener{
            val transaction = supportFragmentManager.beginTransaction()
            when(position){
                FOLL_FRAGMENT->{
                    transaction.replace(R.id.container_fragment, fragment2)
                    position= REPO_FRAGMENT
                }
                REPO_FRAGMENT->{
                    transaction.replace(R.id.container_fragment, fragment2)
                    position= REPO_FRAGMENT
                }
            }

            transaction.commit()
        }
    }

}