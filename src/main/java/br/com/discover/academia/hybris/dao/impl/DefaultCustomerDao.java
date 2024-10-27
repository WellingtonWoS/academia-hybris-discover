package br.com.discover.academia.hybris.dao.impl;

import br.com.discover.academia.hybris.dao.CustomerDao;
import br.com.discover.academia.hybris.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DefaultCustomerDao implements CustomerDao {

    @Autowired
    private DataSource datasource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> findAll() {
        String sql = "SELECT * FROM cliente";
        List<Customer> customers = jdbcTemplate.query(sql, new CustomerMapper());
        return customers;
    }

    @Override
    public Customer load(Integer id) {
        String sql = "select * from cliente where id='" + id + "'";
        List<Customer> customers = jdbcTemplate.query(sql, new CustomerMapper());
        return customers.size() > 0 ? customers.get(0) : null;
    }

    class CustomerMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
            Customer customer = new Customer();
            customer.setId(resultSet.getInt( "id"));
            customer.setName(resultSet.getString("nome"));
            return customer;

        }
    }
}
