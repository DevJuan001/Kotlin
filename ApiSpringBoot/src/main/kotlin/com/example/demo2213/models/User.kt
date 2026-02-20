package com.example.demo2213.models

data class User (
    var user_id: Int? = null,
    var user_name : String,
    var user_first_surname: String,
    var user_second_surname: String,
    var user_phone: Long,
    var user_password: String = "12345",
    var user_email: String,
    var user_address: String,
    var user_city: String,
    var user_date: String = "2025-01-01"
) {}