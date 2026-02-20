package com.example.demo2213.controllers

import com.example.demo2213.models.Notice
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import com.example.demo2213.services.NoticeService

@RestController
class NoticeController {
    @Autowired
     lateinit var noticeService: NoticeService

     @GetMapping("/notices")
     fun getNotices():List<Notice>{
         return noticeService.getNotices()
     }
    @PostMapping("/notices")
    fun createNotice(@RequestBody notice:Notice): String {
        var response = noticeService.createNotice(notice)
        return if (response > 0 ) {"Aviso creado con exito"} else {"No se pudo crear el aviso"}
    }
    @PutMapping("/notices/{id}")
    fun updateNotice(@RequestBody notice:Notice, @PathVariable id : Int): String{
        var response= noticeService.updateNotice(notice, id)
        return if (response > 0 ){"Aviso editado con exito"} else {"No se pudo editar el aviso"}
    }
    @DeleteMapping("/notices/{id}")
    fun deleteNotice(@PathVariable id: Int):  String{
        var response = noticeService.deleteNotice(id)
        return if (response>0){"Aviso eliminado con exito"} else {"No se pudo eliminar el aviso"}
    }
}