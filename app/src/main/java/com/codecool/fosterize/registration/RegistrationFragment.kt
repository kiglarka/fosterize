package com.codecool.fosterize.registration

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.codecool.fosterize.R
import kotlinx.android.synthetic.main.fragment_registration.*

class RegistrationFragment : Fragment(), RegistrationContract.RegistrationView {

    data class Registration(
        val userName: String = "",
        val email: String = "",
        val password: String = ""
    )

    private val presenter = RegistrationPresenter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }


    override fun onResume() {
        super.onResume()
        presenter.onAttach(this)

        submitButton.setOnClickListener {
            val username = userNameField.text.toString()
            val email = emailField.text.toString()
            val password1 = password1Field.text.toString()
            val password2 = password2Field.text.toString()

            if (presenter.checkRegistrationInput(username, email, password1, password2)) {
                Log.d(TAG, "onResume: $username, $email")
                presenter.makeUserAuthenticated(username, email, password1)

            }
        }

        refToLogin.setOnClickListener {
            findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
        }
    }

    override fun showMessage(message: CharSequence) {
        Toast.makeText(activity,message,Toast.LENGTH_SHORT).show()
    }


    companion object {
        private const val TAG = "RegistrationFragment"
    }


}