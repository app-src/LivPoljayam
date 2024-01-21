package com.example.livpol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.livpol.databinding.ActivityEpicNumberResultBinding

class EpicNumberResultActivity : AppCompatActivity() {
    private lateinit var binding:ActivityEpicNumberResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEpicNumberResultBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}