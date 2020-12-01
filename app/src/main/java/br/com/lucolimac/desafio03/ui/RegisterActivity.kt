package br.com.lucolimac.desafio03.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.lucolimac.desafio03.R
import br.com.lucolimac.desafio03.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.tbRegister)
        val toolbar = supportActionBar
        with(binding) {
            toolbar?.setDisplayHomeAsUpEnabled(true)
            toolbar?.setTitle(R.string.register)
            toolbar?.setDisplayHomeAsUpEnabled(true)
            toolbar?.setTitle(R.string.register)
            tbRegister.setTitleTextColor(resources.getColor(R.color.white))
            tbRegister.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
            incRegister.btnLogin.setTextColor(resources.getColor(R.color.white))
        }
        binding.incRegister.btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}