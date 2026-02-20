package com.example.demo2213.controllers

import com.example.demo2213.models.Comment
import com.example.demo2213.models.CommentSimple
import com.example.demo2213.services.CommentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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

}