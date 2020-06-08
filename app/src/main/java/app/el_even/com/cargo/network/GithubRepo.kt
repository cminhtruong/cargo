package app.el_even.com.cargo.network

import com.squareup.moshi.Json

/**
 * @author el_even
 * @since 2020 June 8th
 * @version 1.0
 */
data class Items(@Json(name = "items") val githubRepos: List<GithubRepo>)

data class GithubRepo(
    val id: Long,
    @Json(name = "full_name") val name: String,
    val owner: Owner,
    @Json(name = "stargazers_count") val stargazersCount: Long
)

data class Owner(val id: Long, @Json(name = "avatar_url") val avatarUrl: String)