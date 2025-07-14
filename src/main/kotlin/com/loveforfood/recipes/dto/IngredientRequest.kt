package com.loveforfood.recipes.dto

import jakarta.validation.constraints.NotBlank

data class IngredientRequest(
    val id: Long? = null,
    @field:NotBlank("Ingredient name must not be blank") val name: String
)
