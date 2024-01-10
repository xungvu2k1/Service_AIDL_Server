package com.example.service_aidl_server

import android.app.Service
import android.content.Intent
import android.graphics.Color
import android.os.IBinder
import android.util.Log
import java.util.Random

//Implement the Interface
class MyChangeColorService : Service() {
    private var TAG : String = "AIDLColorService"

    override fun onCreate() {
        super.onCreate()
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    private var binder : IMyAidlInterface.Stub = object : IMyAidlInterface.Stub(){
        override fun getColor(): Int {
            var random : Random = Random()
            var color : Int = Color.argb(255, random.nextInt(255), random.nextInt(255), random.nextInt(255))
            Log.d(TAG, "getColor"+color)
            return color
        }

    }
}