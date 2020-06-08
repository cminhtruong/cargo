package app.el_even.com.cargo.overview

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.el_even.com.cargo.R
import app.el_even.com.cargo.databinding.OverviewFragmentBinding
import timber.log.Timber

/**
 * @author el_even
 * @since 2020 June 8th
 * @version 1.0
 */
class OverviewFragment : Fragment() {

    companion object {
        fun newInstance() = OverviewFragment()
    }

    private val viewModel: OverviewViewModel by lazy {
        ViewModelProviders.of(this).get(OverviewViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("onCreateView")
        val binding = OverviewFragmentBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.photosGrid.adapter = GithubRepoAdapter()

        return binding.root
    }
}
