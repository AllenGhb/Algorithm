
class RBTree<T extends Comparable<T>> {
    /** 根节点 **/
    private RBNode<T> root;
    /** 红黑树标志 **/
    private static final boolean RED = false;
    private static final boolean BLACK = false;

    public class RBNode<T extends Comparable<T>> {
        /** 颜色 **/
        boolean color;
        /** 值 **/
        T key;
        /** 父节点 **/
        RBNode<T> parent;
        /** 左子节点 **/
        RBNode<T> left;
        /** 右子节点 **/
        RBNode<T> right;

        public RBNode(boolean color, T key, RBNode<T> parent, RBNode<T> left, RBNode<T> right) {
            this.color = color;
            this.key = key;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public T getKey() {
            return key;
        }

        public String toString(){
            return ""+key+(this.color == RED ? "R" : "B");
        }

    }

    public RBTree(){
        root = null;
    }

    /** 获得父节点 **/
    public RBNode<T> parentOf(RBNode<T> node){
        return node.parent;
    }

    /** 设置父节点 **/
    public void setParent(RBNode<T> node, RBNode<T> parent) {
        if (node != null) {
            node.parent = parent;
        }
    }

    /** 获得节点的颜色 **/
    public boolean colorOf(RBNode<T> node){
        return null != node ? node.color : BLACK;
    }

    /** 判断节点的颜色 **/
    public boolean isRed(RBNode<T> node){
        return node != null && node.color == RED;
    }

    public boolean isBlack(RBNode<T> node){
        return !isRed(node);
    }

    /** 设置节点的颜色 **/
    public void setColor(RBNode<T> node,boolean color) {
        if (node != null) {
            node.color = color;
        }
    }

    /***************** 前序遍历红黑树 *********************/
    
    public void preOrder(){
        preOrder(root);
    }
    
