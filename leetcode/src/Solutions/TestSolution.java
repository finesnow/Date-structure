package Solutions;

import java.util.Arrays;

/**
 * @author Administrator
 * @Date 2025/8/27 20:24
 * @package Solutions
 * @Description:
 */
public class TestSolution {

    private static final Solution solution = new Solution();
    public static void main(String[] args) {
        int[] nums ={0,0,1,1,1,1,2,3,3};

        System.out.println(solution.removeDuplicates2(nums));
        System.out.println(Arrays.toString(nums));


    }
}
