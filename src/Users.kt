data class Users(
    private var email: String, private var password: String
) {
    fun getEmail() : String {
        return email
    }

    fun getPassword() : String{
        return password
    }
}