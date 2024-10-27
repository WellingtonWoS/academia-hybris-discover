package br.com.discover.academia.hybris.service.impl;

import br.com.discover.academia.hybris.dao.UsuarioDAO;
import br.com.discover.academia.hybris.model.Usuario;
import br.com.discover.academia.hybris.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DefaultUsuarioService implements UsuariosService {


    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public Usuario registrar(Usuario usuario) {
        if(usuario == null || usuario.getId() == null || usuario.getId() == 0){
            return usuarioDAO.registrar(usuario);
        } else {
            if (usuario.getSenha() == null || usuario.getSenha().isEmpty()){
                Usuario usuarioAntigo = getUsuarioByID(usuario.getId());
                usuario.setUsername(usuarioAntigo.getUsername());
                usuario.setSenha(usuarioAntigo.getSenha());
            }
            usuarioDAO.update(usuario);
            return usuario;
        }
    }

    @Override
    public void update(Usuario usuario) {
    }

    @Override
    public void delete(Integer id) {
        usuarioDAO.delete(id);

    }

    @Override
    public Usuario getUsuarioByID(Integer id) {
        return usuarioDAO.getUsuarioByID(id);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioDAO.getAllUsuarios();
    }
}
