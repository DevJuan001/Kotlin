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
            CALL get_comments_by_notice_id(?);
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

    fun createComment(comment: Comment) : Int {
        val sql = """
            INSERT INTO COMMENTS(
            user_id,
            notice_id,
            comment_text)
            VALUES (?, ?, ?)
        """.trimIndent()

        return jdbcTemplate.update(
            sql,
            comment.user_id,
            comment.notice_id,
            comment.comment_text
        )
    }

    fun updateComment(comment_text: String, comment_id: Int) : Int {
        val sql = """
            UPDATE COMMENTS SET
                comment_text = ?
            WHERE comment_id = ?
        """.trimIndent()

        return jdbcTemplate.update(
            sql,
            comment_text,
            comment_id
        )
    }

    fun deleteComment(comment_id: Int) : Int {
        val sql = """
            DELETE FROM COMMENTS 
            WHERE comment_id = ?
        """.trimIndent()

        return jdbcTemplate.update(sql, comment_id)
    }
}