package com.example.mykekapplication

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform