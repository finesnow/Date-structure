package Study;

/**
 * @author Administrator
 * @Date 2025/8/23 14:14
 * @package Study
 * @Description:
 */
public class TreeNode {

    private int value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(TreeNode left, int value, TreeNode right) {
        this.right = right;
        this.value = value;
        this.left = left;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
