package br.com.discover.academia.hybris.service.impl;

import br.com.discover.academia.hybris.dao.OrderDao;
import br.com.discover.academia.hybris.model.Order;
import br.com.discover.academia.hybris.model.OrderList;
import br.com.discover.academia.hybris.model.Product;
import br.com.discover.academia.hybris.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DefaultOrderService implements OrderService {

    @Autowired
    private OrderDao orderDao;

    public Order create(Order order) {
        if (order.getId() == null || order.getId() == 0) {
            return orderDao.create(order);
        } else {
            if (order.getUsername() == null) {
                Order oldOrder = load(order.getId());

                order.setUsername(oldOrder.getUsername());
                order.setItems(oldOrder.getItems());
            }

            orderDao.update(order);
            return order;
        }
    }

    @Override
    public Order load(Integer id) {
        return orderDao.load(id);
    }

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    public List<OrderList> findOrderItemsByOrderId(Integer orderId) {
        return orderDao.findOrderItemsByOrderId(orderId);
    }

    @Override
    public List<OrderList> addProductInOrder(Product product, Integer orderId) {
        return orderDao.addProductInOrder(product, orderId);
    }

    @Override
    public void deleteProductFromOrderById(Integer productId) {
        orderDao.deleteProductFromOrderById(productId);
    }

    @Override
    public void delete(Integer id) {
        orderDao.delete(id);
    }

    public void update(Order order) {

    }
}
