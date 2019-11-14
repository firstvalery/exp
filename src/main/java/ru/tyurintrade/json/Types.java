
package ru.tyurintrade.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Types {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("side")
    @Expose
    private String side;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("price")
    @Expose
    private String price;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
