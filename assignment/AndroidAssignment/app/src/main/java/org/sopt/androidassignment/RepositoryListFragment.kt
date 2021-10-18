package org.sopt.androidassignment

import android.annotation.SuppressLint
import android.graphics.drawable.ClipDrawable.VERTICAL
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidassignment.databinding.FragmentRepositoryListBinding

class RepositoryListFragment : Fragment() {
    private var _binding : FragmentRepositoryListBinding? = null
    private val binding get() = _binding!!
    private lateinit var repositoryAdapter: RepositoryAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepositoryListBinding.inflate(layoutInflater, container, false)
        initAdapter()
        binding.rvRepository.adapter = repositoryAdapter
        binding.rvRepository.layoutManager=GridLayoutManager(activity, 2)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initAdapter(){
        repositoryAdapter = RepositoryAdapter()

        binding.rvRepository.adapter=repositoryAdapter
        repositoryAdapter.repoList.addAll(
            listOf(
                RepositoryData("안드로이드 과제1\n레포지토리", "1주차 과제"),
                RepositoryData("안드로이드 과제2\n레포지토리", "글자수 제한을 체크하겠습니다."),
                RepositoryData("왕초보 스터디\n레포지토리", "제못제잘 과제"),
                RepositoryData("코틀린 스터디\n레포지토리", "코틀린 가만안드.. 과제"),
                RepositoryData("솝탁 스터디\n레포지토리", "알고리즘 과제"),
                RepositoryData("풋살 스터디\n레포지토리", "개발스터디란 우리가 개발이라는"),

            )
        )
    }
}