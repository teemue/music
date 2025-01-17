package com.zionhuang.music.utils

import android.util.Log
import com.zionhuang.music.BuildConfig
import java.math.BigInteger
import java.security.MessageDigest
import kotlin.system.measureTimeMillis

fun <T> logTimeMillis(tag: String, msg: String, block: () -> T): T {
    if (!BuildConfig.DEBUG) return block()
    var result: T
    val duration = measureTimeMillis {
        result = block()
    }
    Log.d(tag, msg.format(duration))
    return result
}

fun md5(str: String): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(str.toByteArray())).toString(16).padStart(32, '0')
}