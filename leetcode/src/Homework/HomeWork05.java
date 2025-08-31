package Homework;

/**
 * @author Administrator
 * @Date 2025/8/25 21:28
 * @package Homework
 * @Description:
 */
public class HomeWork05 {

    public static void main(String[] args) {
        Calculator calculator = new Calculator(1.0,2.0,'=');
        try {
            System.out.println(calculator.Operation());
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        Car car = new Car(3,"蓝色",755.35);
        if (car.runnable())
        {
            car.drive();
        }
        else {
            new Garage().repair(car);
        }

    }



}
class Calculator{
    private double operand1;
    private double operand2;
    private char operator;

    public Calculator(double operand1, double operand2, char operator) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }

    public Calculator() {
    }

    public double getOperand1() {
        return operand1;
    }

    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    public char getOperator() {
        return operator;
    }
    public void setOperator(char operator) {
        this.operator = operator;
    }
    public double Operation() throws Exception {
        switch (operator){
            case '+': return operand1+operand2;
            case '-': return operand1-operand2;
            case '*': return operand1*operand2;
            case '/': return operand1/operand2;
            case '%': return operand1%operand2;
            default:
                throw new Exception("无法识别的运算符: "+operator);
        }

    }
}

class Car {

private int numOfTires;
private String color;
private double maxSpeed;

    public Car() {
    }

    public Car(int numOfTires, String color, double maxSpeed) {
        this.numOfTires = numOfTires;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getNumOfTires() {
        return numOfTires;
    }

    public void setNumOfTires(int numOfTires) {
        this.numOfTires = numOfTires;
    }

    public boolean runnable(){
        if (this.numOfTires>=4)
            return true;
        else
            return false;
    }
    public void  drive(){
        System.out.println("汽车形式中，最大速度为："+maxSpeed);
    }

}

class Garage{
    private String name;
    private String address;
    private String phoneNumber;

    public Garage() {
    }

    public Garage(String address, String name, String phoneNumber) {

        this.address = address;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void repair(Car car){

        car.setNumOfTires(4);

    }
}
