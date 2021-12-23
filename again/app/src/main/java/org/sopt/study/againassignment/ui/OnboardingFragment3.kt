package org.sopt.study.againassignment.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import org.sopt.study.againassignment.R
import org.sopt.study.againassignment.databinding.FragmentOnboarding3Binding

class OnboardingFragment3 : Fragment() {

    private var _binding:FragmentOnboarding3Binding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentOnboarding3Binding.inflate(inflater, container, false)
        Glide.with(binding.ivOnboardprofile).load(R.drawable.myface).circleCrop().into(binding.ivOnboardprofile)
        binding.tvNextbutton.setOnClickListener{
            findNavController().navigate(R.id.action_onboardingFragment3_to_mainActivity)
            (activity as StartActivity).finish()
        }
        return binding.root
    }
}