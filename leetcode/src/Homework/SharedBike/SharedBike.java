package Homework.SharedBike;

/**
 * @author Administrator
 * @Date 2025/8/29 09:39
 * @package Homework.SharedBike
 * @Description:
 */
public class SharedBike {

    private Integer bid;
    private String bikeName;
    private Integer status;
    private String borrowTime;
    private  double dailyRant;//日租金

    public SharedBike(Integer bid, String bikeName,double dailyRant) {
        this.bid = bid;
        this.bikeName = bikeName;
        this.status = 1;
        this.dailyRant = dailyRant;
    }

    public Integer getBid() {
        return bid;
    }

    public double getDailyRant() {
        return dailyRant;
    }

    public String getBikeName() {
        return bikeName;
    }

    public Integer getStatus() {
        return status;
    }

    public String getBorrowTime() {
        return borrowTime;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }

    @Override
    public String toString() {
        String s = "单车id: " + bid+ "单车品牌："+bikeName + "单车状态：";
        if (status==1){
            s += "可借";
        }
        else {
            s  =s +  "已经借出 " + "借出时间：" + borrowTime;
        }
        return s;
    }
}
