package org.sopt.androidassignment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidassignment.databinding.GitFollowerListBinding

class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>(){
    val userList = mutableListOf<FollowerData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FollowerViewHolder {
        val binding = GitFollowerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerAdapter.FollowerViewHolder, position: Int) {
        holder.onBind(userList[position])
    }

    override fun getItemCount(): Int = userList.size

    class FollowerViewHolder(private val binding : GitFollowerListBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun onBind(data:FollowerData){
            binding.tvFollowerName.text = data.name
            binding.tvFollowerIntroduce.text = data.introduction
        }
    }

}