package com.project.githubusersearch.data.remote.model


import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DetailUserResponse(
    @Json(name = "avatar_url")
    @SerializedName("avatar_url")
    val avatarUrl: String? = null,
    @Json(name = "bio")
    @SerializedName("bio")
    val bio: String? = null,
    @Json(name = "blog")
    @SerializedName("blog")
    val blog: String? = null,
    @Json(name = "company")
    @SerializedName("company")
    val company: String? = null,
    @Json(name = "created_at")
    @SerializedName("created_at")
    val createdAt: String? = null,
    @Json(name = "email")
    @SerializedName("email")
    val email: String? = null,
    @Json(name = "events_url")
    @SerializedName("events_url")
    val eventsUrl: String? = null,
    @Json(name = "followers")
    @SerializedName("followers")
    val followers: Int? = null,
    @Json(name = "followers_url")
    @SerializedName("followers_url")
    val followersUrl: String? = null,
    @Json(name = "following")
    @SerializedName("following")
    val following: Int? = null,
    @Json(name = "following_url")
    @SerializedName("following_url")
    val followingUrl: String? = null,
    @Json(name = "gists_url")
    @SerializedName("gists_url")
    val gistsUrl: String? = null,
    @Json(name = "gravatar_id")
    @SerializedName("gravatar_id")
    val gravatarId: String? = null,
    @Json(name = "hireable")
    @SerializedName("hireable")
    val hireable: Boolean? = null,
    @Json(name = "html_url")
    @SerializedName("html_url")
    val htmlUrl: String? = null,
    @Json(name = "id")
    @SerializedName("id")
    val id: Int? = null,
    @Json(name = "location")
    @SerializedName("location")
    val location: String? = null,
    @Json(name = "login")
    @SerializedName("login")
    val login: String? = null,
    @Json(name = "name")
    @SerializedName("name")
    val name: String? = null,
    @Json(name = "node_id")
    @SerializedName("node_id")
    val nodeId: String? = null,
    @Json(name = "organizations_url")
    @SerializedName("organizations_url")
    val organizationsUrl: String? = null,
    @Json(name = "public_gists")
    @SerializedName("public_gists")
    val publicGists: Int? = null,
    @Json(name = "public_repos")
    @SerializedName("public_repos")
    val publicRepos: Int? = null,
    @Json(name = "received_events_url")
    @SerializedName("received_events_url")
    val receivedEventsUrl: String? = null,
    @Json(name = "repos_url")
    @SerializedName("repos_url")
    val reposUrl: String? = null,
    @Json(name = "site_admin")
    @SerializedName("site_admin")
    val siteAdmin: Boolean? = null,
    @Json(name = "starred_url")
    @SerializedName("starred_url")
    val starredUrl: String? = null,
    @Json(name = "subscriptions_url")
    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String? = null,
    @Json(name = "twitter_username")
    @SerializedName("twitter_username")
    val twitterUsername: String? = null,
    @Json(name = "type")
    @SerializedName("type")
    val type: String? = null,
    @Json(name = "updated_at")
    @SerializedName("updated_at")
    val updatedAt: String? = null,
    @Json(name = "url")
    @SerializedName("url")
    val url: String? = null
)