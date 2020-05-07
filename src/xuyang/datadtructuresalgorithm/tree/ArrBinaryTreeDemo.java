package xuyang.datadtructuresalgorithm.tree;

/**
 * @author Li Xuyang
 * @date 2020/5/7 15:13
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        //创建一个ArrBinaryTree
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
    }

}

class ArrBinaryTree{

    //存储数据结点的数组
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //重载
    public void preOrder(){
        this.preOrder(0);
    }

    //编写一个方法顺序存储二叉树的前序遍历

    /**
     *
     * @param index 数组的下标
     */
    public void preOrder(int index){

        //如果数组为空，或者arr.length =0
        if (arr==null||arr.length==0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }

        //输出当前这个元素
        System.out.println(arr[index]);

        //向左递归
        if (index*2+1<arr.length){
            preOrder(index*2+1);
        }
        //向右递归
        if (index*2+2<arr.length){
            preOrder(index*2+2);
        }

    }

}
