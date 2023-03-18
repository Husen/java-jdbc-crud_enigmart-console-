package model;

public class Laporan {
    private Integer sell_id;
    private Integer product_price_id;
    private Integer qty;

    public Laporan() {
    }

    public Laporan(Integer sell_id, Integer product_price_id, Integer qty) {
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
        return "Laporan{" +
                "sell_id=" + sell_id +
                ", product_price_id=" + product_price_id +
                ", qty=" + qty +
                '}';
    }
}
