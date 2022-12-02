package ru.myitschool.lab23

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Random
import kotlin.math.exp
import kotlin.math.sqrt

class RandomNumberViewModel : ViewModel() {
    val randomNumber = MutableLiveData<Double>()
    private val random = Random()
    var mean: Double = 0.0
    var variance: Double = 1.0

    fun onGetRandomNumberClicked() {
        Log.d("Aboba", mean.toString())
        Log.d("Aboba", variance.toString())
        randomNumber.value = exp(random.nextGaussian() * sqrt(variance) + mean)
    }
}
