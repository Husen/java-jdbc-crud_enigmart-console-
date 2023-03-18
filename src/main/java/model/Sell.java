package model;

import java.sql.Date;

public class Sell {
    private Integer id;
    private String trans_date;
    private String customer_name;
    private SellDetail sellDetail;

    public Sell() {
    }

    public Sell(Integer id) {
        this.id = id;
    }

    public Sell(SellDetail sellDetail) {
        this.sellDetail = sellDetail;
    }

    public Sell(String trans_date) {
        this.trans_date = trans_date;
    }

    public Sell(String trans_date, String customer_name) {
        this.trans_date = trans_date;
        this.customer_name = customer_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrans_date() {
        return trans_date;
    }

    public void setTrans_date(String trans_date) {
        this.trans_date = trans_date;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }
}
