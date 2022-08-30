package DataStructure.tree;

// 参考网站
// https://segmentfault.com/a/1190000014743964
public class binaryTree {
    // 成员变量 -> 构建一个节点
    // 一个节点有三个部分构成，数据域，左指针，右指针
    private int data; // 数据
    private binaryTree leftChild; // 左指针
    private binaryTree rightChild; // 右指针
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public binaryTree getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(binaryTree leftChild) {
        this.leftChild = leftChild;
    }

    public binaryTree getRightChild() {
        return rightChild;
    }

    public void setRightChild(binaryTree rightChild) {
        this.rightChild = rightChild;
    }
    // 初始化二叉树
    // 初始化根节点
    private binaryTree root;

    public binaryTree() {}

    public binaryTree(binaryTree root) {
        this.root = root;
    }

    public binaryTree getRoot() {
        return root;
    }

    public void setRoot(binaryTree root) {
        this.root = root;
    }

    // 清空二叉树
    // 清楚某个子树当中的所有节点
    public void clear(binaryTree node){
        // 如果二叉树中存在节点
        if(node != null){
            clear(node.getLeftChild());
            clear(node.getRightChild());
            node = null; // 删除节点
        }
    }

    // 如果二叉树只存在一个节点，直接删掉根节点即可
    // 如果二叉树有大于一个的节点，先递归其他的节点
    // 直接删除整个二叉树的根节点
    public void clear(){
        clear(root);
    }

    // 判断二叉树是否为空
    public boolean isEmpty(){
        return root == null;
    }

    // 获得二叉树的高度
    // 首先构建一个获取以某一结点为子树的高度的方法，然后递归调用
    // 如果此节点为空，则返回0
    // 如果不为空，遍历比较左子树和右子树的高度
    // 选择高的那个为高度，再加上自己本身，即为高度

    public int height(){
        return height(root);
    }
    public int height(binaryTree node){
        if(node == null){
            return 0;
        }
        else{
            int left = height(node.getLeftChild());
            int right = height(node.getRightChild());
            return left > right ? (left + 1) : (right + 1);
        }
    }

    // 求二叉树的节点数
    public int size(){
        return size(root);
    }

    public int size(binaryTree node){
        if(node == null){
            return 0;
        }
        else{
            int left = size(node.getLeftChild());
            int right = size(node.getRightChild());
            return 1 + left + right;
        }
    }

    // 返回某节点的父节点
    public binaryTree getParent(binaryTree node){
        return (root == null || root == node) ? null : getParent(root, node);
    }
    // node节点是subTree子树的父节点
    public binaryTree getParent(binaryTree subTree, binaryTree node){
        // 如果subTree子树为空
        if(subTree == null){
            return null; // 空子树没有节点
        }
        // 如果子树的左右孩子是待查节点，返回子树的根节点
        if(subTree.getLeftChild() == node || subTree.getRightChild() == node){
            return subTree;
        }
        binaryTree parent = null;
        // 如果不为空，则遍历左右子树
        if(getParent(subTree.getLeftChild(), node) != null){
            parent = getParent(subTree.getLeftChild(), node);
            return parent;
        }
        else{
            parent = getParent(subTree.getRightChild(), node);
            return parent;
        }
    }

    // 返回左右子树
    // 通过节点即可获取
    public binaryTree getLeftTree(binaryTree node){
        return node.getLeftChild();
    }
    public binaryTree getRightTree(binaryTree node){
        return node.getRightChild();
    }

    // 向二叉树插入节点/子树
    public void insertLeft(binaryTree parent, binaryTree newNode){
        parent.setLeftChild(newNode);
    }

    public void insertRight(binaryTree parent, binaryTree newNode){
        parent.setRightChild(newNode);
    }

    // 二叉树的遍历

    // 前序遍历
    // 先遍历根节点
    // 然后遍历左子树
    // 然后遍历右子树
    public void PreOrder(binaryTree node){
        if(node != null){
            System.out.println(node.getData());
            PreOrder(node.getLeftChild());
            PreOrder(node.getRightChild());
        }
    }

    // 中序遍历
    // 先遍历左子树
    // 然后遍历根节点
    // 然后遍历右节点
    public void InOrder(binaryTree node){
        if(node != null){
            InOrder(node.getLeftChild());
            System.out.println(node.getData());
            InOrder(node.getRightChild());
        }
    }
    // 后序遍历
    // 先遍历左子树
    // 然后遍历右子树
    // 然后遍历根节点
    public void PostOrder(binaryTree node){
        if(node != null){
            PostOrder(node.getLeftChild());
            PostOrder(node.getRightChild());
            System.out.println(node.getData());
        }
    }
}
