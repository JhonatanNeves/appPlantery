package com.example.appplantery.common.model

import java.net.URI

data class Post(
    val uuid: String,
    val uri: URI,
    val captinon: String,
    val timestamp: Long
)
