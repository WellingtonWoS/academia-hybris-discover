package br.com.discover.academia.hybris.service.impl;

import br.com.discover.academia.hybris.dao.ProductDao;
import br.com.discover.academia.hybris.model.Product;
import br.com.discover.academia.hybris.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DefaultProductService implements ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> findAll() {
        return productDao.findAll();
    }
}
