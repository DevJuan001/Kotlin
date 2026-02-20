package com.example.demo2213.services

import com.example.demo2213.models.Notice
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Service

@Service
class NoticeService {

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    fun getNotices() : List<Notice> {
        val sql = """
            SELECT * FROM NOTICES
        """.trimIndent()

        return jdbcTemplate.query(sql, RowMapper<Notice> { rs, _ ->
            Notice(
                rs.getInt("category_id"),
                rs.getInt("notice_id"),
                rs.getString("notice_body"),
                rs.getString("notice_status"),
                rs.getString("notice_date")
            )
        })
    }

    fun createNotice(notice: Notice) : Int {
        val sql = """
            INSERT INTO NOTICES(
            category_id,
            notice_body,
            notice_status
            ) VALUES (?, ?, ?)
        """.trimIndent()
        return jdbcTemplate.update(
            sql,
            notice.category_id,
            notice.notice_body,
            notice.notice_status,
        )
    }

    fun updateNotice(notice: Notice, notice_id: Int) : Int {
        val sql = """
            UPDATE NOTICES SET
            category_id = ?,
            notice_body = ?,
            notice_status = ?
            WHERE notice_id = ?
        """.trimIndent()

        return jdbcTemplate.update(
            sql,
            notice.category_id,
            notice.notice_body,
            notice.notice_status,
            notice_id
        )
    }

    fun deleteNotice(notice_id : Int) : Int {
        val sql = """
             DELETE FROM NOTICES
             WHERE notice_id = ?
        """.trimIndent()

        return jdbcTemplate.update(sql, notice_id)
    }
}