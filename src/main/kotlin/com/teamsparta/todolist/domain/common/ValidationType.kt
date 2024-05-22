package com.teamsparta.todolist.domain.common

import com.teamsparta.todolist.domain.exception.TypeNotMatchException

class ValidationType {
    companion object {
        inline fun <reified T: Any> validateType(request: Any, modelName: String) {
            if (request !is T) {
                throw TypeNotMatchException(modelName, T::class.simpleName!!)
            }
        }
    }
}
