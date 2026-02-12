import Login.Login
import Products.Products
import Warranties.Warranties

fun main() {
    println("Usuario")
    val email = readln()
    println("Contraseña")
    val  password = readln()
    val login : Login = Login(email, password)
    login.validate()

    val products: Products = Products()
    val warranties: Warranties = Warranties()

    println(""" 
        Elija a que modulo desea entrar:
        1. Productos
        2. Garantias
        """.trimIndent())
    var module = readln().toInt()

    when (module) {
        1 -> products.start()
        2 -> warranties
    }
}