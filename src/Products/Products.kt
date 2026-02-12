package Products

class Products {
    var productsArray = arrayOf<Product>(
        Product("Televisores", "OLED", "INP0001", "TV LG 43'", "QTYC1414", "2 Meses"),
        Product("Televisores", "OLED", "INP0001", "TV LG 43'", "QTYC1414", "2 Meses"),
        Product("Televisores", "OLED", "INP0001", "TV LG 43'", "QTYC1414", "2 Meses"),
        Product("Televisores", "OLED", "INP0001", "TV LG 43'", "QTYC1414", "2 Meses"),
        Product("Televisores", "OLED", "INP0001", "TV LG 43'", "QTYC1414", "2 Meses"),
    )

    fun showProducts() {
        for ((index, product) in productsArray.withIndex()) {
            println("""
                
                Producto ${index}:
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

        println("Producto Agregado correctamente")
        newProduct.showInfo()
    }

    fun updateProduct() {
        print("Introduce el numero del producto que deseas editar")
        var productNumber = readln().toInt()

        if (productNumber in productsArray.indices) {
            val productIndex = productsArray[productNumber]
        } else {
            println("No existe ningun producto con ese numero")
        }
    }

    fun deleteProduct() {
        print("Introduce el numero del producto que deseas eliminar: ")
        var productIndex = readln().toInt()
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