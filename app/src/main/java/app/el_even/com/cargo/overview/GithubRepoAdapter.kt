package app.el_even.com.cargo.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import app.el_even.com.cargo.databinding.GithubRepoItemBinding
import app.el_even.com.cargo.network.GithubRepo

class GithubRepoAdapter() :
    ListAdapter<GithubRepo, GithubRepoAdapter.GithubRepoViewHolder>(DiffCallBack) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GithubRepoAdapter.GithubRepoViewHolder = GithubRepoViewHolder(
        GithubRepoItemBinding.inflate(
            LayoutInflater.from(parent.context)
        )
    )

    override fun onBindViewHolder(holder: GithubRepoAdapter.GithubRepoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class GithubRepoViewHolder(private var binding: GithubRepoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(githubRepo: GithubRepo) {
            binding.repo = githubRepo
            binding.executePendingBindings()
        }
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<GithubRepo>() {
        override fun areItemsTheSame(oldItem: GithubRepo, newItem: GithubRepo): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: GithubRepo, newItem: GithubRepo): Boolean {
            return oldItem.id == newItem.id
        }

    }
}