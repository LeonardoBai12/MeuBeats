package io.lb.meubeats.ui.login

import android.content.Intent
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import io.lb.meubeats.databinding.ActivityLoginBinding
import io.lb.meubeats.ui.main.MainActivity

class LoginActivity : DaggerAppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupOnLoginClick()
    }

    private fun setupOnLoginClick() {
        binding.included.btLogin.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }
}