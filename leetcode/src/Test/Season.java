package Test;


/**
 *@author Administrator
 *@Date  2025/8/28 21:31
 *@package Test
 *@Description:
 
 */
public enum Season {

    SPRING("春天",1),SUMMER("夏天",2), AUTUMN("秋天",3), WINTER("冬天",4),NULL;

    private String name;
    private int size;

     Season(String name, int size) {
        this.name = name;
        this.size = size;
    }

    Season() {
    }



}
