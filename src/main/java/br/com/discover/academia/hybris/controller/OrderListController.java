package br.com.discover.academia.hybris.controller;

import br.com.discover.academia.hybris.model.Order;
import br.com.discover.academia.hybris.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping("**/orders")
public class OrderListController {

    @Autowired
    public OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
        List<Order> orders = orderService.findAll();

        ModelAndView model = new ModelAndView("order-list");
        model.addObject("orders", orders);
        return model;
    }

}
