package br.com.discover.academia.hybris.service;

import br.com.discover.academia.hybris.model.Usuario;

import java.util.List;

public interface UsuariosService {

    Usuario registrar(Usuario usuario);

    void update(Usuario usuario);

    void delete(Integer id);

    Usuario getUsuarioByID(Integer id);

    List<Usuario> getAllUsuarios();
}
