
package ru.tyurintrade.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attributes {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("id")
    @Expose
    private String id;

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

}
