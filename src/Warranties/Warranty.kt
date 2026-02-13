package Warranties

class Warranty(
    private var customer: String,
    private var desciption: String
) {
    fun getCustomer() : String {
        return customer
    }

    fun getDescription() : String{
        return desciption
    }
}