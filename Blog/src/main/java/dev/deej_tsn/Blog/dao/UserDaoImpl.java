package dev.deej_tsn.Blog.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import dev.deej_tsn.Blog.entity.User;
import dev.deej_tsn.Blog.mapper.UserRowMapper;

@Repository
public class UserDaoImpl implements UserDao{

      
    NamedParameterJdbcTemplate template;  


    public UserDaoImpl(NamedParameterJdbcTemplate template){
        this.template = template;
    }


    @Override
    public List<User> findAll() {
        return template.query("SELECT * FROM blog_schema.USERS;", new UserRowMapper());
    }

    @Override
    public void insertUser(User user) {
        final String sql = "INSERT INTO blog_schema.USERS(personal_first_name, personal_second_name, personal_email, username, passhash, salt) VALUES(:first_name, :second_name,:email, :username, :passhash, :salt)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
            .addValue("first_name", user.getFirstName())
            .addValue("second_name", user.getSecondName())
            .addValue("email", user.getEmail())
            .addValue("username", user.getUserName())
            .addValue("passhash", user.getPasshash())
            .addValue("salt", user.getSalt());
        template.update(sql, param, holder);
    }

    @Override
    public void updateUser(User user) {
        final String sql = "UPDATE blog_schema.USERS SET personal_first_name=:first_name, personal_second_name=:second_name, personal_email=:email, username=:username WHERE user_id = : user_id";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
            .addValue("user_id", user.getUserID())
            .addValue("first_name", user.getFirstName())
            .addValue("second_name", user.getSecondName())
            .addValue("email", user.getEmail())
            .addValue("username", user.getUserName());
        template.update(sql, param, holder);
    }

    @Override
    public void deleteUser(User user) {
        final String sql = "DELETE FROM blog_schema.USERS WHERE user_id=:user_id";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
            .addValue("user_id", Integer.parseInt(user.getUserID()));
        template.update(sql, param, holder);
    }


    @Override
    public User getUserByID(int user_id) throws NullPointerException{
        MapSqlParameterSource map = new MapSqlParameterSource("id", user_id);
        List<User> users = template.query("SELECT * FROM blog_schema.USERS WHERE user_id = :id", map, new UserRowMapper());
        return users.get(0);
    }

}
