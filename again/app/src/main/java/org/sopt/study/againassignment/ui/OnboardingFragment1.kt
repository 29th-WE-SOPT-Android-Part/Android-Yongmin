package org.sopt.study.againassignment.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import org.sopt.study.againassignment.R
import org.sopt.study.againassignment.databinding.FragmentOnboarding1Binding

class OnboardingFragment1 : Fragment() {
    private var _binding : FragmentOnboarding1Binding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnboarding1Binding.inflate(inflater, container, false)
        binding.tvNextbutton.setOnClickListener{
            findNavController().navigate(R.id.action_onboardingFragment1_to_onboardingFragment2)
        }
        return binding.root
    }
}