package com.project.githubusersearch.util

object Const {

    const val APP_TOKEN = "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"
    const val DATABASE = "github_user_database"
    const val DATE_FORMAT = "MMM dd, yyyy"

    object Network {
        const val USER = "users"
        const val SEARCH_USER = "search/users"
        const val DETAIL_USER = "users/{username}"
        const val PUBLIC_REPOSITORY_USER = "users/{username}/repos"
    }

    object Entity {
        const val USER = "user_entity"
    }

    object Paging {
        const val PER_PAGE_SMALL = 10
    }

}