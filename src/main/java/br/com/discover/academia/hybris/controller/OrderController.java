package br.com.discover.academia.hybris.controller;

import br.com.discover.academia.hybris.model.Customer;
import br.com.discover.academia.hybris.model.Order;
import br.com.discover.academia.hybris.model.OrderList;
import br.com.discover.academia.hybris.model.Product;
import br.com.discover.academia.hybris.service.CustomerService;
import br.com.discover.academia.hybris.service.OrderService;
import br.com.discover.academia.hybris.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("**/order")
public class OrderController {

    Order order = null;

    @Autowired
    public OrderService orderService;

    @Autowired
    public ProductService productService;

    @Autowired
    public CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");

        if (id != null && !id.isEmpty()) {
            order = orderService.load(Integer.valueOf(id));

            if (order == null) {
                return new ModelAndView("not-found");
            }
        } else {
            order = new Order();
        }

        List<Product> products = productService.findAll();
        Customer customer = customerService.load(order.getUsername());

        ModelAndView model = new ModelAndView("register-order");
        model.addObject("order", order);
        model.addObject("products", products); //set variable 'products' to archive .jsp
        model.addObject("customer", Collections.singletonList(customer));
        return model;
    }

    @RequestMapping(value = "/load-products", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<OrderList> loadProductsFromOrder(HttpServletRequest request, HttpServletResponse response) {

        List<OrderList> orderProducts = orderService.findOrderItemsByOrderId(order.getId());

        ModelAndView model = new ModelAndView("register-order"); //set an jsp
        model.addObject("order", order);
        model.addObject("products", orderProducts); //set variable 'products' to archive .jsp
        return orderProducts;
    }

    @RequestMapping(value = "/add-product", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<OrderList> addProductInOrder(HttpServletRequest request, HttpServletResponse response, @RequestBody Product product) {

        List<OrderList> orderProducts = orderService.addProductInOrder(product, order.getId());

        ModelAndView model = new ModelAndView("register-order"); //set an jsp
        model.addObject("products", orderProducts); //set variable 'products' to archive .jsp
        return orderProducts;
    }

    @RequestMapping(value = "/remove-product", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<OrderList> removeProductFromOrder(HttpServletRequest request, HttpServletResponse response, @RequestBody Product product) {

        orderService.deleteProductFromOrderById(product.getId());

        List<OrderList> orderProducts = orderService.findOrderItemsByOrderId(order.getId());

        ModelAndView model = new ModelAndView("register-order"); //set an jsp
        model.addObject("products", orderProducts); //set variable 'products' to archive .jsp
        return orderProducts;
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public RedirectView save(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("order") Order order) {

        order = orderService.create(order);

        RedirectView rv = new RedirectView();
        rv.setUrl("/order?id=" + order.getId());
        rv.setContextRelative(true);
        return rv;
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public RedirectView deleteOrder(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Integer id) {

        orderService.delete(id);

        RedirectView rv = new RedirectView();
        rv.setUrl("/AcademiaHybris_war/orders");
        rv.setContextRelative(true);
        return rv;
    }
}