package br.com.discover.academia.hybris.dao.impl;

import br.com.discover.academia.hybris.dao.UserDAO;
import br.com.discover.academia.hybris.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class DefaultUserDAO implements UserDAO {

    @Autowired
    private DataSource datasource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User register(final User user) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);

        simpleJdbcInsert.withTableName("users").usingGeneratedKeyColumns("id");

        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("username", user.getUsername())
                .addValue("password", user.getPassword())
                .addValue("firstname", user.getFirstName())
                .addValue("lastname", user.getLastName())
                .addValue("email", user.getEmail())
                .addValue("address", user.getAddress())
                .addValue("phone", user.getPhone());

        //Number number = simpleJdbcInsert.executeAndReturnKey(parameterSource);



        final String sql = "INSERT INTO users (username, password, firstname, lastname, email, address, phone) VALUES (?, ?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        // Criando um PreparedStatementCreator
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"}); // "id" é o nome da coluna da chave primária
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getFirstName());
                ps.setString(4, user.getLastName());
                ps.setString(5, user.getEmail());
                ps.setString(6, user.getAddress());
                ps.setString(7, String.valueOf(user.getPhone()));
                return ps;
            }
        };

        jdbcTemplate.update(psc, keyHolder);

        user.setId(keyHolder.getKey().intValue());

        return user;
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users set username = ?, password = ?, firstname = ?, lastname = ?, email = ?, address = ?, phone = ?";

        jdbcTemplate.update(sql, new Object[]{
                user.getUsername(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAddress(),
                user.getPhone()
        });
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM users WHERE id = ?";

        jdbcTemplate.update(sql, new Object[]{id});
    }

    @Override
    public User findUserById(Integer id) {

        String sql = "SELECT * FROM users WHERE id=" + id;
        List<User> users = jdbcTemplate.query(sql, new UserMapper());

     //   if (usuarios.size() > 0) {
     //       return usuarios.get(0);
     //   }
     //
     //   return null;

        return users.size() > 0 ? users.get(0) : null;

    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        List<User> users = jdbcTemplate.query(sql, new UserMapper());
        return users;
    }

    class UserMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getInt( "id"));
            user.setUsername(resultSet.getString( "username"));
            user.setPassword(resultSet.getString(  "password"));
            user.setFirstName(resultSet.getString(  "firstname"));
            user.setLastName(resultSet.getString("email"));
            user.setEmail(resultSet.getString(  "email"));
            user.setAddress(resultSet.getString(  "address"));
            user.setPhone(resultSet.getInt( "phone"));
            return user;

        }
    }
}
