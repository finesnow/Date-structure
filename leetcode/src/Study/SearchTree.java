package Study;

/**
 * @author Administrator
 * @Date 2025/8/23 14:12
 * @package Study
 * @Description: 二叉搜索树, 树的结点是 {@link Study.TreeNode},结点的value是{@code int}类型的
 * 特点是左侧的子树值均小于根 右侧的子树值均大于根 是天生的二分查找结构
 */
public class SearchTree {

    private TreeNode root;
    private int size;

    public SearchTree(TreeNode root) {
        this.root = root;
    }

    /**
     * @param value
     * @return {@code Study.TreeNode}
     * @discription 非递归方法实现get，输入value，寻找值相等的node并返回
     * @author dme
     * @date 2025/8/24 14:39
     **/
    public TreeNode get(int value) {
        //非递归方法实现

        TreeNode start = root;
        while (start != null) {
            if (start.getValue() == value) {

                return start;
            } else if (start.getValue() > value) {
                start = start.getLeft();
            } else
                start = start.getRight();
        }
        return null;

    }

    /**
     * @param node
     * @param value
     * @return {@code Study.TreeNode}
     * @discription 递归方式是实现get，需要输入搜索的起始结点
     * @author dme
     * @date 2025/8/24 14:41
     **/
    public TreeNode doGet(TreeNode node, int value) {
        //递归方法实现

        if (node == null) {
            return null;
        }
        if (node.getValue() == value) {
            return node;
        }
        if (node.getValue() > value) {
            return doGet(node.getLeft(), value);
        } else {
            return doGet(node.getRight(), value);
        }
    }

    /**
     * @param start
     * @return {@code int}
     * @discription 寻找某个子树中的最小值
     * @author dme
     * @date 2025/8/24 14:41
     **/
    public int min(TreeNode start) {
        //寻找最小值 非递归  递归也可以实现
        while (start.getLeft() != null) {
            start = start.getLeft();
        }
        return start.getValue();
    }
    public TreeNode minNode(TreeNode start) {
        //寻找最小值 非递归  递归也可以实现
        while (start.getLeft() != null) {
            start = start.getLeft();
        }
        return start;
    }

    /**
     * @param start
     * @return {@code int}
     * @discription 寻找某个子树中的最大值
     * @author dme
     * @date 2025/8/24 14:42
     **/
    public int max(TreeNode start) {
        //寻找最大值 非递归  递归也可以实现

        while (start.getRight() != null) {
            start = start.getRight();
        }
        return start.getValue();

    }
    public TreeNode maxNode(TreeNode start) {
        //寻找最大值 非递归  递归也可以实现

        while (start.getRight() != null) {
            start = start.getRight();
        }
        return start;

    }

    /**
     * @param value
     * @return {@code int}
     * @discription 寻找某个值的前驱值，可以理解为上一个比这个value小的值
     * @author dme
     * @date 2025/8/24 14:42
     **/
    public TreeNode successor(int value) {
        TreeNode start = root;
        TreeNode successor = null;
        while (start != null) {
            if (start.getValue() == value) {
                break;
            } else if (start.getValue() > value) {
                start = start.getLeft();
            } else
            {
                successor = start;
                start = start.getRight();
            }
        }
        //没找到就返回空，找了就继续判断
        if (start == null) {
            return null;
        }
        //如果有左子树 那么前驱就是左子树的最大值
        if (start.getLeft() != null) {
            return maxNode(start.getLeft());
        }
        //如果没有左子树，那么前驱就是从左边来的，最近的祖先结点
        //注意前驱也可能为空，序列的第一个元素就没有前驱
        else {
            return successor;
        }

    }

    /**
     * @param value
     * @return {@code int}
     * @discription 寻找某个值的后继值，可以理解为下一个比这个value大的值
     * @author dme
     * @date 2025/8/24 14:43
     **/
    public TreeNode predecessor(int value) {

        TreeNode start = root;
        TreeNode predecessor = null; //后继的指针
        while (start != null) {
            if (start.getValue() == value) {
                break;
            } else if (start.getValue() > value) {
                predecessor = start;
                start = start.getLeft();
            } else

                start = start.getRight();
        }
        //没找到
        if (start == null) {
            return null;
        }
        //如果有右子树，那么后继就是右子树的最小值
        if (start.getRight() != null)
            return minNode(start.getRight());
            //如果没有右子树，那么后继就是从右边来的，最近的祖先结点
            // 注意后继也可能为空，序列的最后一个元素就没有后继
        else {
            return predecessor;
        }
    }

    public TreeNode getParent(int value){

        TreeNode start = root;
        TreeNode parent = null;  //parent父结点

        while (start != null) {

            if (start.getValue() == value) {
                break;
            } else if (start.getValue() > value) {
                parent = start;
                start = start.getLeft();
            } else
            {
                parent = start;
                start = start.getRight();
            }

        }
        //没找到
        if (start == null) {
            System.out.println("无此结点");
            return null;
        }
        return parent;
    }

