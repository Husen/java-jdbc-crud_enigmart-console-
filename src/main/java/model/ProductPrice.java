package model;

public class ProductPrice {
    private Integer product_id;
    private String price_product_name;
    private Integer price;

    public ProductPrice() {
    }

    public ProductPrice(Integer price) {
        this.price = price;
    }

    public ProductPrice(Integer product_id, Integer price) {
        this.product_id = product_id;
        this.price = price;
    }

    public ProductPrice(Integer price, String price_product_name) {
        this.price = price;
        this.price_product_name = price_product_name;
    }

    public String getPrice_product_name() {
        return price_product_name;
    }

    public void setPrice_product_name(String price_product_name) {
        this.price_product_name = price_product_name;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Detail Product{" +
                ", Name='" + price_product_name + '\'' +
                ", price=" + price +
                '}';
    }
}