    private void preOrder(RBNode<T> tree) {
        if (tree != null) {
            System.out.println(tree.key + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    /***************** 中序遍历红黑树 *********************/

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(RBNode<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.println(tree.key + " ");
            inOrder(tree.right);
        }
    }

    /***************** 后序遍历红黑树 *********************/

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(RBNode<T> tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.println(tree.key + " ");
        }
    }

    /**************** 查找红黑树中键值为key的节点 ***************/
    private RBNode<T> search(T key){
        return searchByCycle(root,key);
        // return searchByRecursive(root,key);
    }

    private RBNode<T> searchByRecursive(RBNode<T> tree, T key) {
        if (tree == null) {
            return null;
        }
        int compare = key.compareTo(tree.key);
        if (compare < 0) {
            searchByRecursive(tree.left, key);
        } else if (compare > 0) {
            searchByRecursive(tree.right, key);
        }
        return tree;
    }

    private RBNode<T> searchByCycle(RBNode<T> tree, T key) {
        while (tree != null) {
            int compare = key.compareTo(tree.key);
            if (compare < 0) {
                tree = tree.left;
            } else if (compare > 0) {
                tree = tree.right;
            } else {
                return tree;
            }
        }
        return null;
    }

    /**************** 查找最小节点的值 **********************/
    public T minValue() {
        RBNode<T> minNode = minNode(root);
        if (minNode != null) {
            return minNode.key;
        }
        return null;
    }

    private RBNode<T> minNode(RBNode<T> root) {
        if (null == root) {
            return null;
        }
        if (null == root.left) {
            return root;
        }
        return minNode(root.left);
    }

    /******************** 查找最大节点的值 *******************/
    public T maxValue() {
        RBNode<T> maxNode = maxNode(root);
        if (maxNode != null) {
            return maxNode.key;
        }
        return null;
    }

    private RBNode<T> maxNode(RBNode<T> root) {
        if (null == root) {
            return null;
        }
        if (null == root.right) {
            return root;
        }
        return maxNode(root.right);
    }

    /********* 查找节点x的后继节点,即大于节点x的最小节点 ***********/
    public RBNode<T> successor(RBNode<T> x) {
        if (x.right == null) {
            RBNode<T> p = x.parent;
            while (p != null && p.right == x) {
                x = p;
                p = x.parent;
            }
            return p;
        }
        return minNode(x.right);
    }

    /********* 查找节点x的前驱节点，即小于节点x的最大节点 ************/
    public RBNode<T> predecessor(RBNode<T> x) {
        if (x.left == null) {
            RBNode<T> p = x.parent;
            while (p != null && p.left == x) {
                x = p;
                p = x.parent;
            }
            return p;
        }
        return maxNode(x.left);
    }

    /**
     * 左旋示意图：对节点x进行左旋
     *     p                       p
     *    /                       /
     *   x                       y
     *  / \                     / \
     * lx  y      ----->       x  ry
     *    / \                 / \
     *   ly ry               lx ly
     * 左旋做了三件事：
     * 1. 将y的左子节点赋给x的右子节点,并将x赋给y左子节点的父节点(y左子节点非空时)
     * 2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
     * 3. 将y的左子节点设为x，将x的父节点设为y
     */
    private void leftRotate(RBNode<T> x){
        RBNode<T> y = x.right;
        x.right  = y.left;
        if(y.left != null){
            y.left.parent = x;
        }
        y.parent = x.parent;
        if(x.parent == null){
            this.root = y;
        }else {
            if(x == x.parent.left){
                x.parent.left = y;
            }else {
                x.parent.right = y;
            }
        }

        y.left = x;
        x.parent = y;
    }

    /**
     * 右旋示意图：对节点y进行右旋
     *        p                   p
     *       /                   /
     *      y                   x
     *     / \                 / \
     *    x  ry   ----->      lx  y
     *   / \                     / \
     * lx  rx                   rx ry
     * 右旋做了三件事：
     * 1. 将x的右子节点赋给y的左子节点,并将y赋给x右子节点的父节点(x右子节点非空时)
     * 2. 将y的父节点p(非空时)赋给x的父节点，同时更新p的子节点为x(左或右)
     * 3. 将x的右子节点设为y，将y的父节点设为x
     */
    private void rightRotate(RBNode<T> y){
        RBNode<T> x = y.left;
        y.left = x.right;
        if(x.right != null){
            x.right.parent = y;
        }
        x.parent = y.parent;
        if(y.parent == null){
            this.root = x;
        }else {
            if(y == y.parent.left){
                y.parent.left = x;
            }else {
                y.parent.right = x;
            }
        }
        x.right = y;
        y.parent = x;
    }

    public void insert(T key){
        RBNode<T> node = new RBNode<T>(RED,key,null,null,null);
        if(node != null){
            insert(node);
        }
    }

    public void insert(RBNode<T> node){
        RBNode<T> current =  null;
        RBNode<T> x = this.root;

        while (x != null){
            current = x;
            int cmp = node.key.compareTo(x.key);
            if(cmp < 0){
                x = x.left;
            }else {
                x = x.right;
            }
        }

        node.parent = current;

        if(current != null){
            int cmp = node.key.compareTo(current.key);
            if(cmp < 0){
                current.left = node;
            }else{
                current.right = node;
            }
        }else{
            this.root = node;
        }

        insertFixUp(node);
    }

    private void insertFixUp(RBNode<T> node){
        //定义父节点和祖父节点
        RBNode<T> parent, gparent;
        //需要修整的条件：父节点存在，且父节点的颜色是红色
        while(((parent = parentOf(node)) != null) && isRed(parent)){
            //获得祖父节点
            gparent = parentOf(parent);
            //若父节点是祖父节点的左子节点，下面else与其相反
            if(parent == gparent.left){
                // 获得叔叔节点
                RBNode<T> uncle = gparent.right;

            }
        }
    }

    /*********************** 删除红黑树中的节点 **********************/
    public void remove(T key){
        RBNode<T> node;
        /*if((node = search(key)) != null){
            remove(node);
        }*/
    }


}


