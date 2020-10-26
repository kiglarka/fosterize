package com.codecool.fosterize.registration

import android.content.Context

interface RegistrationContract {

    interface RegistrationView {

    }

    interface RegistrationPresenter {
        fun onAttach(view: RegistrationContract.RegistrationView)
        fun onDetach()

        fun checkRegistrationInput(
            username: String,
            email: String,
            password1: String,
            password2: String
        ): Boolean
    }
}