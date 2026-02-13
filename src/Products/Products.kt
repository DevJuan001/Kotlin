package Products

class Products {
    var productsArray = arrayOf<Product>(
        Product("Televisores", "OLED", "INP0001", "TV LG 43'", "QTYC1414", "2 Meses"),
        Product("Camaras", "Camara 4K", "INP0002", "Camara a 4K", "QTYC1212", "12 Meses"),
    )

    fun showProducts() {
        for ((index, product) in productsArray.withIndex()) {
            println("""
                
                Producto ${index + 1}:
                Categoria: ${product.getCategory()}
                Subcategoria: ${product.getSubcategory()}
                Orden de Entrada: ${product.getInputOrder()}
                Nombre: ${product.getName()}
                Serial: ${product.getSerial()}
                Tiempo de garantia: ${product.getWarrantyTime()}
            """.trimIndent())
        }
    }

    fun addProduct() {
        print("Categoria a la que pertenecera: ")
        var category = readln()
        print("Subcategoria a la que pertenecera: ")
        var subcategory = readln()
        print("Orden de entrada a la que pertenecera: ")
        var inputOrder = readln()
        print("Nombre del producto: ")
        var name = readln()
        print("Serial del producto: ")
        var serial = readln()
        print("Tiempo de garantia del producto: ")
        var warrantyTime = readln()

        var newProduct = Product(category, subcategory, inputOrder, name, serial, warrantyTime)
        productsArray += productsArray + newProduct

        println("Producto Agregado correctamente... ")
        newProduct.showInfo()
    }

    fun updateProduct() {
        println("Introduce el serial producto que deseas editar ")
        var productSerial = readln()
        for ((index,product) in productsArray.withIndex()){
            if (productSerial == product.getSerial()){
                println("""
                    Actualmente pertenece a la categoria: ${product.getCategory()}
                    Introduzca la nueva categoria:
                """.trimIndent())
                var categoryUpdate = readln()
                println("""
                    Actualmente pertenece a la subcategoria: ${product.getSubcategory()}
                    Introduzca la nueva subcategoria:
                """.trimIndent())
                var subcategoryUpdate = readln()
                println("Orden de entrada actual: ${product.getInputOrder()} ")
                var inputOrderUpdate = readln()
                println("""
                    El nombre actual es: ${product.getName()}
                    Introduzca la nueva orden de entrada:
                """.trimIndent())
                var nameUpdate = readln()
                println("""
                    El serial actual es: ${product.getSerial()}
                    Introduzca el nuevo nombre:
                """.trimIndent())
                var serialUpdate = readln()
                println("""
                    Tiempo actual de garantia del producto es: ${product.getWarrantyTime()}
                    Introduzca el nuevo serial:
                """.trimIndent())
                var warrantyTimeUpdate = readln()

                productsArray[index]= Product(categoryUpdate, subcategoryUpdate,inputOrderUpdate,nameUpdate, serialUpdate, warrantyTimeUpdate )

                println("Productos Restantes: ")
                showProducts()
            }
        }
    }

    fun deleteProduct() {
        print("Introduce el serial del producto que deseas eliminar: ")
        var productSerial = readln()
        for((index, product) in productsArray.withIndex()){
            if (productSerial == product.getSerial()){
                println("Producto Eliminado satisfactoriamente")
                productsArray =productsArray.filterIndexed { i,_-> i != index }.toTypedArray()
                break
            }
        }
        println("Nuevo listado de productos")
        showProducts()
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
            1 -> showProducts()
            2 -> addProduct()
            3 -> updateProduct()
            4 -> deleteProduct()
        }
    }
}