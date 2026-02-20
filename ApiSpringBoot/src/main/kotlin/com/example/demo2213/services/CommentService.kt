package com.example.demo2213.services

import com.example.demo2213.models.Comment
import com.example.demo2213.models.CommentSimple
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Service

@Service
class CommentService {

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    fun getComments() : List<CommentSimple> {
        val sql = "SELECT * FROM COMMENTS"
        return jdbcTemplate.query(sql, RowMapper<CommentSimple> { rs, _ ->
            CommentSimple(
                rs.getInt("user_id"),
                rs.getInt("notice_id"),
                rs.getInt("comment_id"),
                rs.getString("comment_text"),
                rs.getString("comment_date")
            )
        })
    }

    fun getCommentsByNoticeId(notice_id: Int) : List<Comment> {
        val sql = """
            CALL get_comments_by_notice(?);
        """.trimIndent()
        return jdbcTemplate.query(sql, arrayOf(notice_id), { rs, _ ->
            Comment(
                rs.getString("category_name"),
                rs.getInt("user_id"),
                rs.getString("user_name"),
                rs.getString("user_first_surname"),
                rs.getInt("notice_id"),
                rs.getString("notice_body"),
                rs.getInt("comment_id"),
                rs.getString("comment_text"),
                rs.getString("comment_date")
            )
        })
    }
}