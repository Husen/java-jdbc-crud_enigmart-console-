package model;

public class SellDetail {
    private Integer sell_id;
    private Integer product_price_id;
    private Integer qty;
    private Sell sell;
    private Product product;
    private ProductPrice productPrice;

    public SellDetail() {
    }

    public SellDetail(Sell sell, Product product, ProductPrice productPrice, Integer qty) {
        this.sell = sell;
        this.product = product;
        this.productPrice = productPrice;
        this.qty = qty;
    }

    public SellDetail(Integer qty) {
        this.qty = qty;
    }

    public SellDetail(Integer sell_id, Integer product_price_id, Integer qty) {
        this.sell_id = sell_id;
        this.product_price_id = product_price_id;
        this.qty = qty;
    }

    public Integer getSell_id() {
        return sell_id;
    }

    public void setSell_id(Integer sell_id) {
        this.sell_id = sell_id;
    }

    public Integer getProduct_price_id() {
        return product_price_id;
    }

    public void setProduct_price_id(Integer product_price_id) {
        this.product_price_id = product_price_id;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "SellDetail{" +
                "Date Transaksi = " + sell.getTrans_date() +
                "\tCustomer Name = " + sell.getCustomer_name() +
                "\tProduct Name = " + product.getName_product() +
                "\tPrice = " + productPrice.getPrice() +
                "\tqty = " + qty +
                '}';
    }
}
