package br.com.discover.academia.hybris.controller;

import br.com.discover.academia.hybris.model.User;
import br.com.discover.academia.hybris.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("**/users")
public class UserListController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showUsers(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = userService.findAll();

        ModelAndView model = new ModelAndView( "user-list");
        model.addObject("users", users);
        return model;
    }

}
