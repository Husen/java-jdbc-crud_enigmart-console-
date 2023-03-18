package model;

public class Product {
    private String name_product;

    public Product() {
    }

    public Product(String name_product) {
        this.name_product = name_product;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name_product='" + name_product + '\'' +
                '}';
    }
}
