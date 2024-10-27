package br.com.discover.academia.hybris.controller;


import br.com.discover.academia.hybris.model.Usuario;
import br.com.discover.academia.hybris.service.UsuariosService;
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
@RequestMapping("**/usuario")
//@RequestMapping("**/Usuario")
public class UsuarioController {

    @Autowired
    private UsuariosService usuarioService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getUsuario(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Usuario usuario = null;

        if (id != null && !id.isEmpty()) {
            usuario = usuarioService.getUsuarioByID(Integer.valueOf(id));

            if (usuario == null) {
                ModelAndView model = new ModelAndView("not-found");
                return model;
            }
        } else {
            usuario = new Usuario();
        }

        ModelAndView model = new ModelAndView("register-user");
        model.addObject("user", usuario);
        return model;
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String setUsuario(HttpServletRequest request, HttpServletResponse response, Model model) {
        Usuario usuario = new Usuario();

        usuario.setUsername(request.getParameter("username"));
        usuario.setSenha(request.getParameter("senha"));
        usuario.setPrimeiroNome(request.getParameter("primeiroNome"));
        usuario.setSobrenome(request.getParameter("sobrenome"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setEndereco(request.getParameter("endereco"));
        usuario.setTelefone(Integer.valueOf(request.getParameter("telefone")));

        usuarioService.registrar(usuario);

        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.POST)
    public String deleteUsuario(@PathVariable final String userId) {
        Usuario usuario = usuarioService.getUsuarioByID(Integer.valueOf(userId));

        if (usuario != null) {
            usuarioService.delete(Integer.valueOf(userId));
        }

        return "redirect:/";
    }


}
