package util;

public class CommonUtil {

    public static boolean isNullString(String str) {
        if (str == null) {
            return false;
        } else {
            return str.length() == 0;
        }
    }

}
