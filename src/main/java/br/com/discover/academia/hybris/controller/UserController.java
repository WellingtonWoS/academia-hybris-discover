package br.com.discover.academia.hybris.controller;

import br.com.discover.academia.hybris.model.User;
import br.com.discover.academia.hybris.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("**/user")
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
    public RedirectView save(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") User user) {
        user = userService.register(user);

        RedirectView rv = new RedirectView();
        rv.setUrl("/user?id=" + user.getId());
        rv.setContextRelative(true);
        return rv;
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.POST)
    public RedirectView deleteUser(@PathVariable final String userId) {
        userService.delete(Integer.valueOf(userId));

        RedirectView rv = new RedirectView();
        rv.setUrl("/AcademiaHybris_war/users");
        rv.setContextRelative(true);

        return rv;
    }


}
