package com.example.mvpexample.utils

import android.content.Context
import android.widget.Toast
import com.example.mvpexample.R

/**
 * Created by Joanna Heluszka on 06.11.2019.
 */

fun Context.showErrorMessage(messageText: String?){
    Toast.makeText(this, messageText, Toast.LENGTH_LONG).show()
}

fun Context.showSuccessMessage() {
    Toast.makeText(this, resources.getString(R.string.user_success_message),
        Toast.LENGTH_LONG).show()
}

fun Context.showValidateErrorMessage() {
    Toast.makeText(this, resources.getString(R.string.user_validate_info),
        Toast.LENGTH_LONG).show()
}