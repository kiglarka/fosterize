package com.codecool.fosterize.login

interface LoginContract {

    interface LoginView {

    }

    interface LoginPresenter {
        fun onAttach(view: LoginContract.LoginView)
        fun onDetach()
        fun checkInput(email: String, password: String)
    }
}