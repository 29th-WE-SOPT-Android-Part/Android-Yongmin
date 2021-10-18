package org.sopt.androidassignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.GridLayoutManager
import org.sopt.androidassignment.databinding.FragmentFollowerListBinding

class FollowerList : Fragment() {
    private var _binding:FragmentFollowerListBinding? = null
    private val binding get() = _binding!!
    private lateinit var followerAdapter: FollowerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowerListBinding.inflate(layoutInflater, container, false)
        initAdapter()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initAdapter(){
        followerAdapter = FollowerAdapter()

        binding.rvFollower.adapter=followerAdapter
        followerAdapter.userList.addAll(
            listOf(
                UserData("권용민", "안드로이드 YB"),
                UserData("김용민", "서버 YB"),
                UserData("박용민", "IOS YB"),
                UserData("최용민", "웹 YB"),
                UserData("이용민", "기획 YB"),
                UserData("나용민", "디자인 YB")
            )
        )
        followerAdapter.notifyDataSetChanged()
    }
}