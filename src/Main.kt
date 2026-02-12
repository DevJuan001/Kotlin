fun main() {
    println("Usuario")
    val email = readln()
    println("Contraseña")
    val  password = readln()
    val login : Login = Login(email, password)
    login.validate()
}