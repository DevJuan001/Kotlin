package Warranties

import Products.Product
import kotlin.collections.plus

class Warranties {

    var warrantiesArray = arrayOf<Warranty>(
        Warranty("Edwin", 123, "KR", "Bogota", "12", "QTYC1414", 0, "El equipo presenta la pantalla en muy mal estado"),
        Warranty("Michael", 123, "KR", "Bogota", "12", "QTYC1212", 1, "El equipo presenta fallas de corriente al intentar cargarlo")
    )

    fun showWarranties() {
        for ((index, warranty) in warrantiesArray.withIndex()) {
            println("""
               
                Numero de Garantia: ${index + 1}""".trimIndent())
            warranty.showInfo()
        }
    }

    fun addWarranty() {
        print("Nombre del cliente: ")
        var customer = readln()
        print("Numero del cliente: ")
        var phone = readln().toInt()
        print("Direccion del cliente: ")
        var address = readln()
        print("Ciudad del cliente: ")
        var city = readln()
        print("Fecha Actual: ")
        var date = readln()
        print("Serial del producto afectado: ")
        var serial = readln()
        print("Estado actual de la garantia: ")
        var status = readln().toInt()
        print("Descripcion de la categoria: ")
        var description = readln()

        var newWarranty = Warranty(customer, phone, address, city, date, serial, status, description)
        warrantiesArray += warrantiesArray + newWarranty

        println("Garantia agregada correctamente... ")
        newWarranty.showInfo()
    }

    fun updateWarranty() {
        println("Ingresa el serial producto de garantía que deseas editar")
        var warrantySerial = readln()
        for ((index,warranty) in warrantiesArray.withIndex()){
            if (warrantySerial == warranty.getSerial()){
                println("""
                    Actualmente pertenece al cliente: ${warranty.getCustomer()}
                    Introduzca el nuevo nombre del cliente:
                """.trimIndent())
                var customer = readln()

                println("""
                    Actualmente el telefono del usuario es: ${warranty.getPhone()}
                    Introduzca el nuevo número:
                """.trimIndent())
                var phone = readln().toInt()

                println("""
                    La dirección actual es: ${warranty.getAddress()} 
                    Introduzca la nueva direccion:
                """.trimIndent())
                var address = readln()

                println("""
                    La ciudad actual es: ${warranty.getCity()}
                    Introduzca la nueva ciudad:
                """.trimIndent())
                var city = readln()

                println("""
                    La fecha actualmente registrada es: ${warranty.getDate()}
                    Introduzca el nuevo nombre:
                """.trimIndent())
                var date = readln()

                println("""
                    El serial actual del producto es: ${warranty.getSerial()}
                    Introduzca el nuevo serial:
                """.trimIndent())
                var serial = readln()

                println("""
                    El estado actual de la garantia es: ${warranty.getStatus()}
                    Introduzca el nuevo estado:
                """.trimIndent())
                var status = readln().toInt()

                println("""
                    La descripcion de la garantía es: ${warranty.getDescription()}
                    Introduzca la nueva descripcion:
                """.trimIndent())
                var description = readln()

                warrantiesArray[index]= Warranty(customer, phone, address, city, date, serial, status, description)

                println("Garantias Restantes: ")
                showWarranties()
            }
        }
    }

    fun deleteWarranty() {
        print("Introduce el serial del producto que deseas eliminar: ")
        var productSerial = readln()
        for((index, warranty) in warrantiesArray.withIndex()){
            if (productSerial == warranty.getSerial()){
                println("Producto Eliminado satisfactoriamente")
                warrantiesArray = warrantiesArray.filterIndexed { i,_-> i != index }.toTypedArray()
                break
            }
        }
        println("Nuevo listado de incidencias de garantia")
        showWarranties()
    }
    fun start() {
        println("""
            Estas dentro del modulo de garantias, Elije una de las siguientes opciones a realizar
            1. Ver todas las garantias
            2. Agregar una garantia
            3. Editar una garantia
            4. Eliminar una garantia
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