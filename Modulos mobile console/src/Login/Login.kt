package Login

import Products.Products
import Warranties.Warranties

class Login (
    private var email:String,
    private var password: String
){
    val users = arrayOf(
        Users("user@user.com","12345"),
        Users("user1@user.com", "12345"),
    )

    fun validate(){
        var data = false
        for (user in users) {
            if (user.getEmail() == email && user.getPassword() == password) {
                data = true
            }
        }

        if (data == true){
            println("Bienvenido, ${email}")
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
                2 -> warranties.start()
            }
        }else{
            println("Usuario o contraseña invalidos")
        }
    }
}