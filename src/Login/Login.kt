package Login

class Login (
    private var email:String,
    private var password: String
){
    val users = arrayOf(
        Users("nn","ll"),
        Users("", ""),
        Users("", ""),
        Users("", ""),
        Users("", ""),
    )

    fun validate(){
        for (user in users) {
            if (user.getEmail() == email && user.getPassword() == password) {
                println("Bienvenido, ${email}")
            } else{
                println("Los datos ingresados no son correctos")
            }
        }
    }
}