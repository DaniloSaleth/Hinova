package com.example.hinova.extension

import com.google.android.material.textfield.TextInputEditText

fun TextInputEditText.isValidAuth(): String {
    return this.text.toString().trim { it <= ' ' }
}
