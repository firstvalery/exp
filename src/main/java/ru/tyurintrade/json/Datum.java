
package ru.tyurintrade.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("side")
    @Expose
    private String side;
    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("price")
    @Expose
    private float price;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
