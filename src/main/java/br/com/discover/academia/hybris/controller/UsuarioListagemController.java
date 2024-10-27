package br.com.discover.academia.hybris.controller;

import br.com.discover.academia.hybris.model.Usuario;
import br.com.discover.academia.hybris.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("**/usuarios")
public class UsuarioListagemController {

    @Autowired
    private UsuariosService usuariosService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showUsuarios(HttpServletRequest request, HttpServletResponse response) {
        List<Usuario> usuarios = usuariosService.getAllUsuarios();

        ModelAndView model = new ModelAndView( "user-list");
        model.addObject("users", usuarios);
        return model;

    }

}
