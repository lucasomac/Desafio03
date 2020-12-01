package br.com.lucolimac.desafio03

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.lucolimac.desafio03.databinding.ActivityLoginBinding
import br.com.lucolimac.desafio03.databinding.ActivityMainBinding
import br.com.lucolimac.desafio03.databinding.ActivityRegisterBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.tbMain)
        setContentView(R.layout.activity_main)
    }
}