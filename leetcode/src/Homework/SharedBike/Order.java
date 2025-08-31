package Homework.SharedBike;

/**
 * @author Administrator
 * @Date 2025/8/29 09:46
 * @package Homework.SharedBike
 * @Description:
 */
public class Order {

    private Integer orderid;

    private Integer bid;

    private String bikeCompanyName;

    private String creationTime;

    private int status; //订单状态

    private String finishTime;

    private double cost;

    public Order(Integer bid, String bikeCompanyName, String creationTime) {
        this.bid = bid;
        this.bikeCompanyName = bikeCompanyName;
        this.creationTime = creationTime;
    }
}
