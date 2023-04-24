package com.example.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlincoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val TAG = "Dima"
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        GlobalScope.launch(Dispatchers.IO) {
            val answer = doNetworkCall()

            withContext(Dispatchers.Main){
                binding.tvDummy.text = answer
            }
            Log.d(TAG, answer + Thread.currentThread().name)
        }
        Log.d(TAG, "Coroutine says Hello from thread ${Thread.currentThread().name}")

    }

    suspend fun doNetworkCall(): String{
        delay(3000L)
        return "This is the answer"
    }
    suspend fun doNetworkCall2(): String{
        delay(3000L)
        return "This is the answer 2"
    }
}