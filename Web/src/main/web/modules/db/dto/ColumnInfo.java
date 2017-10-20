package web.modules.db.dto;

public class ColumnInfo {

    private String  name = "";
    private int     length = 0;
    private String  charset = "";
    private String  defaultVal = "";
    private boolean isNull = true;
    private boolean isUnsigned = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getDefaultVal() {
        return defaultVal;
    }

    public void setDefaultVal(String defaultVal) {
        this.defaultVal = defaultVal;
    }

    public boolean isNull() {
        return isNull;
    }

    public void setIsNull(boolean Null) {
        isNull = Null;
    }

    public boolean isUnsigned() {
        return isUnsigned;
    }

    public void setUnsigned(boolean unsigned) {
        isUnsigned = unsigned;
    }
}
