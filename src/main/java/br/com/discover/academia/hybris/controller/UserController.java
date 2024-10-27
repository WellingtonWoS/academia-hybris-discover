package br.com.discover.academia.hybris.controller;


import br.com.discover.academia.hybris.model.User;
import br.com.discover.academia.hybris.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("**/user")
//@RequestMapping("**/Usuario")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        User user = null;

        if (id != null && !id.isEmpty()) {
            user = userService.findUserById(Integer.valueOf(id));

            if (user == null) {
                ModelAndView model = new ModelAndView("not-found");
                return model;
            }
        } else {
            user = new User();
        }

        ModelAndView model = new ModelAndView("register-user");
        model.addObject("user", user);
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(HttpServletRequest request, HttpServletResponse response, Model model) {
        User user = new User();

        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setEmail(request.getParameter("email"));
        user.setAddress(request.getParameter("address"));
        user.setPhone(Integer.valueOf(request.getParameter("phone")));

        userService.register(user);

        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.POST)
    public String deleteUser(@PathVariable final String userId) {
        User user = userService.findUserById(Integer.valueOf(userId));

        if (user != null) {
            userService.delete(Integer.valueOf(userId));
        }

        return "redirect:/";
    }


}
