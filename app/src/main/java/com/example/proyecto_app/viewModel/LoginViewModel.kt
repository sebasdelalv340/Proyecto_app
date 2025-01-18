package com.example.proyecto_app.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyecto_app.model.Usuario

class LoginViewModel: ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isEmailError = MutableLiveData<Boolean>()
    val isEmailError: LiveData<Boolean> = _isEmailError

    private val _isPasswordError = MutableLiveData<Boolean>()
    val isPasswordError: LiveData<Boolean> = _isPasswordError

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

    private val _isChecked = MutableLiveData<Boolean>()
    val isChecked: LiveData<Boolean> = _isChecked

    private val _usuarioCredenciales = Usuario("sebas", "1234")

    fun onValueChange(email: String, password: String) {
        _email.value = email
        _password.value = password
    }

    fun onErrorChange(email: String, password: String) {
        _isEmailError.value = email.isEmpty()
        _isPasswordError.value = password.isEmpty()
    }

    fun comprobarCredenciales(email: String, password: String): Boolean {
        return email == _usuarioCredenciales.email && password == _usuarioCredenciales.password
    }

    fun changeShowDialog(show: Boolean){
        _showDialog.value = show
    }
}