package com.example.demo2213.models

data class Comment (
    var category_name: String? = null,
    var user_id: Int,
    var user_name: String? = null,
    var user_first_surname: String? = null,
    var notice_id: Int,
    var notice_body: String? = null,
    var comment_id: Int? = null,
    var comment_text: String,
    var comment_date: String? = null
) {
}

data class CommentSimple(
    var user_id: Int,
    var notice_id: Int,
    var comment_id: Int? = null,
    var comment_text: String,
    var comment_date: String
){

}