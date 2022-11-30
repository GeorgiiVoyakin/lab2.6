package ru.myitschool.lab23

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.myitschool.lab23.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var randomNumberViewModel: RandomNumberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val provider = ViewModelProvider(this)
        randomNumberViewModel = provider[RandomNumberViewModel::class.java]

        binding.content.getRandomNum.setOnClickListener {
            randomNumberViewModel.onGetRandomNumberClicked()
        }

        randomNumberViewModel.randomNumber.observe(this) {
            binding.content.randomNumberResult.text = it.toString()
        }
    }
}