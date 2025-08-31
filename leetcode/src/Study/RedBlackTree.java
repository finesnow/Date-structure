package Study;

/**
 * @author Administrator
 * @Date 2025/8/28 22:40
 * @package Study
 * @Description: 红黑树 特征：所有节点都有两种颜色，红与黑<p>
 * 1.所有null均视为黑色 2.红色节点不能相邻 3.根节点是黑色 4.从根到任意一个叶子节点 路径中的黑色节点数一样
 * 5.插入节点均视为红色    <p>
 * 所以红与黑其实是一种检查失衡的手段 类似于前面平衡树中的"高度"这一概念
 * 如果是插入导致的失衡，往往是因为总是往二叉树的一侧上不停地插入，这一情况通过"红红相邻"很容易检测
 * 平衡树的做法是插入完成后，递归向上更新左右子树的高度，然后再执行平衡操作
 *  当我们删除一个黑色结点时，将导致不平衡 因为这会使得一条路上面少一个黑色结点，违反原则5
 *  红色结点的删除往往会被转换成删除黑色结点的问题
 */
public class RedBlackTree {

    enum Color {
        RED, BLACK
    }
    private RBNode root;

    private static class RBNode {
        int key;
        Object value;
        RBNode left;
        RBNode right;
        RBNode parent;
        Color color = Color.RED;

        public RBNode(int key,Object value,RBNode parent) {
            this.value = value;
            this.key = key;
            this.parent = parent;
        }

        boolean isLeftChild() {
            if (this.parent == null) return false;
            return this.parent.left == this;
        }

        RBNode uncle() {
            if(parent == null || parent.parent == null){
                return null;
            }
            if (parent.isLeftChild())
                return parent.parent.right;
            else {
                return parent.parent.left;
            }
        }
        RBNode sibling(){
            if (parent == null){
                return null;
            }
            if (this.isLeftChild()){
                return parent.right;
            }
            else {
                return parent.left;
            }
        }
    }

    boolean isRed(RBNode rbNode){
        if (rbNode==null)
            return false;

        return rbNode.color ==Color.RED;
    }

    private void leftRotate(RBNode rbNode){
        RBNode parent = rbNode.parent;
        RBNode right = rbNode.right;
        rbNode.right = right.left;  //先转移right的左子树 防止其消失
        if (right.left!=null)
            right.left.parent = rbNode;


        right.left = rbNode;
        //父节点处理
        right.parent = null;
        rbNode.parent = right;
        if (parent==null){
             root = right;
        }
       else if (parent.left == rbNode)
        {
            parent.left =right;
        }
        else {
            parent.right = right;
        }
    }

    private void rightRotate(RBNode rbNode){
        RBNode parent = rbNode.parent;

        RBNode left = rbNode.left;
        rbNode.left = left.right;  //先转移left的右子树 防止其消失
        if (left.right!=null){
            left.right.parent = rbNode;
        }
        left.right = rbNode;
        //父节点处理
        //由下到上改变关系
        left.parent = rbNode.parent;
        rbNode.parent = left;
        //由上到下关系还没改

        if (parent==null){
            root = left;
        }
        else if (parent.left==rbNode){
            parent.left = left;

        }
        else {
            parent.right = left;
        }

    }

    public void put(int key,Object value){
        //case 1 插入的位置为根节点，将根节点变黑
        //case 2 插入的位置的父节点为黑色，无需调整
        //case 3 插入的位置的父节点为红色，触发红红相邻 叔叔的颜色也是红色
        // 将父亲的颜色变成黑色，同时将叔叔的颜色变成黑色
        //出现祖父子树黑色过多的情况，将祖父节点变成红色
        //祖父变红之后，继续触发红红相邻，递归调整
        //case 4 插入的位置的父节点为红色，触发红红相邻 叔叔的颜色是黑色
        //先将父亲变黑，再将祖父变红
        //此时仅通过变色无法重新平衡，需要旋转
        RBNode start = root;
        RBNode parent = null;

        while (start != null) {
            parent = start;
            if (start.key > key) {
                start = start.left;
            }
            else if (start.key < key)
                start = start.right;
            else
            {
                start.value = value;
                return;
            }
        }
        RBNode newNode = new RBNode(key,value,parent);
        if (parent==null){
            root = newNode;
        }
        //循环结束，需要插入的位置已经找到，仍需判断是从左边来的 还是右边来的
        else if (parent.key>key){
            parent.left = newNode;
        }
        else {
            parent.right = newNode;
        }
        fixRed(newNode);

    }

