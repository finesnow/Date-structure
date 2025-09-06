package Study;

/**
 * @author Administrator
 * @date 2025/9/6 15:25
 * @see
 * @since JDK 17
 */
public class Test {

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 15; i++) {
            arrayList.add("nums" + i);
        }
        ArrayList arrayList2 = arrayList.subList(2,9);
        System.out.println(arrayList2);
    }
}
