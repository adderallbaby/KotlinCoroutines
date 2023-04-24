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
        Log.d(TAG, "Before runBlocking")
        runBlocking {
            launch (Dispatchers.IO){
                Log.d(TAG, doNetworkCall())
            }
            launch (Dispatchers.IO){
                Log.d(TAG, doNetworkCall2())
            }
            Log.d(TAG, "Start of runBlocking")


            delay(10000L)
        }
        Log.d(TAG, "After runBlocking")

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