package ra.code.restfulapi5.common.util;

import java.util.Date;

/**
 * @author trunganhvu
 * 2021/08/14
 */
public class Validator {

    /**
     * Compare start <= end
     * @param start
     * @param end
     * @return result
     */
    public static boolean startIsLQEnd(Date start, Date end) {
        return start.compareTo(end) <= 0;
    }
}
