
package ru.tyurintrade.json;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonGlass {

    @SerializedName("table")
    @Expose
    private String table;
    @SerializedName("action")
    @Expose
    private String action;
    @SerializedName("keys")
    @Expose
    private List<String> keys = null;
    @SerializedName("types")
    @Expose
    private Types types;
    @SerializedName("foreignKeys")
    @Expose
    private ForeignKeys foreignKeys;
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;
    @SerializedName("filter")
    @Expose
    private Filter filter;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }

    public Types getTypes() {
        return types;
    }

    public void setTypes(Types types) {
        this.types = types;
    }

    public ForeignKeys getForeignKeys() {
        return foreignKeys;
    }

    public void setForeignKeys(ForeignKeys foreignKeys) {
        this.foreignKeys = foreignKeys;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

}
