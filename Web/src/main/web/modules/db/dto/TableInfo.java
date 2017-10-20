package web.modules.db.dto;

import web.modules.enums.DataType;

import java.util.HashMap;
import java.util.List;

public class TableInfo {

    String databaseName = "";
    String tableName = "";
    String[] primaryKey = {};
    String engineName = "";
    String charset = "";
    String collate = "";
    String comment = "";
    List<HashMap<ColumnInfo, DataType>> columnList = null;

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) { this.tableName = tableName; }

    public String[] getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String[] primaryKey) { this.primaryKey = primaryKey; }

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getCollate() {
        return collate;
    }

    public void setCollate(String collate) {
        this.collate = collate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<HashMap<ColumnInfo, DataType>> getColumnList() { return columnList; }

    public void setColumnList(List<HashMap<ColumnInfo, DataType>> columnList) { this.columnList = columnList; }
}
