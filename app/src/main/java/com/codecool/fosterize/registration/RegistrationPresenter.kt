package com.codecool.fosterize.registration

import android.view.View
import com.codecool.fosterize.data.DataManager

class RegistrationPresenter : RegistrationContract.RegistrationPresenter {

    private val dataManager = DataManager()
    private var view: RegistrationContract.RegistrationView? = null

    override fun onAttach(view: RegistrationContract.RegistrationView) {
        this.view = view
    }

    override fun onDetach() {
        this.view = null
    }

    override fun checkRegistrationInput(
        username: String,
        email: String,
        password1: String,
        password2: String
    ): Boolean {
        return username.isNotEmpty() && email.isNotEmpty() && password1 == password2
    }

    override fun makeUserAuthenticated(username: String, email: String, password1: String) {
        dataManager.authorizeUser(username, email, password1)
    }
}