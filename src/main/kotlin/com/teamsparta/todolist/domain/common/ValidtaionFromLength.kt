package com.teamsparta.todolist.domain.common

import com.teamsparta.todolist.domain.exception.ValidationException

class ValidationFormLength() {
    companion object {
        fun validateFormLength(textLength: Int, maxLength: Int, modelName: String, fieldName: String) {
            if (textLength == 0) {
                throw ValidationException(modelName, fieldName)
            } else if (textLength > maxLength) {
                throw ValidationException(modelName, fieldName)
            }
        }
    }
}