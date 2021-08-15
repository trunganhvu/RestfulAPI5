package ra.code.restfulapi5.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author trunganhvu
 * 2021/08/13
 */
public class DateTime {

    /**
     * Get current time type Date
     * Format yyyy-MM-dd
     * @return
     * @throws ParseException
     */
    public static Date getDateyyyyMMddHyphen() {
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = new Date();
        try {
            String dateString = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
//            e.printStackTrace();
            return new Date();
        }
    }

    /**
     * Get current time type Date
     * Format yyyy-MM-dd hh:mm:ss
     * @return
     */
    public static Date getDateyyyyMMddhhmmss() {
        try {
            String dateString = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(dateString);
        } catch (ParseException e) {
            return new Date();
        }
    }

    /**
     * Format date
     * Format yyyy-MM-dd hh:mm:ss
     * @param date
     * @return
     */
    public static Date formatDateyyyyMMddhhmmss(Date date) {
        try {
            String dateString = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(dateString);
        } catch (ParseException e) {
            return new Date();
        }
    }
}
