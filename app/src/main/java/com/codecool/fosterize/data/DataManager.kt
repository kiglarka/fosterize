package com.codecool.fosterize.data

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage

enum class UserType() {

}

data class User(val id: String, val username: String = "", val email: String){}

class DataManager {

    private val auth = FirebaseAuth.getInstance()
    private var user: FirebaseUser? = null
    private val db = FirebaseDatabase.getInstance()
    private val storage = FirebaseStorage.getInstance()
    private val userReference = db.getReference("user")
    private val dogReference = db.getReference("dog")

    fun authorizeUser(username: String, email: String, password1: String) {
        auth.createUserWithEmailAndPassword(email, password1)
            .addOnCompleteListener() {
                if (!it.isSuccessful()) return@addOnCompleteListener
                user = auth.currentUser
                user?.uid?.let { it1 -> addUserToDB(it1, username, email) }
            }

            .addOnFailureListener(){
                Log.d(TAG, "authorizeUser: failed ${it.message}")
            }
    }

    private fun addUserToDB(id: String, username: String, email: String) {
        val userItem = User(id, username, email)
        userReference.child(id).setValue(userItem)
            .addOnCompleteListener(){
                Log.d(TAG, "addUserToDB: successful")
            }
            .addOnFailureListener(){
                Log.d(TAG, "addUserToDB: unsuccessful ${it.message}")
            }
    }

    fun loginUser(email: String,password1: String){
        auth.signInWithEmailAndPassword(email,password1)
            .addOnCompleteListener(){
                if (!it.isSuccessful) return@addOnCompleteListener
                user = auth.currentUser
                Log.d(TAG, "loginUser: successful ${user?.email}")
                // go to MainFragment
            }
            .addOnFailureListener(){
                Log.d(TAG, "loginUser: failed ${it.message}")
            }
    }

    companion object {
        private const val TAG = "DataManager"
    }

}
