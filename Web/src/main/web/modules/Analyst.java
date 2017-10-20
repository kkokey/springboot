package web.modules;

import web.modules.db.dto.ColumnInfo;
import web.modules.db.dto.TableInfo;
import web.modules.enums.DataType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * Analyst create query and get table info
 */
public class Analyst {

    public static int OPEN_ROUND_BRACKET_IDX = 0;
    public static int CLOSE_ROUND_BRACKET_IDX = 0;
    public static String PRIMARY_KEY = "PRIMARY KEY";

    /**
     * get table info (table name, column list)
     * @param sql
     * @return
     */
    public TableInfo getTableInfo(String sql){
        TableInfo tableInfo = new TableInfo();

        OPEN_ROUND_BRACKET_IDX = sql.indexOf("(");
        CLOSE_ROUND_BRACKET_IDX = sql.lastIndexOf(")");

        tableInfo.setTableName(getTableName(sql));
        tableInfo.setColumnList(getColumnList(sql));

        tableInfo.setPrimaryKey(getPrimaryKey(sql));

        resetBracket();

        return tableInfo;
    }

    /**
     * get Primary Key column name
     * @param sql
     * @return
     */
    public String[] getPrimaryKey(String sql){
        CLOSE_ROUND_BRACKET_IDX = sql.lastIndexOf(")");
        int primaryKeyEnd = sql.lastIndexOf(PRIMARY_KEY) + PRIMARY_KEY.length();
        return delRoundBracketNGrave(sql.substring(primaryKeyEnd, CLOSE_ROUND_BRACKET_IDX)).split(",");
    }

    /**
     * get column list
     * @param sqlPart
     * @return
     */
    public List<HashMap<ColumnInfo, DataType>> getColumnList(String sqlPart){

        // get part of inner data from bracket
        sqlPart = sqlPart.substring(OPEN_ROUND_BRACKET_IDX, CLOSE_ROUND_BRACKET_IDX);

        List<String> colList = Arrays.asList(sqlPart.split("\n"));
        List<HashMap<ColumnInfo, DataType>> columnList = new ArrayList<>();

        // parse column info.
        colList.stream()
                .filter(x -> getVariableName(x).trim().length() > 0)
                .forEach(x -> {
                        ColumnInfo colInfo = new ColumnInfo();
                        HashMap<ColumnInfo, DataType> dataMap = new HashMap<>();
                        colInfo.setName(getVariableName(x));
                        colInfo.setLength(getVariableLength(x));
                        colInfo.setIsNull(getNullInfo(x));
                        colInfo.setUnsigned(getUnsignedInfo(x));
                        colInfo.setDefaultVal(getDefaultVal(x));

                        dataMap.put(
                            colInfo,
                            DataType.getType(getVariableType(x).toUpperCase())
                        );
                        columnList.add(dataMap);
                    }
                );
        // Show and check data.
//        columnList.stream().forEach(
//                x-> {
//                    ColumnInfo colInfo = x.keySet().iterator().next();
//                    System.out.println(colInfo.getName());
//                }
//        );
        return columnList;
    }

    /**
     * get variable name
     * @param x
     * @return
     */
    public String getVariableName(String x){
        String rsVal;
        rsVal = x.trim().split(" ").length > 1 ? x.trim().split(" ")[0] : "";
        if(rsVal.indexOf("(") > -1){
            rsVal = rsVal.substring(0, rsVal.indexOf("("));
        }
        rsVal = delSpecialChar(rsVal);
        return rsVal;
    }

    /**
     * get variable database type
     * @param x
     * @return
     */
    public String getVariableType(String x){
        String rsVal;
        rsVal = x.trim().split(" ").length > 1 ? x.trim().split(" ")[1] : "";
        if(rsVal.indexOf("(") > -1){
            rsVal = rsVal.substring(0, rsVal.indexOf("("));
        }
//        System.out.println("getVariableType ::: ["+rsVal+"]");
        return rsVal;
    }

    /**
     * get variable length
     * @param x
     * @return
     */
    public int getVariableLength(String x){

        int rsVal = 0;
        String valLength;
        String valType = x.trim().split(" ").length > 1 ? x.trim().split(" ")[1] : "";

        OPEN_ROUND_BRACKET_IDX = valType.indexOf("(");
        CLOSE_ROUND_BRACKET_IDX = valType.indexOf(")");
        if(OPEN_ROUND_BRACKET_IDX == 0 || CLOSE_ROUND_BRACKET_IDX == 0 || OPEN_ROUND_BRACKET_IDX >= CLOSE_ROUND_BRACKET_IDX){
            return rsVal;
        }

        valLength = valType.substring(OPEN_ROUND_BRACKET_IDX, CLOSE_ROUND_BRACKET_IDX);
//        System.out.println("getVariableLength ::: ["+valLength+"]");
        if(isNumOnly(valLength)){
            rsVal = Integer.valueOf(valLength);
        }else{
            rsVal = 0;
        }
//        System.out.println(delRoundBracketNGrave(valLength));

        return rsVal;
    }

    public boolean getNullInfo(String str){
        if( str.isEmpty() ){
            return true;
        }
        if( str.trim().toUpperCase().indexOf("NOT NULL") > -1 ){
            return false;
        }else{
            return true;
        }
    }

    public boolean getUnsignedInfo(String str){
        if( str.isEmpty() ){
            return false;
        }
        if( str.trim().toLowerCase().indexOf("unsigned") > -1 ){
            return true;
        }else{
            return false;
        }
    }

    public String getDefaultVal(String str){
        if( str.indexOf("DEFAULT") > -1 ) {
            System.out.println(delSpecialSelectChar(str.substring(str.indexOf("DEFAULT"), str.length()).split(" ")[1], "\\'\\"));
            return delSpecialSelectChar(delSpecialChar(str.substring(str.indexOf("DEFAULT"), str.length()).split(" ")[1]), ",");
        }else{
            return null;
        }
    }

    /**
     * get table name
     * @param sql
     * @return
     */
    public String getTableName(String sql){
        String tbName;

        tbName = delSpecialChar(
            getLastWord(
                sql.substring(0, OPEN_ROUND_BRACKET_IDX).split(" ")
            )
        );
        return tbName;
    }

    /**
     * get last word in String array
     * @param arrStr
     * @return
     */
    public String getLastWord(String[] arrStr){
        return Stream.of(arrStr)
                .reduce((ls, rs) -> rs)
                .orElse("false");
    }

    /**
     * delete "`" (grave)
     * @param tbName
     * @return
     */
    public String delSpecialChar(String tbName){
        String rs = "";
        if(tbName.contains(".")){
            tbName = getLastWord(tbName.split("\\."));
        }
        if(tbName.contains("`")){
            rs = tbName.replaceAll("`","");
        }
        return rs;
    }

    /**
     * delete select char in sql string
     * @param sql
     * @param targetStr
     * @return
     */
    public String delSpecialSelectChar(String sql, String targetStr){
        String rs = "";
        if(sql.contains(targetStr)){
            rs = sql.replaceAll(targetStr ,"");
        }
        return rs;
    }

    public static String delRoundBracketNGrave(String str){
        return str.replaceAll("[()`]","");
    }

    public void resetBracket(){
        OPEN_ROUND_BRACKET_IDX = 0;
        CLOSE_ROUND_BRACKET_IDX = 0;
    }

    public boolean isNumOnly(String str){
        if(str.replaceAll("[0-9]", "").trim().length() > 0){
            return false;
        }else{
            return true;
        }
    }

//    public static void main(String[] args) {
//        System.out.println(delRoundBracketNGrave("(`host`,`User`)"));
//    }


}
