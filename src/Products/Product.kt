package Products

open class Product(
    private var category: String,
    private var subcategory: String,
    private var inputOrder: String,
    private var name: String,
    private var serial: String,
    private var warrantyTime: String
) {
    fun getCategory() : String {
        return category
    }

    fun getSubcategory() : String {
        return subcategory
    }

    fun getInputOrder() : String {
        return inputOrder
    }

    fun getName() : String {
        return name
    }

    fun getSerial() : String {
        return serial
    }

    fun getWarrantyTime() : String {
        return warrantyTime
    }

    fun showInfo() {
        println("""
            Categoria del Producto: ${getCategory()}
            Subcategoria del Producto: ${getSubcategory()}
            Orden de entrada: ${getInputOrder()}
            Nombre del producto: ${getName()}
            Serial del producto: ${getSerial()}
            Tiempo de garantia: ${getWarrantyTime()}
        """.trimIndent())
    }
}