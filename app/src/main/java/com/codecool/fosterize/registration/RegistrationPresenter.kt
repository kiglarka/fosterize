package com.codecool.fosterize.registration

import android.view.View

class RegistrationPresenter : RegistrationContract.RegistrationPresenter {

    private var view: RegistrationContract.RegistrationView? = null

    override fun onAttach(view: RegistrationContract.RegistrationView) {
        this.view = view
    }

    override fun onDetach() {
        this.view = null
    }

    override fun checkRegistrationInput(username: String, email: String, password1: String, password2: String): Boolean {
        return !username.isEmpty() && !email.isEmpty() && password1 == password2
    }

}