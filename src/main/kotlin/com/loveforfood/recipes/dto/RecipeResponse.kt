package com.loveforfood.recipes.dto

data class RecipeResponse(
    val id: Long,
    val name: String,
    val vegetarian: Boolean,
    val servings: Int,
    val ingredients: List<IngredientResponse>,
    val instructions: String?
)
