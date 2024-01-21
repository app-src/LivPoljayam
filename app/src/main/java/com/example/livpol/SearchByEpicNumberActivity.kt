package com.example.livpol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.livpol.databinding.ActivitySearchByEpicNumberBinding

class SearchByEpicNumberActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchByEpicNumberBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchByEpicNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}