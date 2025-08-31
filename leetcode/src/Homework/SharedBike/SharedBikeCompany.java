package Homework.SharedBike;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author Administrator
 * @Date 2025/8/29 09:42
 * @package Homework.SharedBike
 * @Description:
 */
public class SharedBikeCompany {

    private Integer bikeCompanyId;// 公司id
    private String bikeCompanyName;// ofo 哈罗 摩拜
    private SharedBike[] sharedBikes;// 公司持有共享单车
    private Integer sum;//公司单车总量
    private Integer count;// 公司单车借出次
    private double funds;
    private final int EXPAND = 10;

    public SharedBikeCompany(Integer bikeCompanyId, String bikeCompanyName) {
        this.bikeCompanyId = bikeCompanyId;
        this.bikeCompanyName = bikeCompanyName;
    }

    public SharedBikeCompany(Integer bikeCompanyId, String bikeCompanyName, SharedBike[] sharedBikes,int sum) {
        this.bikeCompanyId = bikeCompanyId;
        this.bikeCompanyName = bikeCompanyName;
        this.sharedBikes = sharedBikes;
        this.sum = sum;
        this.count = 0;
        this.funds = 0.0;
    }

    public void putSharedBike(int quantity){

        if (sum+quantity>sharedBikes.length)
        {
            System.out.println("容量大小不足，执行扩容中");
            bikeExpansion();
            putSharedBike(quantity);
        }
        else {
            for (int i = 0; i < quantity; i++) {
                sharedBikes[sum] = newBike();
                sum++;
            }
        }
    }

    private SharedBike newBike(){
        return new SharedBike(IdUtil.getBIKEID(),"ofo1",2.55);
    }

    private void bikeExpansion(){

        sharedBikes   =  Arrays.copyOf(sharedBikes,EXPAND+ sharedBikes.length);

    }

    public Integer getBikeCompanyId() {
        return bikeCompanyId;
    }

    public String getBikeCompanyName() {
        return bikeCompanyName;
    }

    public Integer getCount() {
        return count;
    }

    public double getFunds() {
        return funds;
    }

    public Integer getSum() {
        return sum;
    }

    public void printBikes() {
        for (int i = 0; i < sum; i++) {
            System.out.println("单车序号：" + (i+1) +"  "+ sharedBikes[i]);
        }
    }

    public boolean rentBike(int i,LocalDateTime dateTime){

        if (sharedBikes[i].getStatus()==0)
            return false;
        else{
            sharedBikes[i].setStatus(0);
            sharedBikes[i].setBorrowTime(DateUtil.getFormatTime(dateTime));
            count++;
            return true;
        }

    }

    public double returnBike(int i,LocalDateTime dateTime){

        if (sharedBikes[i].getStatus()==0)
        {
            LocalDateTime borrowTime = DateUtil.parseTime(sharedBikes[i].getBorrowTime());
            Duration duration = Duration.between(borrowTime, dateTime);
            double cost = duration.toHours() * sharedBikes[i].getDailyRant();
            funds += cost;
            return  cost;
        }
        else{
            return -1.00;
        }

    }

    public boolean deleteBike(int i){
        if (sharedBikes[i].getStatus()==0)
            return false;
        else {
            System.arraycopy(sharedBikes,i+1,sharedBikes,i,sum-i-2);
            sharedBikes[sum-1] = null;
            sum--;
            return true;
        }
    }
}
