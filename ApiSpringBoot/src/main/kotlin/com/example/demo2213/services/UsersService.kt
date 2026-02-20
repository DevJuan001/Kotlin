package com.example.demo2213.services
import com.example.demo2213.models.Login
import com.example.demo2213.models.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Service

@Service
class UsersService {

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    fun getUsers() : List<User> {
        val sql = "SELECT * FROM USERS"
        return jdbcTemplate.query(sql, RowMapper<User> { rs, _ ->
            User(
                rs.getInt("user_id"),
                rs.getString("user_name"),
                rs.getString("user_first_surname"),
                rs.getString("user_second_surname"),
                rs.getLong("user_phone"),
                rs.getString("user_password"),
                rs.getString("user_email"),
                rs.getString("user_address"),
                rs.getString("user_city"),
                rs.getString("user_date")
            )
        })
    }

    fun createUser(user: User) : Int{
        val sql = """
            INSERT INTO USERS(
            user_name,
            user_first_surname,
            user_second_surname,
            user_address,
            user_city,
            user_password,
            user_email,
            user_phone,
            user_date
            ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.trimIndent()

        return jdbcTemplate.update(
            sql,
            user.user_name,
            user.user_first_surname,
            user.user_second_surname,
            user.user_address,
            user.user_city,
            user.user_password,
            user.user_email,
            user.user_phone,
            "2025-01-01"
        )
    }

    fun getUserByEmail(login: Login): Boolean{
        val sql = """
            SELECT 
                user_email,
                user_password
            FROM USERS
            WHERE user_email = ? AND user_password = ?
        """.trimIndent()
        val result = jdbcTemplate.queryForList(
            sql,
            login.email,
            login.password
        )
        return result.isNotEmpty()

    }

    fun updateUser(user: User, id: Int): Int {
        val sql = """
            UPDATE USERS SET
                user_name = ?, 
                user_first_surname= ?, 
                user_second_surname= ?,
                user_address = ?,
                user_city = ?,
                user_phone= ?, 
                user_email= ?
            WHERE user_id = ?
        """.trimIndent()

        return jdbcTemplate.update(
            sql,
            user.user_name,
            user.user_first_surname,
            user.user_second_surname,
            user.user_address,
            user.user_city,
            user.user_phone,
            user.user_email,
            id
        )
    }

    fun deleteUser(id: Int) : Int {
        val sql = """
            DELETE FROM USERS
            WHERE user_id = ?
        """.trimIndent()

        return jdbcTemplate.update(sql, id)
    }
}