package DataStructure.tree;

public class BSTree<T extends Comparable<T>>{
    private BSTNode<T> mRoot; // 根节点

    // 内部类，定义二叉搜索树中的节点
    public static class BSTNode<T extends Comparable<T>>{
        T key; // 值
        BSTNode<T> left; // 左孩子
        BSTNode<T> right; // 右孩子
        BSTNode<T> parent; // 父节点

        // 构造方法
        public BSTNode(T key, BSTNode<T> left, BSTNode<T> right, BSTNode<T> parent) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

    // 前序遍历
    public void preOrder(){
        preOrder(mRoot);
    }

    public void preOrder(BSTNode<T> tree){
        // 如果树不为空
        if(tree != null){
            System.out.print(tree.key+"");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    // 中序遍历
    public void inOrder(){
        inOrder(mRoot);
    }

    public void inOrder(BSTNode<T> tree){
        if(tree != null){
            inOrder(tree.left);
            System.out.print(tree.key+"");
            inOrder(tree.right);
        }
    }

    // 后序遍历
    public void postOrder(){
        postOrder(mRoot);
    }

    public void postOrder(BSTNode<T> tree){
        if(tree != null){
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.key+"");
        }
    }

    // 递归版查找值
    private BSTNode<T> search_recursion(T key){
        return search_recursion(mRoot, key);
    }

    private BSTNode<T> search_recursion(BSTNode<T> tree, T key){
        // 如果根节点不存在，则返回空
        if(tree == null){
            return tree;
        }
        // 当compare>0,则当前的key值小于要找的key值
        // 当compare<0,则当前的key值大于要找的key值
        int compare = key.compareTo(tree.key);
        if(compare > 0){
            return search_recursion(tree.right, key);
        }
        else if(compare < 0){
            return search_recursion(tree.left, key);
        }
        else{
            return tree;
        }
    }

    // 非递归版查找值
    public BSTNode<T> search(BSTNode<T> tree, T key){
        while(tree != null){
            int compare = key.compareTo(tree.key);
            if(compare < 0){
                tree = tree.left;
            }
            else if(compare > 0){
                tree = tree.right;
            }
            else
                return tree;
        }
        return tree;
    }

    private BSTNode<T> search(T key){
        return search(mRoot, key);
    }

    // 查找最大值节点
    private BSTNode<T> maximum(BSTNode<T> tree){
        if(tree == null){
            return tree;
        }
        // 因为要找最大值，所以一直遍历右子树即可
        while(tree.right != null){
            tree = tree.right;
        }
        return tree;
    }

    public T maximum(){
        BSTNode<T> p = maximum(mRoot);
        if(p != null){
            return p.key;
        }
        return null;
    }

    // 查找最小值节点
    private BSTNode<T> minimum(BSTNode<T> tree){
        if(tree == null){
            return tree;
        }
        while(tree.left != null){
            tree = tree.left;
        }
        return tree;
    }

    public T minimum(){
        BSTNode<T> p = minimum(mRoot);
        if(p != null){
            return p.key;
        }
        return null;
    }

    // 节点的前驱：是该节点的左子树的最大节点
    public BSTNode<T> predecessor(BSTNode<T> tree){
        // 如果存在左子树
        if (tree.left != null) {
            return maximum(tree.left);
        }
        // 如果tree没有左子树，则有如下可能
        // 1.如果是右孩子，则前驱节点正好是其父节点
        // 2.如果是左孩子，则查找x的的最低父节点（值正好比他小），并且该父节点要有右孩子（保证正好夹在中间）
        BSTNode<T> father = tree.parent;
        while((father != null) && (tree == father.left)) {
            tree = father;
            father = father.parent;
        }
        return father;
    }


    // 节点的后驱：是该节点的右子树的最小节点
    public BSTNode<T> successor(BSTNode<T> tree){
        // 如果存在右子树
        if(tree.right != null){
            return minimum(tree.right);
        }
        // 如果tree没有右子树，则有以下可能
        // 1. 如果是左孩子，则后继就是父节点
        // 2. 如果是右孩子，则查找x的的最低父节点（值正好比他大），并且该父节点要有左孩子（保证正好夹在中间）
        BSTNode<T> father = tree.parent;
        while((father != null) && (tree  == father.right)){
            tree = father;
            father = father.parent;
        }
        return father;
    }

    // 插入新节点
    private void insert(BSTree<T> bst, BSTNode<T> newNode){
        int compare;
        // y负责记录父节点
        BSTNode<T> y = null;
        BSTNode<T> x = bst.mRoot;

        // 查找newNode要插入的位置
        while(x != null){
            y = x;
            compare = newNode.key.compareTo(x.key);
            if(compare < 0){
                x = x.left;
            }
            else{
                x = x.right;
            }
        }
        newNode.parent = y;
        if(y == null){
            bst.mRoot = newNode;
        }
        else{
            compare = newNode.key.compareTo(y.key);
            if(compare < 0){
                y.left = newNode;
            }
            else{
                y.right = newNode;
            }
        }
    }

    public void insert(T key){
        BSTNode<T> z = new BSTNode<>(key, null, null, null);
        // 如果创建节点成功，则返回
        if(z != null){
            insert(this, z);
        }
    }

    // 删除节点oldNode,并返回被删除的节点
    private BSTNode<T> remove(BSTree<T> bst, BSTNode<T> oldNode){
        BSTNode<T> x = null;
        BSTNode<T> y = null;
        // 如果被删除的节点只有左孩子，或者只有右孩子
        if((oldNode.left == null) || (oldNode.right == null)){
            y = oldNode;
        }
        else{
            // 如果被删除的节点既有左孩子，也有右孩子，则直接找
            y = predecessor(oldNode);
        }
        // 如果被删除的节点只是没有左孩子，或者只是没有右孩子，则让孩子直接顶替即可
        if(y.left != null){
            x = y.left;
        }
        else{
            x = y.right;
        }
        if(x != null){
            x.parent = y.parent;
        }
        if(y.parent == null){
            bst.mRoot = x;
        }
        else if(y == y.parent.left){
            y.parent.left = x;
        }
        else{
            y.parent.right = x;
        }
        if(y != oldNode){
            oldNode.key = y.key;
        }
        return y;
    }

    public void remove(T key){
        BSTNode<T> oldNode, node;
        // 判断要删除的节点是否存在
        if((oldNode = search(mRoot, key)) != null){
            if((node = remove(this, oldNode)) != null){
                node = null;
            }
        }
    }


    /*
     * 打印"二叉查找树"
     *
     * key        -- 节点的键值
     * direction  --  0，表示该节点是根节点;
     *               -1，表示该节点是它的父结点的左孩子;
     *                1，表示该节点是它的父结点的右孩子。
     */
    private void print(BSTNode<T> tree, T key, int direction) {

        if(tree != null) {

            if(direction==0)    // tree是根节点
                System.out.printf("%2d is root\n", tree.key);
            else                // tree是分支节点
                System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction==1?"right" : "left");

            print(tree.left, tree.key, -1);
            print(tree.right,tree.key,  1);
        }
    }

    public void print() {
        if (mRoot != null)
            print(mRoot, mRoot.key, 0);
    }

    /*
     * 销毁二叉树
     */
    private void destroy(BSTNode<T> tree) {
        if (tree==null)
            return ;

        if (tree.left != null)
            destroy(tree.left);
        if (tree.right != null)
            destroy(tree.right);

        tree=null;
    }

    public void clear() {
        destroy(mRoot);
        mRoot = null;
    }





}
