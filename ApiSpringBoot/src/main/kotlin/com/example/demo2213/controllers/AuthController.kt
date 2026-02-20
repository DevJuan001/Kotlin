package com.example.demo2213.controllers

import com.example.demo2213.models.Login
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import com.example.demo2213.services.UsersService

@Service
class AuthController {

    @Autowired
    lateinit var usersService : UsersService

    @PostMapping("/login")
    fun login(@RequestBody login: Login) : String {
        var response = usersService.getUserByEmail(login)
        return if (response) {"Bienvenido al sistema de la vecindada"} else {"Usuario o contraseña incorrecta"}
    }
}