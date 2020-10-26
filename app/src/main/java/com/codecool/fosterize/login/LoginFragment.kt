package com.codecool.fosterize.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.codecool.fosterize.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(), LoginContract.LoginView {

    private val presenter = LoginPresenter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onResume() {
        super.onResume()
        presenter.onAttach(this)

        submitButton.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()
            presenter.checkInput(email, password)
        }

        refToRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment2)
        }
    }
}