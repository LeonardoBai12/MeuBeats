package io.lb.meubeats.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import io.lb.meubeats.R
import io.lb.meubeats.databinding.ActivityLoginBinding
import io.lb.meubeats.ui.main.MainActivity
import io.lb.meubeats.ui.user.UserViewModel
import javax.inject.Inject

class LoginActivity : DaggerAppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: UserViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupOnLoginClick()
    }

    private fun setupOnLoginClick() {
        binding.included.btLogin.setOnClickListener {
            val email = binding.included.tvLoginEmail.editText?.text.toString()
            val password = binding.included.tvLoginPassword.editText?.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                toastMakeText(getString(R.string.login_empty_fields))
                return@setOnClickListener
            }

            viewModel.loginFirebaseUser(
                this,
                email,
                password,
            ) { task ->
                if (task.isSuccessful) {
                    onSignInSuccess()
                } else {
                    onSignInFailure(task.exception)
                }
            }
        }
    }

    private fun onSignInSuccess() {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
        finishAffinity()
    }

    private fun onSignInFailure(task: Exception?) {
        toastMakeText("${getString(R.string.login_error)}: $task")
    }

    private fun toastMakeText(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}