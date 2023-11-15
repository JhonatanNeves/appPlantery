package com.example.appplantery.common.extension

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.Activity

fun Activity.animationEnd(callback: () -> Unit): AnimatorListenerAdapter {
    return object : AnimatorListenerAdapter() {
        override fun onAnimationEnd(animation: Animator) {
            callback.invoke()
        }
    }
}