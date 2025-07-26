package com.loveforfood.recipes.service

import com.loveforfood.recipes.dto.IngredientResponse
import com.loveforfood.recipes.dto.RecipeResponse
import com.loveforfood.recipes.entity.Recipe
import com.loveforfood.recipes.exception.RecipeNotFoundException
import com.loveforfood.recipes.repository.RecipeRepository
import org.springframework.stereotype.Service

@Service
class RecipeService(
    private val recipeRepository: RecipeRepository
) {

    fun getRecipeById(recipeId: Long) : RecipeResponse =
        recipeRepository.findById(recipeId)
            .map { createRecipeResponse(it) }
            .orElseThrow { RecipeNotFoundException("Recipe not found with id: $recipeId") }

    fun getAllRecipes(): List<RecipeResponse> =
        recipeRepository.findAll().map { createRecipeResponse(it) }

    private fun createRecipeResponse(recipe: Recipe) : RecipeResponse {
        val ingredients = recipe.ingredients.map { ingredient ->
            IngredientResponse(ingredient.id, ingredient.name)
        }

        return RecipeResponse(
            recipe.id,
            recipe.name,
            recipe.vegetarian,
             recipe.servings,
            ingredients,
            recipe.instructions
        )
    }
}