package com.teamsparta.todolist.domain.common

import com.teamsparta.todolist.domain.exception.ValidationException

class ValidationFormLength() {
    companion object {
        fun validateFormLength(textLength: Int, maxLength: Int, modelName: String, fieldName: String) {
            if (textLength !in 1..maxLength) {
                throw ValidationException(modelName, fieldName)
            }
        }
    }
}
