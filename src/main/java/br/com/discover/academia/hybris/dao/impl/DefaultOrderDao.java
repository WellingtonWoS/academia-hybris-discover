package br.com.discover.academia.hybris.dao.impl;

import br.com.discover.academia.hybris.dao.OrderDao;
import br.com.discover.academia.hybris.model.Order;
import br.com.discover.academia.hybris.model.OrderList;
import br.com.discover.academia.hybris.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class DefaultOrderDao implements OrderDao {

    @Autowired
    private DataSource datasource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Order create(Order order) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("pedido").usingGeneratedKeyColumns("id");
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id_cliente", order.getUsername())
                .addValue("situacao", order.getSituation())
                .addValue("data", order.getDate());
        ;

        Number number = simpleJdbcInsert.executeAndReturnKey(params);

        order.setId(number.intValue());
        return order;
    }

    @Override
    public void update(Order order) {
        String sql = "update pedido " +
                "set situacao = ?," +
                "    data = ?," +
                " where id = ?";

        jdbcTemplate.update(sql, new Object[]{order.getUsername(),
                order.getUsername(),
                order.getSituation(),
                order.getDate(),
                order.getId()});
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from pedido where id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Order load(Integer id) {
        String sql = "select * from pedido where id='" + id + "'";
        List<Order> orders = jdbcTemplate.query(sql, new OrderMapper());
        return orders.size() > 0 ? orders.get(0) : null;
    }

    @Override
    public List<Order> findAll() {
        String sql = "select * from pedido ";
        List<Order> orders = jdbcTemplate.query(sql, new OrderMapper());
        return orders;
    }

    public List<OrderList> findOrderItemsByOrderId(Integer orderId) {
        String sql = "select * from pedido_item inner join produto on pedido_item.id_produto = produto.id where id_pedido='" + orderId + "'";
        List<OrderList> orders = jdbcTemplate.query(sql, new OrderListMapper());
        return orders;
    }

    @Override
    public List<OrderList> addProductInOrder(Product product, Integer orderId) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("pedido_item").usingGeneratedKeyColumns("id");
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id_pedido", orderId)
                .addValue("id_produto", product.getId())
                .addValue("quantidade", product.getQuantity());
        ;

        simpleJdbcInsert.execute(params);

        return findOrderItemsByOrderId(orderId);
    }

    @Override
    public void deleteProductFromOrderById(Integer productId) {
        String sql = "delete from pedido_item where id=?";
        jdbcTemplate.update(sql, productId);
    }
}

class OrderMapper implements RowMapper<Order> {
    public Order mapRow(ResultSet rs, int arg1) throws SQLException {
        Order order = new Order();
        order.setUsername(rs.getInt("id_cliente"));
        order.setSituation(rs.getInt("situacao"));
        order.setDate(rs.getDate("data"));
        order.setId(rs.getInt("id"));
        return order;
    }
}

class OrderListMapper implements RowMapper<OrderList> {
    public OrderList mapRow(ResultSet rs, int arg1) throws SQLException {
        OrderList orderList = new OrderList();
        orderList.setId_produto(rs.getInt("id_produto"));
        orderList.setQuantidade(rs.getInt("quantidade"));
        orderList.setProductName(rs.getString("nome"));
        orderList.setId(rs.getInt("id"));
        return orderList;
    }
}

