package br.com.discover.academia.hybris.model;


import br.com.discover.academia.hybris.service.ProductService;

public class Product {

    private Integer id;
    private String name;
    private Integer quantity;
    private ProductService product;

    public Product() {
    }

    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductService getProduct() {
        return product;
    }

    public void setProduct(ProductService product) {
        this.product = product;
    }
}
