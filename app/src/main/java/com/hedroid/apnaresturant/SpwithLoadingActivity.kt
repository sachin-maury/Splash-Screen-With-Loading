@file:Suppress("DEPRECATION")

package com.hedroid.apnaresturant

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class SpwithLoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spwith_loading)
        startHeavyTask()

    }

    private fun startHeavyTask() {
        LongOperation().execute()
    }
    @SuppressLint("StaticFieldLeak")
    private open inner class LongOperation :AsyncTask <String?, Void?,String?>(){
        @Deprecated("Deprecated in Java")
        override fun doInBackground(vararg params: String?): String? {
            for (i in 0 .. 6){
            try {
                Thread.sleep(1000)
            }
            catch (e:Exception){
                Thread.interrupted()
            }

            }
            return "result"
            }

        @Deprecated("Deprecated in Java")
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            val intent = Intent(this@SpwithLoadingActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}