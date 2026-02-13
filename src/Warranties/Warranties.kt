package Warranties

import Products.Product
import kotlin.collections.plus

class Warranties {

    var warrantiesArray = arrayOf<Warranty>(
        Warranty("", ""),
    )

    fun showWarranties() {
        for ((index, warranty) in warranties.withIndex()) {
            println("""
                Numero de garantia ${index + 1}:
                Descripcion: ${warranty.getCustomer()}
            """.trimIndent())
        }
    }

    fun addWarranty() {
        print("Categoria a la que pertenecera: ")
        var description = readln()

        var newWarranties = Warranty(desciption)
        productsArray += productsArray + newProduct

        println("Producto Agregado correctamente... ")
        newProduct.showInfo()
    }

    fun updateWarranty() {

    }

    fun deleteWarranty() {

    }
    fun start() {
        println("""
            Estas dentro del modulo de productos, Elije una de las siguientes opciones a realizar
            1. Ver todos los productos
            2. Agregar un producto
            3. Editar un producto
            4. Eliminar un producto
        """.trimIndent())
        var productsOption = readln().toInt()

        when (productsOption) {
            1 -> showWarranties()
            2 -> addWarranty()
            3 -> updateWarranty()
            4 -> deleteWarranty()
        }
    }
}