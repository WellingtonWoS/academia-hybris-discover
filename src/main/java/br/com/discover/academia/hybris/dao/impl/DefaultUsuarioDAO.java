package br.com.discover.academia.hybris.dao.impl;

import br.com.discover.academia.hybris.dao.UsuarioDAO;
import br.com.discover.academia.hybris.model.Usuario;
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

public class DefaultUsuarioDAO implements UsuarioDAO {

    @Autowired
    private DataSource datasource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Usuario registrar(final Usuario usuario) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);

        simpleJdbcInsert.withTableName("users").usingGeneratedKeyColumns("id");

        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("username", usuario.getUsername())
                .addValue("password", usuario.getSenha())
                .addValue("firstname", usuario.getPrimeiroNome())
                .addValue("lastname", usuario.getSobrenome())
                .addValue("email", usuario.getEmail())
                .addValue("address", usuario.getEndereco())
                .addValue("phone", usuario.getTelefone());

        //Number number = simpleJdbcInsert.executeAndReturnKey(parameterSource);



        final String sql = "INSERT INTO users (username, password, firstname, lastname, email, address, phone) VALUES (?, ?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        // Criando um PreparedStatementCreator
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"}); // "id" é o nome da coluna da chave primária
                ps.setString(1, usuario.getUsername());
                ps.setString(2, usuario.getSenha());
                ps.setString(3, usuario.getPrimeiroNome());
                ps.setString(4, usuario.getSobrenome());
                ps.setString(5, usuario.getEmail());
                ps.setString(6, usuario.getEndereco());
                ps.setString(7, String.valueOf(usuario.getTelefone()));
                return ps;
            }
        };

        jdbcTemplate.update(psc, keyHolder);

        usuario.setId(keyHolder.getKey().intValue());

        return usuario;
    }

    @Override
    public void update(Usuario usuario) {
        String sql = "UPDATE users set username = ?, password = ?, firstname = ?, lastname = ?, email = ?, address = ?, phone = ?";

        jdbcTemplate.update(sql, new Object[]{
                usuario.getUsername(),
                usuario.getSenha(),
                usuario.getPrimeiroNome(),
                usuario.getSobrenome(),
                usuario.getEmail(),
                usuario.getEndereco(),
                usuario.getTelefone()
        });
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM users WHERE id = ?";

        jdbcTemplate.update(sql, new Object[]{id});
    }

    @Override
    public Usuario getUsuarioByID(Integer id) {

        String sql = "SELECT * FROM users WHERE id=" + id;
        List<Usuario> usuarios = jdbcTemplate.query(sql, new UserMapper());

     //   if (usuarios.size() > 0) {
     //       return usuarios.get(0);
     //   }
     //
     //   return null;

        return usuarios.size() > 0 ? usuarios.get(0) : null;

    }

    @Override
    public List<Usuario> getAllUsuarios() {
        String sql = "SELECT * FROM users";
        List<Usuario> usuarios = jdbcTemplate.query(sql, new UserMapper());
        return usuarios;
    }

    class UserMapper implements RowMapper<Usuario> {
        @Override
        public Usuario mapRow(ResultSet resultSet, int i) throws SQLException {
            Usuario usuario = new Usuario();
            usuario.setId(resultSet.getInt( "id"));
            usuario.setUsername(resultSet.getString( "username"));
            usuario.setSenha(resultSet.getString(  "password"));
            usuario.setPrimeiroNome(resultSet.getString(  "firstname"));
            usuario.setSobrenome(resultSet.getString("email"));
            usuario.setEmail(resultSet.getString(  "email"));
            usuario.setEndereco(resultSet.getString(  "address"));
            usuario.setTelefone(resultSet.getInt( "phone"));
            return usuario;

        }
    }
}
