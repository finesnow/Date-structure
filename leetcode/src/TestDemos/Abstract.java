package TestDemos;

/**
 * @author Administrator
 * @Date 2025/8/28 11:22
 * @package Test
 * @Description:
 */
public  abstract class Abstract {


    public  abstract void doIt();

    public void say(){
        System.out.println("抽象");
    }



}

class Implement extends Abstract{

    @Override
    public void doIt() {

    }


}
