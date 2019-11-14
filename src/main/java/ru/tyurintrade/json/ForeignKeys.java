
package ru.tyurintrade.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForeignKeys {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("side")
    @Expose
    private String side;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

}
