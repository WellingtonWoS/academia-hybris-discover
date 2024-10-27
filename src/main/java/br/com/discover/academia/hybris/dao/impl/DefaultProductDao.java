package br.com.discover.academia.hybris.dao.impl;

import br.com.discover.academia.hybris.dao.ProductDao;
import br.com.discover.academia.hybris.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DefaultProductDao implements ProductDao {

    @Autowired
    private DataSource datasource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> findAll() {
        String sql = "select id, nome from produto order by nome ";
        List<Product> customers = jdbcTemplate.query(sql, new ProductMapper());
        return customers;
    }
}

class ProductMapper implements RowMapper<Product> {
    public Product mapRow(ResultSet rs, int arg1) throws SQLException {

        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("nome"));

        return product;
    }
}

