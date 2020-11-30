package br.com.lucolimac.desafio03

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.lucolimac.desafio03.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.root.tbRegister.setNavigationOnClickListener {
//            navigateUpTo(Intent(this, LoginActivity::class.java))
//        }
//        setSupportActionBar(binding.root.tbRegister)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar?.setTitle(R.string.register)
//        setTitle(R.string.register)
    }
}