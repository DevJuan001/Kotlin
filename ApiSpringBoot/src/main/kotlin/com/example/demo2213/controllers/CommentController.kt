package com.example.demo2213.controllers

import com.example.demo2213.models.Comment
import com.example.demo2213.models.CommentSimple
import com.example.demo2213.services.CommentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CommentController {

    @Autowired
    val commentService = CommentService()

    @GetMapping("/comments")
    fun getComments() : List<CommentSimple> {
        return commentService.getComments()
    }

    @GetMapping("/comments/{notice_id}")
    fun getCommentByNoticeId(@PathVariable notice_id: Int ) : List<Comment> {
        return commentService.getCommentsByNoticeId(notice_id)
    }

    @PostMapping("/comments")
    fun addComment(@RequestBody comment: Comment) : String {
         val response = commentService.createComment(comment)
        return if (response >  0 ) {"Comentario agregado correctamente"} else {"No se pudo agregar el comentario"}
    }

    @PutMapping("/comments/{comment_id}")
    fun updateComment(@PathVariable comment_id : Int , @RequestBody comment_text: String) : String {
        val response = commentService.updateComment(comment_text, comment_id)
        return if (response > 0) {"Comentario actualizado correctamente"} else {"No se pudo actualizar el comentario"}
    }

    @DeleteMapping("/comments/{comment_id}")
    fun deleteComment(@PathVariable comment_id : Int) : String {
        val response = commentService.deleteComment(comment_id)
        return if (response > 0) {"Comentario eliminado correctamente"} else {"No se pudo eliminar el comentario"}
    }
}