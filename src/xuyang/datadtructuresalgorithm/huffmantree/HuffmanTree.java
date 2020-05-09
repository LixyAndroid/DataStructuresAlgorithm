package xuyang.datadtructuresalgorithm.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Li Xuyang
 * @date 2020/5/9 15:38
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);
        preOrder(root);
        //测试一把
    }

    //编写前序遍历
    public static void preOrder(Node root) {
        if (root != null) {
            root.perOrder();
        } else {
            System.out.println("空树不能遍历");
        }
    }

    //创建赫夫曼树的方法
    public static Node createHuffmanTree(int[] arr) {

        //第一步为了操作方便
        //1，遍历arr数组
        //2，将arr的每个元素构成一个Node
        //3,将Node放入到ArrayList中
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        //我们处理的过程是循环的过程
        while (nodes.size() > 1) {
            //排序，从小到大
            Collections.sort(nodes);

            System.out.println("nodes = " + nodes);

            //取出根结点权值最小的两颗二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            //构建新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //从arrList删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            //将parent加入到nodes
            nodes.add(parent);

        }

        //返回哈夫曼树的root结点
        return nodes.get(0);


    }

}

//创建结点类
//为了让Node,对象支持排序Collections 集合排序
//让Node 实现，接口
class Node implements Comparable<Node> {
    int value;//结点权值
    Node left;
    Node right;

    //写一个前序遍历

    public void perOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.perOrder();
        }
        if (this.right != null) {
            this.right.perOrder();
        }

    }


    public Node(int x) {
        value = x;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node node) {
        //从小到大
        return this.value - node.value;
    }
}
