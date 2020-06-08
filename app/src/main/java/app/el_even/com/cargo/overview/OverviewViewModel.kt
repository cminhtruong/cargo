package app.el_even.com.cargo.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.el_even.com.cargo.network.GithubApi
import app.el_even.com.cargo.network.GithubRepo
import app.el_even.com.cargo.network.Items
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 *
 * @author el_even
 * @since 2020 June 8th
 * @version 1.0
 */
class OverviewViewModel : ViewModel() {

    private val _items = MutableLiveData<Items>()
    val items: LiveData<Items>
        get() = _items

    private val _githubRepos = MutableLiveData<List<GithubRepo>>()
    val githubRepos: LiveData<List<GithubRepo>>
        get() = _githubRepos

    // Coroutines Job
    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        Timber.d("init OverviewViewModel")
        getGithubRepo()
    }

    private fun getGithubRepo() {
        coroutineScope.launch {
            val getGithubRepoDeferredAsync = GithubApi.retrofitService.getAllGithubRepoAsync()
            try {
                //_response.value = "Result: ${getGithubRepoDeferredAsync.await()}"
                val listResult = getGithubRepoDeferredAsync.await()
                _items.value = listResult
                _githubRepos.value = _items.value?.githubRepos
                Timber.d("Result: ${_githubRepos.value.toString()}")
                //Timber.d(_response.value)
            } catch (e: Exception) {
                // _response.value = "Error with ${e.message}"
            }
        }
    }
}
