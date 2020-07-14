package xuyang.datadtructuresalgorithm.huffmancode;

import java.util.*;

/**
 * @author Li Xuyang
 * @date 2020/7/14 20:46
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length);
        List<Node> nodes = getNodes(contentBytes);
        System.out.println("nodes = " + nodes);

        //测试
        System.out.println("huffman树");
        Node huffmanTreeNodeRoot = createHuffmanTree(nodes);
        System.out.println("前序遍历");
        preOrder(huffmanTreeNodeRoot);

    }


    //前序遍历
    private static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("赫夫曼树为空");
        }
    }


    /**
     * @param bytes
     * @return
     */
    private static List<Node> getNodes(byte[] bytes) {

        ArrayList<Node> nodes = new ArrayList<>();

        //遍历bytes ，统计每一个byte出现的次数 -> map[key,value]
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {

            Integer count = counts.get(b);
            if (count == null) {//Map里没有这个字符
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }

        //把每一个键值对，转成Node，对象，并加入nodes集合
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    //通过list,创建对应的huffman树

    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            //排序，从小到大
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            //创建一颗新的二叉树，它的根结点没有data,只有权值
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            //将已经处理的二叉树，从nodes移除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将新的加入
            nodes.add(parent);
        }

        //返回的结点，nodes最后的结点，就是huffman树的根结点

        return nodes.get(0);
    }
}

//创建Node,数据和权值
class Node implements Comparable<Node> {
    Byte data;//存放数据本身
    int weight;//权值

    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node node) {
        //从小到大排
        return this.weight - node.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
//                ", left=" + left +
//                ", right=" + right +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }

    }

}