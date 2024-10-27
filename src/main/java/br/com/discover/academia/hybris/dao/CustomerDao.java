package br.com.discover.academia.hybris.dao;

import br.com.discover.academia.hybris.model.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> findAll();

    Customer load(Integer id);
}
