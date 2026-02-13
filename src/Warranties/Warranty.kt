package Warranties

class Warranty(
    private var customer: String,
    private var phone: Int,
    private var address: String,
    private var city: String,
    private var date: String,
    private var serial: String,
    private var status: Int,
    private var description: String
) {
    fun getCustomer() : String {
        return customer
    }

    fun getPhone() : Int {
        return phone
    }

    fun getAddress() : String {
        return address
    }

    fun getCity() : String {
        return city
    }

    fun getDate() : String {
        return date
    }

    fun getStatus() : Int {
        return status
    }

    fun getSerial() : String {
        return serial
    }

    fun getDescription() : String{
        return description
    }

    fun showInfo() {
        println("""
            
            Nombre del cliente: ${getCustomer()}
            Telefono del cliente: ${getPhone()}
            Direccion del cliente: ${getAddress()}
            Ciudad del cliente: ${getCity()}
            Fecha: ${getDate()}
            Serial del producto: ${getSerial()}
            Estado del producto: ${getStatus()}
            Descripcion de la garantia: ${getDescription()}
        """.trimIndent())
    }
}