public class BinaryTree<T> {       //二叉树类，二叉链表存储，T指定结点的元素类型
    public BinaryNode<T> root;     //根结点，二叉链表结点结构
    public BinaryTree() {          //构造空二叉树
        this.root = null;
    }
    public boolean isEmpty() {     //判断是否是空二叉树
        return this.root == null;
    }
    public BinaryNode<T> insert(T x){       //插入x作为根结点，原根结点作为x的左孩子；返回插入结点
        return this.root = new BinaryNode<T>(x,this.root,null);
    }
    public BinaryNode<T> insert(BinaryNode<T> parent,T x,boolean leftChild){
        if(x == null)
            return null;
        if(leftChild)
            return parent.left = new BinaryNode<T>(x,parent.left,null);
        return parent.left = new BinaryNode<T>(x,null,parent.right);
    }
    public void remove(BinaryNode<T>parent,boolean leftChild) {
    //删除parent结点的左或右子树，leftChild指定子树，取值为ture（左）、false（右）
        if(leftChild)
            parent.left = null;
        else parent.right = null;
    }
    public void clear() {
        this.root = null;
    }
    public void preorder() {        //输出先根次序遍历序列
        preorder(this.root);        //先根次序遍历以root结点为根的二叉树
        System.out.println();
    }
    public void preorder(BinaryNode<T> p) {        //先根次序遍历以p结点为根的子树，递归方法
        if(p!= null) {
            System.out.print(p.data.toString() + " ");       //访问当前节点元素
            preorder(p.left);       //按先根次序遍历p的左子树，递归调用，参数为左孩子
            preorder(p.right);       //按先根次序遍历p的右子树，递归调用，参数为右孩子
        }
    }
    public String toString() {      //返回先根遍历二叉树所有结点的描述字符串，包括空子树标记
        return toString(this.root);
    }
    public String toString(BinaryNode<T> p) {      //返回先根次序遍历以p为根的子树描述串，递归
        if(p!= null)
            return "^";      //输出空子树标记
        return p.data.toString() + " " + toString(p.left) + toString(p.right);
    }
    public void inorder() {      //输出中根次序遍历序列
        inorder(this.root);
        System.out.println();
    }
    public void inorder(BinaryNode<T> p) {       //中根次序遍历以p结点为根的子树，递归
        if(p!= null) {
            inorder(p.left);       //中根次序遍历p的左子树，递归
            System.out.print(p.data.toString() + " ");
            inorder(p.right);       //中根次序遍历p的右子树，递归
        }
    }
    public void postorder() {      //输出后根次序遍历序列
        postorder(this.root);
        System.out.println();
    }
    public void postorder(BinaryNode<T> p) {       //后根次序遍历以p结点为根的子树，递归
        if(p!= null) {
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.data.toString() + " ");       //后访问当前结点元素
        }
    }
    public BinaryTree(T[] prelist) {       //构造二叉树，prelist数组指定二叉树标明空子树的先根遍历序列
        this.root = create(prelist);
    }
    private int i = 0;      //以从i开始的标明空子树的先根序列，创建一颗以prelist【i】为根的子树，返回根结点，递归
    private BinaryNode<T> create(T[] prelist){
        BinaryNode<T> p = null;
        if(i<prelist.length) {
            T elem = prelist[i];
            i++;
            if(elem != null && !elem.equals("#")) {      //因题目要求，elem也不能为“#”
                p = new BinaryNode<T>(elem);       //创建叶子结点
                p.left = create(prelist);       //创建p的左子树，递归
                p.right = create(prelist);       //创建p的右子树，递归
            }
        }
        return p;
    }
    public void preorderTraverse() {      //先根次序遍历二叉树的非递归算法
        LinkedStack <BinaryNode<String>> stack = new LinkedStack<BinaryNode<String>>();
        BinaryNode<T> p = this.root;
        while(p!=null || !stack.isEmpty())      //p或栈非空
            if(p!=null) {
                System.out.print(p.data + " ");       //访问结点
                stack.push((BinaryNode<String>) p);       //p入栈
                p = p.left;       //进入左子树

            }
            else {
                System.out.print("^");
                p = (BinaryNode<T>) stack.pop();      //p指向出栈结点
                p = p.right;      //进入右子树
            }
        System.out.println();
    }
    public void inorderTraverse() {      //中根次序遍历二叉树的非递归算法
        LinkedStack <BinaryNode<String>> stack = new LinkedStack<BinaryNode<String>>();
        BinaryNode<T> p=this.root;
        /*
        创建一个元素类型为二叉链表结点的空栈，p指向根结点的地址，
        当p非null或栈非空时，结点入栈，访问左子树，
        当p为null时，p指向出栈结点。
        访问当前结点，进入右子树。
         */
        while(p!=null || !stack.isEmpty())
        {
            if(p!=null)
            {
                stack.push((BinaryNode<String>) p);
                p=p.left;
            }
            else
            {
                p = (BinaryNode<T>) stack.pop();
                System.out.print(p.data + " ");
                p=p.right;
            }
        }
        System.out.println();
    }
}
