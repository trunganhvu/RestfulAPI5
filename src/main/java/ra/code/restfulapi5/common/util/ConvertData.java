package ra.code.restfulapi5.common.util;

/**
 * @author trunganhvu
 * 2021/08/13
 */
public class ConvertData {

    /**
     * Function convert int to Long
     * @param key
     * @return key type Long
     */
    public static Long convertToLong(int key) {
        return Long.valueOf(key);
    }

    /**
     * Convert long to int
     * @param key
     * @return key type int
     */
    public static int convertToInt(long key) {
        return (int) key;
    }

    /**
     * Convert int to String
     * @param key
     * @return key type String
     */
    public static String convertToString(int key) {
        return String.valueOf(key);
    }
}
