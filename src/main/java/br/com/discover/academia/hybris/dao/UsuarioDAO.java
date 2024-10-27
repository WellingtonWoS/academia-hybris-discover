package br.com.discover.academia.hybris.dao;

import br.com.discover.academia.hybris.model.Usuario;

import java.util.List;

public interface UsuarioDAO {

    Usuario registrar(Usuario usuario);

    void update(Usuario usuario);

    void delete(Integer id);

    Usuario getUsuarioByID(Integer id);

    List<Usuario> getAllUsuarios();
}
