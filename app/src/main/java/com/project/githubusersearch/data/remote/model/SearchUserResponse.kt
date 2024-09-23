package com.project.githubusersearch.data.remote.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchUserResponse(
    @Json(name = "incomplete_results")
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean? = null,
    @Json(name = "items")
    @SerializedName("items")
    val items: List<Item>? = null,
    @Json(name = "total_count")
    @SerializedName("total_count")
    val totalCount: Int? = null
) {
    data class Item(
        @Json(name = "avatar_url")
        @SerializedName("avatar_url")
        val avatarUrl: String? = null,
        @Json(name = "events_url")
        @SerializedName("events_url")
        val eventsUrl: String? = null,
        @Json(name = "followers_url")
        @SerializedName("followers_url")
        val followersUrl: String? = null,
        @Json(name = "following_url")
        @SerializedName("following_url")
        val followingUrl: String? = null,
        @Json(name = "gists_url")
        @SerializedName("gists_url")
        val gistsUrl: String? = null,
        @Json(name = "gravatar_id")
        @SerializedName("gravatar_id")
        val gravatarId: String? = null,
        @Json(name = "html_url")
        @SerializedName("html_url")
        val htmlUrl: String? = null,
        @Json(name = "id")
        @SerializedName("id")
        val id: Int? = null,
        @Json(name = "login")
        @SerializedName("login")
        val login: String? = null,
        @Json(name = "node_id")
        @SerializedName("node_id")
        val nodeId: String? = null,
        @Json(name = "organizations_url")
        @SerializedName("organizations_url")
        val organizationsUrl: String? = null,
        @Json(name = "received_events_url")
        @SerializedName("received_events_url")
        val receivedEventsUrl: String? = null,
        @Json(name = "repos_url")
        @SerializedName("repos_url")
        val reposUrl: String? = null,
        @Json(name = "score")
        @SerializedName("score")
        val score: Int? = null,
        @Json(name = "site_admin")
        @SerializedName("site_admin")
        val siteAdmin: Boolean? = null,
        @Json(name = "starred_url")
        @SerializedName("starred_url")
        val starredUrl: String? = null,
        @Json(name = "subscriptions_url")
        @SerializedName("subscriptions_url")
        val subscriptionsUrl: String? = null,
        @Json(name = "type")
        @SerializedName("type")
        val type: String? = null,
        @Json(name = "url")
        @SerializedName("url")
        val url: String? = null
    )
}