package Homework.SharedBike;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Administrator
 * @Date 2025/8/29 09:56
 * @package Homework.SharedBike
 * @Description: 共享单车
 */
public class SharedBikeSys {

    private SharedBikeCompany[] companies = new SharedBikeCompany[3];//申请了一片连续的地址，

    private final Scanner scanner = new Scanner(System.in);

    private LocalDateTime currentTime = LocalDateTime.now();

    private  final Random random = new Random();
    /**
     * @discription 初始化单车公司
     * @author dme
     * @date 2025/8/29 14:07
     * @return {@code void}
     **/
    public void initial(){

        SharedBike[] ofoBikes = {new SharedBike(IdUtil.getBIKEID(),"ofo1",2.55),
                                new SharedBike(IdUtil.getBIKEID(),"ofo1",2.55),
                                new SharedBike(IdUtil.getBIKEID(),"ofo2",2.85),
                                new SharedBike(IdUtil.getBIKEID(),"ofo2",2.85),
                                new SharedBike(IdUtil.getBIKEID(),"ofo3",3.25),
                                null,null,null,null,null
        };

        companies[0] = new SharedBikeCompany(IdUtil.getCOMPANYID(),"ofo单车公司1",ofoBikes,5);

        SharedBike[] haloBikes = {new SharedBike(IdUtil.getBIKEID(),"halo1",2.45),
                                new SharedBike(IdUtil.getBIKEID(),"halo2",2.65),
                                new SharedBike(IdUtil.getBIKEID(),"halo2",2.65),
                                new SharedBike(IdUtil.getBIKEID(),"halo3",2.95),
                                new SharedBike(IdUtil.getBIKEID(),"halo3",2.95),
                                null,null,null,null,null
        };

        companies[1] = new SharedBikeCompany(IdUtil.getCOMPANYID(),"halo单车公司1",haloBikes,5);

        SharedBike[] mobaiBikes = {new SharedBike(IdUtil.getBIKEID(),"mobai1",2.50),
                                new SharedBike(IdUtil.getBIKEID(),"mobai2",2.75),
                                new SharedBike(IdUtil.getBIKEID(),"mobai2",2.75),
                                 new SharedBike(IdUtil.getBIKEID(),"mobai1",2.50),
                                 new SharedBike(IdUtil.getBIKEID(),"mobai3",3.15),
                                null,null,null,null,null
        };
        companies[2] = new SharedBikeCompany(IdUtil.getCOMPANYID(),"mobai单车公司1",mobaiBikes,5);
    }
    /**
     * @discription 系统启动入口
     * @author dme
     * @date 2025/8/29 14:08
     * @return {@code void }
     **/
    public  void  systemStart(){
        System.out.println("欢迎来到迷你共享单车管理系统");
        System.out.println("*****************************************");
        System.out.println("当前时间："+DateUtil.getFormatTime(currentTime));
        boolean flag = true;

        while (flag)
        {
            printMenu();
            int choice = scanner.nextInt();
            switch (choice){
                case 1:putBike();break;
                case 2:printRank(true);break;
                case 3:deleteBike();break;
                case 4:rentBike(currentTime);break;
                case 5:returnBike(currentTime);break;
                case 6:companyRankByCount(companies.length-1);
                    printRank(false);break;
                case 7: currentTime = currentTime.plusHours(random.nextInt(1,10));
                    System.out.println(DateUtil.getFormatTime(currentTime));
                break;
                case 8:flag = false;break;
                default:
            }
        }

    }
    /**
     * @discription 按照租借的总次数排序
     * @author dme
     * @date 2025/8/29 14:08
     * @param bound
     * @return {@code }
     **/
    private void companyRankByCount(int bound) {

        SharedBikeCompany tempCompany;
        if (bound == 0) {
            return;
        }
        for (int i = 0; i < bound; i++) {
            if (companies[i].getCount() < companies[i + 1].getCount()) {
                tempCompany = companies[i];
                companies[i] = companies[i + 1];
                companies[i + 1] = tempCompany;
            }
            companyRankByCount(bound-1);
        }
    }
    /**
     * @discription 删除单车
     * @author dme
     * @date 2025/8/29 14:09
     * @return {@code }
     **/
    private void deleteBike() {
        System.out.println("请选择要删除的单车品牌：");
        printCompanyName();
        int choice = scanner.nextInt()-1;
        System.out.println("该单车品牌的现有单车如下：");
        companies[choice].printBikes();
        System.out.println("请选择要删除的单车编号：");
        int number = scanner.nextInt() - 1;
        if (companies[choice].deleteBike(number))
        {
            System.out.println("删除成功！");
        }
        else {
            System.out.println("删除失败！该单车正在出租中");
        }

    }
    /**
     * @discription 归还
     * @author dme
     * @date 2025/8/29 14:09
     * @param dateTime
     * @return {@code }
     **/
    private void returnBike(LocalDateTime dateTime) {
        System.out.println("请选择要租借的单车品牌：");
        printCompanyName();
        int choice = scanner.nextInt()-1;
        System.out.println("该单车品牌的现有单车如下：");
        companies[choice].printBikes();
        System.out.println("请选择要归还的单车编号：");
        int number = scanner.nextInt() - 1;

        double cost = companies[choice].returnBike(number,dateTime);
        if (cost>0){
            System.out.println("感谢您的支持");
            System.out.println("您一共需要支付："+cost+"元");
        }
        else {
            System.out.println("该单车并未借出！");
        }

    }
    /**
     * @discription 打印菜单
     * @author dme
     * @date 2025/8/29 14:09
     * @return {@code }
     **/
    private void  printMenu(){

        System.out.println("1.投放Bike");
        System.out.println("2.查看Bike");
        System.out.println("3.删除Bike");
        System.out.println("4.借出Bike");
        System.out.println("5.归还Bike");
        System.out.println("6.Bike排行榜");
        System.out.println("7.跳过几个小时");
        System.out.println("8.退     出");
    }
    /**
     * @discription 租借
     * @author dme
     * @date 2025/8/29 14:09
     * @param dateTime
     * @return {@code }
     **/
    private void rentBike(LocalDateTime dateTime) {
        System.out.println("请选择要租借的单车品牌：");
        printCompanyName();
        int choice = scanner.nextInt()-1;
        System.out.println("该单车品牌的现有单车如下：");
        companies[choice].printBikes();
        System.out.println("请选择要租借的单车编号：");
        int number = scanner.nextInt() - 1;
        if (companies[choice].rentBike(number,dateTime))
        {
            System.out.println("成功从"+companies[choice].getBikeCompanyName() + "借出一辆单车！");
        }
        else {
            System.out.println("该单车已经借出！不能重复借出");
        }

    }
    /**
     * @discription 按顺序展示公司品牌名
     * @author dme
     * @date 2025/8/29 14:10
     * @return {@code }
     **/
    private void printCompanyName(){
        for (int i = 1; i <= companies.length; i++) {
            System.out.println(i+"." + companies[i-1].getBikeCompanyName());
        }

    }
    /**
     * @discription 按顺序展示所有公司详细信息
     * @author dme
     * @date 2025/8/29 14:10
     * @param showBikes {@code boolean} 类型变量，表示是否要展示单车的信息
     * @return {@code }
     **/
    private void printRank(boolean showBikes){

        for (int i = 0; i < companies.length; i++) {
            System.out.println("公司序号:"+ (i+1) + "  公司名称:" + companies[i].getBikeCompanyName() +
                    "  公司单车数量："+companies[i].getSum() + "公司单车借出次数" + companies[i].getCount());
            if (showBikes)
                companies[i].printBikes();
        }
    }
    /**
     * @discription 投放单车
     * @author dme
     * @date 2025/8/29 14:12
     * @return {@code }
     **/
    private void putBike(){

        System.out.println("请选择要投放的单车品牌：");
        System.out.println("1.ofo单车");
        System.out.println("2.halo单车");
        System.out.println("3.摩拜单车");
        int choice = scanner.nextInt()-1;
        System.out.println("请录入要投放的单车数量：");
        int quantity = scanner.nextInt();
        companies[choice].putSharedBike(quantity);
        System.out.println("投放完成");
        System.out.println(companies[choice].getSum());
    }


    public static void main(String[] args) {
        SharedBikeSys sys = new SharedBikeSys();
        sys.initial();
        sys.systemStart();

    }



}
