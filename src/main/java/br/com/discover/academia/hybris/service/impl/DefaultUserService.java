package br.com.discover.academia.hybris.service.impl;

import br.com.discover.academia.hybris.dao.UserDAO;
import br.com.discover.academia.hybris.model.User;
import br.com.discover.academia.hybris.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DefaultUserService implements UserService {


    @Autowired
    private UserDAO userDAO;

    @Override
    public User register(User user) {
        if(user == null || user.getId() == null || user.getId() == 0){
            return userDAO.register(user);
        } else {
            if (user.getPassword() == null || user.getPassword().isEmpty()){
                User oldUser = findUserById(user.getId());
                user.setUsername(oldUser.getUsername());
                user.setPassword(oldUser.getPassword());
            }
            userDAO.update(user);
            return user;
        }
    }

    @Override
    public void update(User user) {
    }

    @Override
    public void delete(Integer id) {
        userDAO.delete(id);

    }

    @Override
    public User findUserById(Integer id) {
        return userDAO.findUserById(id);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }
}
