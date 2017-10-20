package web.modules.enums;

import java.util.Arrays;

public enum DataType {

    NULL                    ("NULL",                0,      "NULL"),
    // Numeric Type
    BIT                     ("BIT",                 0,      "NUM"),
    TINYINT                 ("TINYINT",             0,      "NUM"),
    SMALLINT                ("SMALLINT",            0,      "NUM"),
    MEDIUMINT               ("MEDIUMINT",           0,      "NUM"),
    INT                     ("INT",                 0,      "NUM"),
    INTEGER                 ("INTEGER",             0,      "NUM"),
    BIGINT                  ("BIGINT",              0,      "NUM"),
    DEMICAL                 ("DEMICAL",             0,      "NUM_DOUBLE"),
    DEC                     ("DEC",                 0,      "NUM"),
    FLOAT                   ("FLOAT",               0,      "NUM"),
    DOUBLE                  ("DOUBLE",              0,      "NUM"),
    DOUBLE_PRECISION        ("DOUBLE_PRECISION",    0,      "NUM"),
    BOOLEAN                 ("BOOLEAN",             0,      "NUM"),

    // Date and Time
    DATE                    ("DATE",                0,      "DATE"),
    DATETIME                ("DATETIME",            0,      "DATE"),
    TIMESTAMP               ("TIMESTAMP",           0,      "DATE"),
    TIME                    ("TIME",                0,      "DATE"),
    YEAR                    ("YEAR",                0,      "DATE"),

    // String
    CHAR                    ("CHAR",                0,      "STR"),
    VARCHAR                 ("VARCHAR",             0,      "STR"),
    TEXT                    ("TEXT",                0,      "STR"),
    BINARY                  ("BINARY",              0,      "STR"),
    VARBINARY               ("VARBINARY",           0,      "STR"),
    BLOB                    ("BLOB",                0,      "STR"),
    MEDIUMBLOB              ("MEDIUMBLOB",          0,      "STR"),
    MEDIUMTEXT              ("MEDIUMTEXT",          0,      "STR"),
    LONGBLOB                ("LONGBLOB",            0,      "STR"),
    LONGTEXT                ("LONGTEXT",            0,      "STR"),
    ENUM                    ("ENUM",                0,      "ENUM"),
    SET                     ("SET",                 0,      "STR");

    public String   typeName;
    public int      typeLength;
    public String   typeClassification;

    /**
     * declare DataType enum
     * @param typeName
     * @param typeLength
     */
    DataType(String typeName, int typeLength, String typeClassification) {
        this.typeName = typeName;
        this.typeLength = typeLength;
        this.typeClassification = typeClassification;
    }

    public String getClassfication(){
        return this.typeClassification;
    }

    /**
     * get enum datatype
     * @return
     */
    public static DataType getType() {
        return getType();
    }

    /**
     * get enum datatype
     * @param str
     * @return
     */
    public static DataType getType(String str){
        String typeStr = Arrays.stream(DataType.values())
                .filter(x -> x.toString().equals(str))
                .map(x -> x.typeName)
                .reduce((ls, rs) -> rs)
                .orElse("NULL");

        if(typeStr.trim().length() ==  0){
            return DataType.NULL;
        }

        return DataType.valueOf(typeStr);
    }
}