    private void fixRed(RBNode node){

        //case 1插入的位置为根节点，将根节点变黑
        if (node==root)
        {
            node.color = Color.BLACK;
            return;
        }
        //case 2 插入的位置的父节点为黑色，无需调整
        if(!isRed(node.parent))
        {
            return;
        }
        RBNode parent = node.parent;
        RBNode uncle = node.uncle();
        RBNode grandparent = parent.parent;
        //case 3 插入的位置的父节点为红色，触发红红相邻 叔叔的颜色也是红色
        if (isRed(uncle)){
            parent.color = Color.BLACK;
            uncle.color = Color.BLACK;
            grandparent.color = Color.RED;
            fixRed(grandparent);
        }
        else {
            //case 4 插入的位置的父节点为红色，触发红红相邻 叔叔的颜色是黑色
            if (parent.isLeftChild()&&node.isLeftChild())
            {//LL parent变黑，祖父变红，右旋
                parent.color = Color.BLACK;
                grandparent.color = Color.RED;
                rightRotate(grandparent);
            }
            else if (parent.isLeftChild())
            {
                //LR
                leftRotate(parent);
                //一次左旋之后，LR变成了LL 此时node相当于LL中的parent,
                //所以我们应该让node变黑，祖父依然变红 然后右旋
                node.color = Color.BLACK;
                grandparent.color = Color.RED;
                rightRotate(grandparent);
            }
            //RL
            else if (node.isLeftChild())
            {
                rightRotate(parent);
                node.color = Color.BLACK;
                grandparent.color = Color.RED;
                leftRotate(grandparent);
            }
            //RR
            else {
                parent.color = Color.BLACK;
                grandparent.color = Color.RED;
                leftRotate(grandparent);
            }

        }


    }
    private RBNode findReplaced(RBNode deleted){
        if (deleted.left==null&&deleted.right==null)
        {
            //左右皆空
            return null;
        }
        else if (deleted.left==null)
        {
            return deleted.right; // 左空返右
        }
        else if (deleted.right==null)
        {
            return deleted.left; //右空返左
        }
        //寻找后继
        RBNode successor = deleted.right;
        while (successor.left!=null)
        {
            successor = successor.left;
        }
         return successor;

    }

    public void remove(int key){
        RBNode deleted = find(key);
        if (deleted ==null){
            return;
        }
        else doRemove(deleted);
    }

    private void doRemove(RBNode deleted){
        //deleted 是要删除的结点
        RBNode replaced = findReplaced(deleted);
        RBNode parent = deleted.parent;//replaced可能是删剩下的结点，也可能只是后继
        if (replaced==null){//没有孩子
            if (deleted==root)
                root = null;
            else {

                if (deleted.color==Color.BLACK) //没有孩子时的平衡性调整 先调整
                {
                    //删除的是黑叶子复杂调整
                    fixDoubleBlack(deleted);
                }
                else {
                    //删除的是红叶子，无需调整
                }

                if (deleted.isLeftChild())    //没有孩子时的关系处理 再删除
                    parent.left = null;
                else
                    parent.right = null;
            }

            deleted.parent = null;
            return ;
        }
        if (deleted.left==null||deleted.right==null) //只有一个孩子结点
        {
            if (deleted==root){
                int t = deleted.key;
                deleted.key = replaced.key;
                replaced.key = t;
                root.left = null;
                root.right = null;
            }
            else {
                if (deleted.isLeftChild())              //先执行删除
                {
                    parent.left = replaced;
                }
                else {
                    parent.right = replaced;
                }
                replaced.parent = parent;
                deleted.left = deleted.right = deleted.parent = null; //关系处理

                //后执行平衡调整
                if (deleted.color==Color.BLACK && replaced.color==Color.BLACK)//删了黑色，剩下的也是黑色 原路径上少了一个黑
                {
                    fixDoubleBlack(replaced);
                }
                else if (deleted.color==Color.BLACK) //删了黑色，剩下的是红色 原路径上少了一个黑，我们可以让剩下的红色变黑
                {
                    replaced.color = Color.BLACK;
                }
            }
            return;
        }
        else {  //两个孩子都有  我们交换后继结点和删除结点的key和value 李代桃僵
            int t = deleted.key;
            deleted.key = replaced.key;
            replaced.key = t;
          //再把后继从树中删除,后继一定没有左子树  所以等于我们把问题从 ”删除一个双孩子的结点“ 变成了”删除一个单孩子或者没孩子的结点“
            doRemove(replaced);
        }

    }

    private void fixDoubleBlack(RBNode node) {


    }
    private RBNode find(int key){
        RBNode start = root;

        while (start != null) {
            if (start.key > key) {
                start = start.left;
            }
            else if (start.key < key)
                start = start.right;
            else
            {
                return  start;
            }
        }
        return start;
    }

}
