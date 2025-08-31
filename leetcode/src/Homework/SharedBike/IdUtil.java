package Homework.SharedBike;

/**
 * @author Administrator
 * @Date 2025/8/29 09:59
 * @package Homework.SharedBike
 * @Description: id生成工具
 */
public class IdUtil {

    private static Integer  BIKEID =  105953588;

    private static Integer COMPANYID = 204593589;

    private static Integer ORDERID = 311451426;


    public static Integer getBIKEID() {
        return BIKEID++;
    }

    public static Integer getCOMPANYID() {
        return COMPANYID++;
    }

    public static Integer getORDERID() {
        return ORDERID++;
    }
}
