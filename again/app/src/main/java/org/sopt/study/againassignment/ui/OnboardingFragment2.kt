package org.sopt.study.againassignment.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import org.sopt.study.againassignment.R
import org.sopt.study.againassignment.databinding.FragmentOnboarding2Binding

class OnboardingFragment2 : Fragment() {
    private var _binding:FragmentOnboarding2Binding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnboarding2Binding.inflate(inflater, container, false)
        binding.tvNextbutton.setOnClickListener{
            findNavController().navigate(R.id.action_onboardingFragment2_to_onboardingFragment3)
        }
        return binding.root
    }
}