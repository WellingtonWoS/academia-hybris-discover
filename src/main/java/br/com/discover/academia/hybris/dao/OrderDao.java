package br.com.discover.academia.hybris.dao;

import br.com.discover.academia.hybris.model.Order;
import br.com.discover.academia.hybris.model.OrderList;
import br.com.discover.academia.hybris.model.Product;

import java.util.List;

public interface OrderDao {

    Order create(Order order);

    void update(Order order);

    void delete(Integer id);

    Order load(Integer id);

    List<Order> findAll();

    List<OrderList> findOrderItemsByOrderId(Integer orderId);

    List<OrderList> addProductInOrder(Product product, Integer orderId);

    void deleteProductFromOrderById(Integer productId);
}
