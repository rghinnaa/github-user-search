package com.project.githubusersearch.data.remote.model


import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class PublicRepositoryUserResponse(
    @Json(name = "archive_url")
    @SerializedName("archive_url")
    val archiveUrl: String? = null,
    @Json(name = "archived")
    @SerializedName("archived")
    val archived: Boolean? = null,
    @Json(name = "assignees_url")
    @SerializedName("assignees_url")
    val assigneesUrl: String? = null,
    @Json(name = "blobs_url")
    @SerializedName("blobs_url")
    val blobsUrl: String? = null,
    @Json(name = "branches_url")
    @SerializedName("branches_url")
    val branchesUrl: String? = null,
    @Json(name = "clone_url")
    @SerializedName("clone_url")
    val cloneUrl: String? = null,
    @Json(name = "collaborators_url")
    @SerializedName("collaborators_url")
    val collaboratorsUrl: String? = null,
    @Json(name = "comments_url")
    @SerializedName("comments_url")
    val commentsUrl: String? = null,
    @Json(name = "commits_url")
    @SerializedName("commits_url")
    val commitsUrl: String? = null,
    @Json(name = "compare_url")
    @SerializedName("compare_url")
    val compareUrl: String? = null,
    @Json(name = "contents_url")
    @SerializedName("contents_url")
    val contentsUrl: String? = null,
    @Json(name = "contributors_url")
    @SerializedName("contributors_url")
    val contributorsUrl: String? = null,
    @Json(name = "created_at")
    @SerializedName("created_at")
    val createdAt: String? = null,
    @Json(name = "default_branch")
    @SerializedName("default_branch")
    val defaultBranch: String? = null,
    @Json(name = "deployments_url")
    @SerializedName("deployments_url")
    val deploymentsUrl: String? = null,
    @Json(name = "description")
    @SerializedName("description")
    val description: String? = null,
    @Json(name = "disabled")
    @SerializedName("disabled")
    val disabled: Boolean? = null,
    @Json(name = "downloads_url")
    @SerializedName("downloads_url")
    val downloadsUrl: String? = null,
    @Json(name = "events_url")
    @SerializedName("events_url")
    val eventsUrl: String? = null,
    @Json(name = "fork")
    @SerializedName("fork")
    val fork: Boolean? = null,
    @Json(name = "forks_count")
    @SerializedName("forks_count")
    val forksCount: Int? = null,
    @Json(name = "forks_url")
    @SerializedName("forks_url")
    val forksUrl: String? = null,
    @Json(name = "full_name")
    @SerializedName("full_name")
    val fullName: String? = null,
    @Json(name = "git_commits_url")
    @SerializedName("git_commits_url")
    val gitCommitsUrl: String? = null,
    @Json(name = "git_refs_url")
    @SerializedName("git_refs_url")
    val gitRefsUrl: String? = null,
    @Json(name = "git_tags_url")
    @SerializedName("git_tags_url")
    val gitTagsUrl: String? = null,
    @Json(name = "git_url")
    @SerializedName("git_url")
    val gitUrl: String? = null,
    @Json(name = "has_discussions")
    @SerializedName("has_discussions")
    val hasDiscussions: Boolean? = null,
    @Json(name = "has_downloads")
    @SerializedName("has_downloads")
    val hasDownloads: Boolean? = null,
    @Json(name = "has_issues")
    @SerializedName("has_issues")
    val hasIssues: Boolean? = null,
    @Json(name = "has_pages")
    @SerializedName("has_pages")
    val hasPages: Boolean? = null,
    @Json(name = "has_projects")
    @SerializedName("has_projects")
    val hasProjects: Boolean? = null,
    @Json(name = "has_wiki")
    @SerializedName("has_wiki")
    val hasWiki: Boolean? = null,
    @Json(name = "homepage")
    @SerializedName("homepage")
    val homepage: String? = null,
    @Json(name = "hooks_url")
    @SerializedName("hooks_url")
    val hooksUrl: String? = null,
    @Json(name = "html_url")
    @SerializedName("html_url")
    val htmlUrl: String? = null,
    @Json(name = "id")
    @SerializedName("id")
    val id: Int? = null,
    @Json(name = "is_template")
    @SerializedName("is_template")
    val isTemplate: Boolean? = null,
    @Json(name = "issue_comment_url")
    @SerializedName("issue_comment_url")
    val issueCommentUrl: String? = null,
    @Json(name = "issue_events_url")
    @SerializedName("issue_events_url")
    val issueEventsUrl: String? = null,
    @Json(name = "issues_url")
    @SerializedName("issues_url")
    val issuesUrl: String? = null,
    @Json(name = "keys_url")
    @SerializedName("keys_url")
    val keysUrl: String? = null,
    @Json(name = "labels_url")
    @SerializedName("labels_url")
    val labelsUrl: String? = null,
    @Json(name = "language")
    @SerializedName("language")
    val language: Any? = null,
    @Json(name = "languages_url")
    @SerializedName("languages_url")
    val languagesUrl: String? = null,
    @Json(name = "merges_url")
    @SerializedName("merges_url")
    val mergesUrl: String? = null,
    @Json(name = "milestones_url")
    @SerializedName("milestones_url")
    val milestonesUrl: String? = null,
    @Json(name = "mirror_url")
    @SerializedName("mirror_url")
    val mirrorUrl: String? = null,
    @Json(name = "name")
    @SerializedName("name")
    val name: String? = null,
    @Json(name = "node_id")
    @SerializedName("node_id")
    val nodeId: String? = null,
    @Json(name = "notifications_url")
    @SerializedName("notifications_url")
    val notificationsUrl: String? = null,
    @Json(name = "open_issues_count")
    @SerializedName("open_issues_count")
    val openIssuesCount: Int? = null,
    @Json(name = "owner")
    @SerializedName("owner")
    val owner: Owner? = null,
    @Json(name = "permissions")
    @SerializedName("permissions")
    val permissions: Permissions? = null,
    @Json(name = "private")
    @SerializedName("private")
    val `private`: Boolean? = null,
    @Json(name = "pulls_url")
    @SerializedName("pulls_url")
    val pullsUrl: String? = null,
    @Json(name = "pushed_at")
    @SerializedName("pushed_at")
    val pushedAt: String? = null,
    @Json(name = "releases_url")
    @SerializedName("releases_url")
    val releasesUrl: String? = null,
    @Json(name = "security_and_analysis")
    @SerializedName("security_and_analysis")
    val securityAndAnalysis: SecurityAndAnalysis? = null,
    @Json(name = "size")
    @SerializedName("size")
    val size: Int? = null,
    @Json(name = "ssh_url")
    @SerializedName("ssh_url")
    val sshUrl: String? = null,
    @Json(name = "stargazers_count")
    @SerializedName("stargazers_count")
    val stargazersCount: Int? = null,
    @Json(name = "stargazers_url")
    @SerializedName("stargazers_url")
    val stargazersUrl: String? = null,
    @Json(name = "statuses_url")
    @SerializedName("statuses_url")
    val statusesUrl: String? = null,
    @Json(name = "subscribers_url")
    @SerializedName("subscribers_url")
    val subscribersUrl: String? = null,
    @Json(name = "subscription_url")
    @SerializedName("subscription_url")
    val subscriptionUrl: String? = null,
    @Json(name = "svn_url")
    @SerializedName("svn_url")
    val svnUrl: String? = null,
    @Json(name = "tags_url")
    @SerializedName("tags_url")
    val tagsUrl: String? = null,
    @Json(name = "teams_url")
    @SerializedName("teams_url")
    val teamsUrl: String? = null,
    @Json(name = "topics")
    @SerializedName("topics")
    val topics: List<String?>? = null,
    @Json(name = "trees_url")
    @SerializedName("trees_url")
    val treesUrl: String? = null,
    @Json(name = "updated_at")
    @SerializedName("updated_at")
    val updatedAt: String? = null,
    @Json(name = "url")
    @SerializedName("url")
    val url: String? = null,
    @Json(name = "visibility")
    @SerializedName("visibility")
    val visibility: String? = null,
    @Json(name = "watchers_count")
    @SerializedName("watchers_count")
    val watchersCount: Int? = null
) {
    data class Owner(
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

    data class Permissions(
        @Json(name = "admin")
        @SerializedName("admin")
        val admin: Boolean? = null,
        @Json(name = "pull")
        @SerializedName("pull")
        val pull: Boolean? = null,
        @Json(name = "push")
        @SerializedName("push")
        val push: Boolean? = null
    )

    data class SecurityAndAnalysis(
        @Json(name = "advanced_security")
        @SerializedName("advanced_security")
        val advancedSecurity: AdvancedSecurity? = null,
        @Json(name = "secret_scanning")
        @SerializedName("secret_scanning")
        val secretScanning: SecretScanning? = null,
        @Json(name = "secret_scanning_non_provider_patterns")
        @SerializedName("secret_scanning_non_provider_patterns")
        val secretScanningNonProviderPatterns: SecretScanningNonProviderPatterns? = null,
        @Json(name = "secret_scanning_push_protection")
        @SerializedName("secret_scanning_push_protection")
        val secretScanningPushProtection: SecretScanningPushProtection? = null
    ) {
        data class AdvancedSecurity(
            @Json(name = "status")
            @SerializedName("status")
            val status: String? = null
        )

        data class SecretScanning(
            @Json(name = "status")
            @SerializedName("status")
            val status: String? = null
        )

        data class SecretScanningNonProviderPatterns(
            @Json(name = "status")
            @SerializedName("status")
            val status: String? = null
        )

        data class SecretScanningPushProtection(
            @Json(name = "status")
            @SerializedName("status")
            val status: String? = null
        )
    }
}