    /**
     * @return {@code int}
     * @discription 从树中删除某个元素,如果成功，返回被删除结点的值，否则返回-1
     * @author dme
     * @date 2025/8/24 14:46
     **/
    public int delete(int value) {

        TreeNode start = root;
        TreeNode parent = null;  //parent是要删除结点的父结点

        while (start != null) {

            if (start.getValue() == value) {
                break;
            } else if (start.getValue() > value) {
                parent = start;
                start = start.getLeft();
            } else
            {
                parent = start;
                start = start.getRight();
            }

        }
        //没找到
        if (start == null) {
            System.out.println("无此结点");
            return -1;
        }

        if (start.getLeft()==null)
        {
            shift(parent,start,start.getRight());

        }
        else if (start.getRight()==null)
        {
            shift(parent,start,start.getLeft());
        }
        //将左右皆空的情况包含进前两种情况了
        else {
            //左右皆有，如果要维持顺序，应当找最接近被删除结点的的结点顶替，也就是它的前驱或者后继
            //第一步，找到被删除结点的后继
            //代码执行到这里，被删除结点已经确定是左右子树均健全的了，所以直接找其右子树中最小的值，注意后继可能也有右子树，但不可能有左子树

            TreeNode predecessor = minNode(start.getRight());
            //此处判断后继和被删除结点是否相邻非常重要！
            // 如果相邻，此时后继的父亲就是被删除结点，此时不能把后继的孩子托孤给被删除结点，后继的孩子会在shift(parent,start,predecessor)执行后直接成为parent的孩子
            // 相邻意味着后继就是结点的右子树，因此相邻时不必考虑右子树问题，只需要把被删除结点的左子树交给后继

            if(start.getRight()!=predecessor){
                //先托孤后继的孩子
                TreeNode predeParent = getParent(predecessor.getValue());
                shift(predeParent,predecessor,predecessor.getRight());
                //由于不相邻，那么还需要把被删除结点的右子树交给后继
                predecessor.setRight(start.getRight());
            }
            //调用shift方法，让后继代替被删除结点与parent建立联系，由于找的是后继，所以node的左子树可能还没处理
            shift(parent,start,predecessor);
            //再把node的左子树交给后继
            predecessor.setLeft(start.getLeft());

        }
        return value;
    }
    /**
     * @discription 替换方法 用某个结点child来代替node，如果node是parent的左子树，则让child成为parent的左子树
     *
     * @author dme
     * @date 2025/8/24 15:37
     * @param parent
     * @param node
     * @param child
     * @return {@code void}
     **/
    public void shift(TreeNode parent,TreeNode node,TreeNode child){
        if (parent==null)
        {
            //父结点为空，说明node其实就是root结点，这种情况我们直接让child当根结点就行了
            root = child;
        }
        //直接让parent与child建立联系，注意此处node与child的关系并未解除
        else if(node == parent.getLeft())
        {
            parent.setLeft(child);
        }
        else
        {
            parent.setRight(child);
        }

    }

    /**
     * @param value
     * @return {@code void}
     * @discription 向树中添加某个元素，假设添加的数在二叉树中不存在
     * @author dme
     * @date 2025/8/24 14:57
     **/
    public void put(int value) {
        TreeNode start = root;
        TreeNode parent = null;

        while (start != null) {
            parent = start;
            if (start.getValue() > value) {
                start = start.getLeft();
            }
            else
                start = start.getRight();
        }
        //循环结束，需要插入的位置已经找到，仍需判断是从左边来的 还是右边来的
        if (parent.getValue()>value){
            parent.setLeft(new TreeNode(value));
        }
        else
            parent.setRight(new TreeNode(value));
    }
    /**
     * @discription 递归的方式实现删除，然后返回删剩下的结点
     * 递归法通过return完成联系的建立  通过嵌套删除完成后继孩子的处理
     *
     * @author dme
     * @date 2025/8/24 21:08
     * @param
     * @param value
     * @return {@code Study.TreeNode}     返回删除后剩下的结点
     **/
    //！！！本类中最最重要的方法 多看
    public void doRecurtion(int value){
        recurtionDelete(root,value);
    }

    public TreeNode recurtionDelete(TreeNode node,int value){

        if(node==null){
            return null;
        }
        if (node.getValue()>value)
        {
            //进入左子树,由于返回的是删除后剩下的结点，所以我们需要让返回值和当前结点node建立联系
            node.setLeft(recurtionDelete(node.getLeft(),value));
            //如果代码指定到这里 说明删除已经完成 直接return node即可
            return node;
        }
        else if (node.getValue()<value){
            node.setRight(recurtionDelete(node.getRight(),value));
            return node;
        }

        //代码执行到这里说明找到了值相等的node，我们还是老样子先判断
        if(node.getLeft()==null) //左空返右
            return node.getRight();
        else if (node.getRight()==null)//右空返左
            return node.getLeft();
        else {//均不为空
            TreeNode predecessor = minNode(node.getRight());//拿到后继结点
            predecessor.setRight(recurtionDelete(node.getRight(),predecessor.getValue())); //从node的右子树中删除后继，拿到删除后的结果作为后继的右子树
            predecessor.setLeft(node.getLeft());        //把node的左子树交给后继，此时代替过程完成，返回后继
            return predecessor;
        }

    }


    public void print(){
        System.out.print("[");
        doPrint(root);
        System.out.print("]");

    }
    public void doPrint(TreeNode node){

        if (node==null)
            return;
        doPrint(node.getLeft());
        System.out.print(node.getValue()+",");
        doPrint(node.getRight());
    }
}
