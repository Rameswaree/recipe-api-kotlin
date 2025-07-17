package com.loveforfood.recipes.entity

import jakarta.persistence.*

@Entity
class Recipe(@Id
             @GeneratedValue(strategy = GenerationType.IDENTITY)
             var id: Long,
             var name: String,
             var vegetarian: Boolean = false,
             var servings: Int = 1,
             var instructions: String? = null,
             @OneToMany(mappedBy = "recipe", cascade = [CascadeType.ALL], orphanRemoval = true)
             var ingredients: List<Ingredient> = mutableListOf())