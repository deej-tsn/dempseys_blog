package dev.deej_tsn.Blog.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import dev.deej_tsn.Blog.entity.User;

public class UserRowMapper implements RowMapper<User>{

    @Override
    @Nullable
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUserID(rs.getString("user_id"));
        user.setFirstName(rs.getString("personal_first_name"));
        user.setSecondName(rs.getString("personal_second_name"));
        user.setEmail(rs.getString("personal_email"));
        user.setUserName(rs.getString("username"));
        user.setSalt(rs.getString("salt"));
        user.setPasshash(rs.getString("passhash"));
        //user.setCreatedOn(rs.getTimestamp("created_on"));
        //user.setLastLogin(rs.getTimestamp("last login"));

        return user;
    }
    
}
