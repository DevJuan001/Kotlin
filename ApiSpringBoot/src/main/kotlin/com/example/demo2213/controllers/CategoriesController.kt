package com.example.demo2213.controllers

import com.example.demo2213.models.Category
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import com.example.demo2213.services.CategoryService

@RestController
class CategoriesController {
    @Autowired
    lateinit var categoriesService: CategoryService

    @GetMapping("/categories")
    fun getCategories():List<Category>{
        return categoriesService.getCategories()
    }
    @PostMapping("/categories")
    fun createCategory(@RequestBody category: Category): String {
        var response = categoriesService.createCategory(category)
        return if (response > 0 ) {"La categoria se ha creado con exito"} else {"No se pudo crear la categoría"}
    }
    @PutMapping("/categories/{id}")
    fun updateCategory(@RequestBody category: Category, @PathVariable id : Int): String{
        var response = categoriesService.updateCategory(category, id)
        return if (response > 0 ){"La categoria se ha editado con exito"} else {"No se pudo editar la categoría"}
    }
    @DeleteMapping("/categories/{id}")
    fun deleteCategory(@PathVariable id: Int):  String{
        var response = categoriesService.deleteCategory(id)
        return if (response>0){"Categoria eliminado con exito"} else {"No se pudo eliminar la categoria"}
    }
}