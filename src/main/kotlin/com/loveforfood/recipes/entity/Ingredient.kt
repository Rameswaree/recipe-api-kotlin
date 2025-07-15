package com.loveforfood.recipes.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Ingredient(@Id
                 @GeneratedValue(strategy = GenerationType.IDENTITY)
                 var id: Long? = null,
                 var name: String? = null,
                 @ManyToOne(fetch = FetchType.LAZY)
                 @JoinColumn(name = "recipe_id")
                 var recipe: Recipe)