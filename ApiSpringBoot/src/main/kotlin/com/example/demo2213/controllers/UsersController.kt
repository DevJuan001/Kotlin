package com.example.demo2213.controllers


import com.example.demo2213.models.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import com.example.demo2213.services.UsersService

@RestController
class UsersController {

    @Autowired
    lateinit var usersService: UsersService

    @GetMapping("/users")
    fun getUsers() : List<String> {
        return usersService.getUsers()
    }

    @GetMapping("/details")
    fun getUsersDetails() : List<User> {
        return usersService.getUsersDetails()
    }

    @PostMapping("/users")
    fun createUser(@RequestBody user: User) : String {
        var response = usersService.createUser(user)
        return if (response > 0) {"Usuario creado con exito"} else {"No se pudo crear el usuario"}
    }

    @PutMapping("/users/{id}")
    fun updateUser(@RequestBody user: User, @PathVariable id : Int) : String {
        var response = usersService.updateUser(user, id)
        return if (response > 0) {"Usuario actualizado con exito"} else {"No se pudo actualizar el usuario"}
    }

    @DeleteMapping("/users/{id}")
    fun deleteUser(@PathVariable id: Int) : String {
        var response = usersService.deleteUser(id)
        return if (response > 0) {"Usuario eliminado con exito"} else {"No se pudo eliminar a el usuario"}
    }
}