package com.loveforfood.recipes.dto

import jakarta.validation.Valid
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty

data class RecipeRequest(
    @field:NotBlank("Recipe name must not be an empty String") val name: String,
    val vegetarian: Boolean = false,
    @field:Min(1, message = "Servings must be at least 1") val servings: Int,
    @field:Valid @field:NotEmpty("Ingredients must not be empty") val ingredients: List<IngredientRequest>,
    @field:NotBlank("Instructions must not be blank") val instructions: String
)