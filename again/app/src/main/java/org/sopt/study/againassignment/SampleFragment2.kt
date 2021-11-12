package org.sopt.study.againassignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.study.againassignment.databinding.FragmentSample1Binding
import org.sopt.study.againassignment.databinding.FragmentSample2Binding


class SampleFragment2 : Fragment() {

    private var _binding: FragmentSample2Binding? = null
    private val binding get() = _binding ?: error("Binding이 초기화 되지 않았습니다.")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSample2Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}