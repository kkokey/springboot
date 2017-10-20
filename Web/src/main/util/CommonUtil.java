package util;

import java.util.List;
import java.util.stream.Stream;

public class CommonUtil {

    public static boolean isNullString(String str) {
        if (str == null) {
            return false;
        } else {
            return str.length() == 0;
        }
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

}
