package com.support.klivvrinternshipassessment

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class KlivvrInternAssessApp : Application() {
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)

    }
}
