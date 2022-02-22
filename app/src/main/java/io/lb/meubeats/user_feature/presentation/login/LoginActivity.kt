package io.lb.meubeats.user_feature.presentation.login

import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import dagger.android.support.DaggerAppCompatActivity
import io.lb.meubeats.R
import io.lb.meubeats.databinding.ActivityLoginBinding
import io.lb.meubeats.headset_feature.presentation.headset.HeadsetActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class LoginActivity : DaggerAppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: LoginViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSubscribeHyperlink()

        setupUiEvents()
        setupOnEmailEntered()
        setupOnPasswordEntered()
        setupOnLoginClick()
    }

    private fun setupUiEvents() {
        CoroutineScope(Main).launch {
            viewModel.eventFlow.collectLatest { event ->
                when (event) {
                    is LoginViewModel.UiEvent.ShowToast -> {
                        toastMakeText(event.message)
                    }
                    is LoginViewModel.UiEvent.Login -> {
                        onSignInSuccess()
                    }
                }
            }
        }
    }

    private fun setupOnEmailEntered() {
        Observable.create<String> { emitter ->
            binding.included.tvLoginEmail.editText?.addTextChangedListener {
                if (!emitter.isDisposed) {
                    emitter.onNext(it.toString())
                }
            }
        }.debounce(500, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe { email ->
                viewModel.onEvent(LoginEvent.EnteredEmail(email))
            }
    }

    private fun setupOnPasswordEntered() {
        Observable.create<String> { emitter ->
            binding.included.tvLoginPassword.editText?.addTextChangedListener {
                if (!emitter.isDisposed) {
                    emitter.onNext(it.toString())
                }
            }
        }.debounce(500, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe { password ->
                viewModel.onEvent(LoginEvent.EnteredPassword(password))
            }
    }

    private fun setupSubscribeHyperlink() {
        binding.included.tvSubscribe.movementMethod = LinkMovementMethod.getInstance()
    }

    private fun setupOnLoginClick() {
        binding.included.btLogin.setOnClickListener {
            viewModel.onEvent(LoginEvent.PressedLogin)
        }
    }

    private fun onSignInSuccess() {
        val i = Intent(this, HeadsetActivity::class.java)
        startActivity(i)
        finishAffinity()
    }

    private fun toastMakeText(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}