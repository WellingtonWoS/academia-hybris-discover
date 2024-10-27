package br.com.discover.academia.hybris.service.impl;

import br.com.discover.academia.hybris.dao.CustomerDao;
import br.com.discover.academia.hybris.model.Customer;
import br.com.discover.academia.hybris.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DefaultCustomerService implements CustomerService {


    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public Customer load(Integer id) {
        return customerDao.load(id);
    }
}
