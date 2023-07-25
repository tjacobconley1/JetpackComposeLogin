package com.test.chatapplication.ActivityViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginUIViewModel : ViewModel() {

    private var _email : MutableLiveData<String> = MutableLiveData("")
    private var _password : MutableLiveData<String> = MutableLiveData("")

    var email: LiveData<String> = _email
    var password: LiveData<String> = _password

}

