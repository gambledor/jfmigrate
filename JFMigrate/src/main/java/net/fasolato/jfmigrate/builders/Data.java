package net.fasolato.jfmigrate.builders;

import net.fasolato.jfmigrate.internal.IDialectHelper;
import net.fasolato.jfmigrate.internal.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by fasolato on 20/04/2017.
 */
public class Data implements Change {
    private OperationType operationType;
    private List<Map<String, Object>> data;
    private String tableName;
    private boolean allRows;
    private Map where;
    private List<Map<String, Object>> deleteWhere;

    public Data() {
    }

    public Data intoTable(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public Data fromTable(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public Data data(List<Map<String, Object>> data) {
        this.data = data;
        return this;
    }

    public Data allRows() {
        allRows = true;
        return this;
    }

    public Data where(Map where) {
        this.where = where;
        return this;
    }

    public List<Pair<String, Object[]>> getSqlCommand(IDialectHelper helper) {
        switch (operationType) {
            case insert:
                return helper.getInsertCommand(this);
            case delete:
                return helper.getDeleteCommand(this);
            default:
                return new ArrayList<Pair<String, Object[]>>();
        }
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public String getTableName() {
        return tableName;
    }

    public List<Map<String, Object>> getData() {
        return data;
    }

    public boolean isAllRows() {
        return allRows;
    }

    public void setAllRows(boolean allRows) {
        this.allRows = allRows;
    }

    public Map getWhere() {
        return where;
    }

    public void setWhere(Map where) {
        this.where = where;
    }

    public List<Map<String, Object>> getDeleteWhere() {
        return deleteWhere;
    }

    public void setDeleteWhere(List<Map<String, Object>> deleteWhere) {
        this.deleteWhere = deleteWhere;
    }
}
