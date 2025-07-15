package com.loveforfood.recipes.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Recipe(@Id
             @GeneratedValue(strategy = GenerationType.IDENTITY)
             var id: Long? = null,
             var name: String? = null,
             var vegetarian: Boolean = false,
             var servings: Int = 1,
             var instructions: String? = null,
             @OneToMany(mappedBy = "recipe", cascade = [CascadeType.ALL], orphanRemoval = true)
             var ingredients: List<Ingredient> = mutableListOf())