package de.neufische.kotlinwebshop.controller

import org.apache.coyote.BadRequestException

data class AddProductDto(
    val name: String) {
    fun validateData() {
        if (name.isBlank()) {
            throw BadRequestException("name must not be blank")
        }
        if (name.trim().length < 4) {
            throw BadRequestException("name is to short")
        }
    }
}
