package com.example.hinova.infrastructure

import com.example.hinova.model.UserData

class UserDataManager private constructor() {

    private var userData: UserData? = null

    fun setUserData(userData: UserData) {
        this.userData = userData
    }

    fun getUserData(): UserData {
        return userData!!
    }

    companion object {
        private var instance: UserDataManager? = null

        fun getInstance(): UserDataManager {
            if (instance == null) {
                instance = UserDataManager()
            }
            return instance!!
        }
    }
}