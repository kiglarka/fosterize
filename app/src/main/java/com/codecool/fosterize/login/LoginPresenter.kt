package com.codecool.fosterize.login

import com.codecool.fosterize.data.DataManager

class LoginPresenter : LoginContract.LoginPresenter {

    private var view: LoginContract.LoginView? = null
    private val dataManager = DataManager()

    override fun onAttach(view: LoginContract.LoginView) {
        this.view = view
    }

    override fun onDetach() {
        this.view = null
    }

    override fun checkInput(email: String, password: String) {
        dataManager.loginUser(email,password)
    }
}