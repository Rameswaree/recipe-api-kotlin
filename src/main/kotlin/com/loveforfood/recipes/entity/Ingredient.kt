package com.loveforfood.recipes.entity

import jakarta.persistence.*

@Entity
class Ingredient(@Id
                 @GeneratedValue(strategy = GenerationType.IDENTITY)
                 var id: Long,
                 var name: String,
                 @ManyToOne(fetch = FetchType.LAZY)
                 @JoinColumn(name = "recipe_id")
                 var recipe: Recipe? = null)