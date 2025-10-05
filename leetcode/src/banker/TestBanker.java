package banker;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Administrator
 * @date 2025/9/26 17:05
 * @see
 * @since JDK 17
 */
public class TestBanker {

    public static void main(String[] args) {


        ArrayList<borrower> borrowers = new ArrayList<>();
        borrowers.add(new borrower("borrow001",new SourceImpl(8,8,8),new SourceImpl(4,3,2)));
        borrowers.add(new borrower("borrow002",new SourceImpl(6,5,8),new SourceImpl(3,2,2)));
        borrowers.add(new borrower("borrow003",new SourceImpl(3,2,3),new SourceImpl(2,2,2)));
        borrowers.add(new borrower("borrow004",new SourceImpl(9,5,5),new SourceImpl(6,3,1)));

        AbstractSource remainSource = new SourceImpl(1,0,1);
        boolean flag = true;
        while (flag) {
            flag = false;
            Iterator<borrower> iterator = borrowers.iterator();
            while (iterator.hasNext()) {
                borrower next = iterator.next();
                if (next.canfeed(remainSource)) {
                    remainSource = next.getSource(remainSource);
                    System.out.println(next.name);
                    iterator.remove();
                    flag = true;
                }
            }
        }
        if (borrowers.isEmpty())
            System.out.println("安全");
        else {
            System.out.println("不安全");
        }
    }


}
