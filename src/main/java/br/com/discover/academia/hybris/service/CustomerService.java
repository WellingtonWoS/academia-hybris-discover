package br.com.discover.academia.hybris.service;

import br.com.discover.academia.hybris.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer load(Integer id);
}
