package br.com.discover.academia.hybris.dao;

import br.com.discover.academia.hybris.model.User;

import java.util.List;

public interface UserDAO {

    User register(User user);

    void update(User user);

    void delete(Integer id);

    User findUserById(Integer id);

    List<User> findAll();
}
