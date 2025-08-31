package Study;

/**
 * @author Administrator
 * @Date 2025/8/25 10:59
 * @package Study
 * @Description: 二叉平衡树，二叉搜索树的升级版，再每次完成插入、删除操作后，维持树的平衡性
 */
public class AVLTree {
    private AVLNode root;

    public AVLTree(AVLNode root) {
        this.root = root;
    }

    private int height(AVLNode node) {
        if (node != null) {
            return node.height;
        }
        return 0;
    }

    /**
     * @param node
     * @return {@code }
     * @discription 更新结点的高度
     * @author dme
     * @date 2025/8/25 19:55
     **/
    private void updateHeight(AVLNode node) {
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        node.height = Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * @param node
     * @return {@code int}
     * @discription 求平衡因子
     * @author dme
     * @date 2025/8/25 19:55
     **/
    //平衡因子 ：左右子树的高度差
    private int bf(AVLNode node) {
        return height(node.left) - height(node.right);
    }

    /**
     * @param node
     * @return {@code Study.AVLTree.AVLNode}
     * @discription 向左旋转根结点node，饭后旋转后的根结点
     * @author dme
     * @date 2025/8/25 19:55
     **/
    private AVLNode leftRotate(AVLNode node) {//向左旋转，输入根，返回旋转后的根结点
        AVLNode right = node.right;
        node.right = right.left;
        right.left = node;
        //更新高度，自下而上，node旋转后是子树，right是根
        updateHeight(node);
        updateHeight(right);

        return right;
    }

    private AVLNode rightRotate(AVLNode node) {//向右旋转
        AVLNode left = node.left;
        //旋转后，left的右子树变成了node，左子树不变，node的左子树变成了null，右子树不变
        //为了防止left原本的右子树消失，应该让node.left  = left.right
        node.left = left.right;   //换爹
        left.right = node;  //换根

        updateHeight(node);
        updateHeight(left);
        return left;
    }

    private AVLNode leftRightRotate(AVLNode node) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    private AVLNode rightLeftRotate(AVLNode node) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    /**
     * @param node
     * @return {@code Study.AVLTree.AVLNode}
     * @discription 平衡某个结点node，检查平衡因子，判断是那种失衡状态然后执行相应的旋转
     * @author dme
     * @date 2025/8/25 19:54
     **/
    private AVLNode balance(AVLNode node) {
        //平衡方法

        if (node == null) {
            return null;
        }

        if (bf(node) > 1 && bf(node.left) >= 0) { //左左,进行一次右旋
            return rightRotate(node);
        } else if (bf(node) > 1 && bf(node.left) < 0) { //左右  先左旋左子树再右旋
            return leftRightRotate(node);
        } else if (bf(node) < -1 && bf(node.right) > 0) //右左  先右旋右子树 再左旋
        {
            return rightLeftRotate(node);
        } else if (bf(node) < -1 && bf(node.right) <= 0) {//右右
            return leftRotate(node);
        }
        //无需平衡
        return node;
    }

    public void put(int key, Object value) {

        root = doPut(root, key, value);

    }

    /**
     * @param node
     * @param key
     * @param value
     * @return {@code Study.AVLTree.AVLNode}
     * @discription 向node所在子树添加一个关键字为key，值为value的新结点，
     * 1.先找value应该存放的位置，二叉搜索，找到后创建新结点并返回这个新结点，
     * 2.拿到新结点parent应该更新自身高度，并检查自身平衡性，然后返回平衡后的parent
     * @author dme
     * @date 2025/8/25 19:45
     **/
    private AVLNode doPut(AVLNode node, int key, Object value) {

        if (node == null) {
            return new AVLNode(key, value);
        }
        if (key == node.key) {
            node.value = value;
        } else if (key < node.key) {
            node.left = doPut(node.left, key, value);
        } else {
            node.right = doPut(node.right, key, value);
        }
        //之后的代码，是递归开始返回时调用，如果我们添加一句sout，就能看到整个递归往回走的过程
        updateHeight(node);
        return balance(node);
        //在递归返回的过程中不断调用updateHeight 和balance，自下而上 最终让整个二叉树平衡化
        // 尽管前面所考虑的左左 左右 右左 右右 仅能处理第一次失衡的状态，但只要能解决最小问题，就能通过递归解决所有问题
    }

    /**
     * @param node
     * @param key
     * @return {@code Study.AVLNode}
     * @discription 从平衡树中删除指定关键字的结点并维持平衡
     * @author dme
     * @date 2025/8/25 20:30
     **/
    private AVLNode doRemove(AVLNode node, int key) {
        if (node == null) {
            return null;            //出口
        }
        if (node.key > key) {
            node.left = doRemove(node.left, key); //入口
        } else if (node.key < key) {
            node.right = doRemove(node.right, key); //入口

        } else {
            if (node.left == null)
                //node已经没用了。先用它存着我们要返回的子树
                node = node.right;
            else if (node.right == null)
                node = node.left;
            else {
                AVLNode s = node.right;
                while (s.left != null) {
                    s = s.left;
                }
                //s是后继
                s.right = doRemove(node.right, s.key);
                s.left = node.left;
                //先用node存着我们要返回的后继
                node = s;
            }

        }
        //所有结点最后都要执行一边update和balance，因此在上面不用着急返回，可以设置一个公共的出口
        updateHeight(node);
        return balance(node);   //出口

    }

    public void print() {
        System.out.print("[");
        doPrint(root);
        System.out.print("]");
    }

    private void doPrint(AVLNode node) {


        if (node == null)
            return;
        doPrint(node.left);
        System.out.print(node.key + ",");
        doPrint(node.right);
    }

}

class AVLNode {
    int key;
    Object value;
    AVLNode left;
    AVLNode right;
    int height = 1;

    public AVLNode(int key, Object value) {
        this.key = key;
        this.value = value;
    }

    public AVLNode(int key) {
        this.key = key;
    }

    public AVLNode(int key, Object value, AVLNode left, AVLNode right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
