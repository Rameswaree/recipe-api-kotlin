package com.loveforfood.recipes.dto

data class RecipeUpdateRequest(
    val name: String? = null,
    val vegetarian: Boolean? = null,
    val servings: Int? = null,
    val ingredients: List<IngredientRequest>? = null,
    val instructions: String? = null
)
