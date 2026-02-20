package com.example.demo2213.models

data class Notice (
    var category_id: Int,
    var notice_id : Int? = null,
    var notice_body : String,
    var notice_status: String,
    var notice_date: String? = null
)  {
}