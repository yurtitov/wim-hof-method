package com.yttydev.whm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform