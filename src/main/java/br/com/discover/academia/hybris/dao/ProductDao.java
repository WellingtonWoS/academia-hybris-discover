package br.com.discover.academia.hybris.dao;

import br.com.discover.academia.hybris.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAll();
}
