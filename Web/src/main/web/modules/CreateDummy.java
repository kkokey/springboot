package web.modules;

import web.modules.db.dto.ColumnInfo;
import web.modules.db.dto.TableInfo;
import web.modules.enums.DataType;

import java.util.HashMap;
import java.util.Iterator;

public class CreateDummy {

    private final String INSERT_STR = "INSERT INTO ";
    private final String VALUES_STR = "VALUES";
    private final String SPACE = " ";
    private final String LINE_BREAKER = "\n";

    private final String STR_TYPE = "STR,DATE";
    private final String COMMA_X_SPACE = ", ";
    private final String DOT = ".";

    private final String OPEN_ROUND_BRACKET = "(";
    private final String CLOSE_ROUND_BRACKET = ")";

    /**
     * make insert query.
     * @param tbInfo
     * @return
     */
    public String makeInsertQuery(TableInfo tbInfo){

        // Default insert query shape.
        // INSERT INTO [TABLE_NAME] ([COLUMN(1), COLUMN(2), COLUMN(3), ... .. COLUMN(N)])
        // VALUES ([VALUE(1), VALUE(2), VALUE(3), ... .. VALUE(N)]);


        // Every time create object because use lambda expression, so need check about performance after coding complete.
        String lastColumnName = tbInfo.getColumnList().stream().reduce((rs,ls) -> ls)
                .orElse(new HashMap<>()).keySet().iterator().next().getName();

        // make buffer for get column and value data.
        StringBuffer valuePart = new StringBuffer();
        StringBuffer colPart = new StringBuffer();

        // get shell data.
        colPart = colShellData(tbInfo, colPart);
        valuePart = valueShellData(tbInfo, valuePart);

        // get column and value core data.
        HashMap<String, StringBuffer> shellCore = getCoreData(tbInfo,  colPart, valuePart, lastColumnName);

        return setEndShellData(shellCore.get("column"), shellCore.get("value"));
    }

    /**
     * get value shell data (Ex: values ( ... ))
     * @param tbInfo
     * @param valuePart
     * @return
     */
    private StringBuffer valueShellData(TableInfo tbInfo, StringBuffer valuePart){

        valuePart.append(VALUES_STR)
                .append(SPACE)
                .append(OPEN_ROUND_BRACKET);


        return valuePart;
    }

    /**
     * get column shell date (Ex: INSERT INTO [TABLE_NAME] ( ... ))
     * @param tbInfo
     * @param colPart
     * @return
     */
    private StringBuffer colShellData(TableInfo tbInfo, StringBuffer colPart){

        colPart.append(INSERT_STR);
        if(tbInfo.getDatabaseName().trim().length() > 0) {
            colPart.append(tbInfo.getDatabaseName())
                    .append(DOT);
        }
        colPart.append(tbInfo.getTableName())
                .append(SPACE)
                .append(OPEN_ROUND_BRACKET);

        return colPart;

    }

    /**
     * get column name and value.
     * @param tbInfo
     * @param colPart
     * @param varPart
     * @param lastColumnName
     * @return
     */
    private HashMap<String, StringBuffer> getCoreData(TableInfo tbInfo, StringBuffer colPart, StringBuffer varPart, String lastColumnName){

        HashMap<String, StringBuffer> rsMap = new HashMap<>();

        tbInfo.getColumnList().stream().forEach(
            x-> {
                Iterator<ColumnInfo> colInfoIterator = x.keySet().iterator();
                Iterator<DataType> varIterator = x.values().iterator();

                ColumnInfo colInfo = colInfoIterator.next();
                DataType dataType = varIterator.next();

                colPart.append(setSpecialChar(colInfo.getName()));

                if(STR_TYPE.contains(dataType.getClassfication())){
                    varPart.append(setSingleQuote(makeDummyData(dataType)));
                }else{
                    // make dummy data to follow the query rule.
                    varPart.append(makeDummyData(dataType));
                }

                if(!lastColumnName.equals(colInfo.getName())){
                    colPart.append(COMMA_X_SPACE);
                }
                if(!lastColumnName.equals(colInfo.getName())) {
                    varPart.append(COMMA_X_SPACE);
                }
            }
        );
        rsMap.put("column", colPart);
        rsMap.put("value", varPart);

        return rsMap;
    }

    /**
     * set End Shell Data ( Ex: ")")
     * @param colPart
     * @param valuePart
     * @return
     */
    private String setEndShellData(StringBuffer colPart, StringBuffer valuePart){
        valuePart.append(CLOSE_ROUND_BRACKET);
        colPart.append(CLOSE_ROUND_BRACKET);
        colPart.append(SPACE);
        colPart.append(LINE_BREAKER);

        return colPart.toString().concat(valuePart.toString());
    }

    /**
     * makeDummyData
     * @param dt
     * @return
     */
    private String makeDummyData(DataType dt){
        if( STR_TYPE.contains(dt.typeClassification) ){
            return "STR";
        }else if( "NUM".contains(dt.typeClassification) ){
            return "NUM";
        }
        return "TEST_SAM";
    }

    /**
     * Add special character both ends.
     * @param str
     */
    private static String setSpecialChar(String str){
        return str.replaceAll("$|^","`");
    }

    /**
     * Add comma to variable's both ends.
     * @param str
     */
    private static String setSingleQuote(String str){
        return str.replaceAll("$|^","'");
    }

    public static void main(String[] args) {
        System.out.println(setSpecialChar("colName"));

        System.out.println("STR,DATE".contains("DATE"));


    }

}
