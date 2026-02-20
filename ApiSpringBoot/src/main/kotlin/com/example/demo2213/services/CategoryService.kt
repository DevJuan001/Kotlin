package com.example.demo2213.services

import com.example.demo2213.models.Category
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Service

@Service
class CategoryService {

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    fun getCategories(): List<Category>{

        val sql = "SELECT * FROM CATEGORIES"
        return jdbcTemplate.query(sql, RowMapper<Category> { rs, _ ->
            Category(
                rs.getInt("category_id"),
                rs.getString("category_name")
            )
        })
    }

    fun createCategory(category: Category): Int {
        val sql = """
            INSERT INTO CATEGORIES (
            category_name
            ) VALUES (?)
        """.trimIndent()

        return jdbcTemplate.update(sql,
            category.category_name)
    }

    fun updateCategory(category: Category, category_id: Int): Int {
        val sql = """
            UPDATE CATEGORIES SET 
            category_name = ?
            WHERE category_id = ?
        """.trimIndent()
        return jdbcTemplate.update(
            sql,
            category.category_name,
            category_id
        )
    }

    fun deleteCategory(category_id: Int) : Int {
        val sql = """
            DELETE FROM CATEGORIES
            WHERE category_id = ?
        """.trimIndent()
        return jdbcTemplate.update(sql,category_id)
    }
}