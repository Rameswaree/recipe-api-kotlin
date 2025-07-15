package com.loveforfood.recipes.repository

import com.loveforfood.recipes.entity.Recipe
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface RecipeRepository : JpaRepository<Recipe, Long> {

    @Query(
        """
        SELECT DISTINCT r FROM Recipe r
        JOIN r.ingredients i
        WHERE (:vegetarian IS NULL OR r.vegetarian = :vegetarian)
          AND (:servings IS NULL OR r.servings = :servings)
          AND (:include IS NULL OR LOWER(i.name) = LOWER(:include))
          AND (:exclude IS NULL OR r.id NOT IN (
                                   SELECT r2.id FROM Recipe r2
                                   JOIN r2.ingredients i2
                                   WHERE LOWER(i2.name) = LOWER(:exclude)
                             ))
          AND (:instructions IS NULL OR LOWER(r.instructions) LIKE LOWER(CONCAT('%', :instructions, '%')))
        """
    )
    fun search(
        vegetarian: Boolean?,
        servings: Int?,
        include: String?,
        exclude: String?,
        instructions: String?
    ): List<Recipe>

    fun existsByNameIgnoreCase(name: String): Boolean
}