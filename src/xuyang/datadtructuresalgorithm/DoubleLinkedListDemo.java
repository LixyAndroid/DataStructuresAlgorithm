package xuyang.datadtructuresalgorithm;

/**
 * @author Li Xuyang
 * @date : 2019/10/27 15:41
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {

    }
}

//创建一个双向链表的类
class DoubleLinkedList {
    //先初始化一个头节点，不存放具体数据
    private DoubleHeroNode doubleHead = new DoubleHeroNode(0, "", "");

    //返回头节点
    public DoubleHeroNode getDoubleHead() {
        return doubleHead;
    }

    //遍历双向链表的方法
    //显示链表（遍历）
    public void list() {
        if (doubleHead.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        DoubleHeroNode temp = doubleHead.next;

        while (true) {

            //判断是否到链表的最后
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);

            //将temp 后移 一点小心
            temp = temp.next;
        }

    }

    //添加节点到双向链表的最后
    public void add(DoubleHeroNode doubleHeroNode) {

        //因为head节点不能动，因此我们需要一个辅助遍历temp
        DoubleHeroNode temp = doubleHeroNode;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，就将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后

        //形成一个双向链表
        temp.next = doubleHeroNode;
        doubleHeroNode.pre = temp;

    }


    //修改一个节点内容，可以看到双向链表的节点内容修改和单向链表一样
    public void update(DoubleHeroNode newHeroNode) {
        //判断是否空
        if (doubleHead.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助遍历
        DoubleHeroNode temp = doubleHead.next;
        boolean flag = false; //表示是否找到该节点
        while (true) {
            if (temp == null) {
                break; //已经遍历结束
            }
            if (temp.no == newHeroNode.no) {
                //找到了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到编号 %d 的节点，不能修改\n", newHeroNode.no);
        }
    }

    //从双向链表中删除节点

    //1 对于双向链表，我们可以直接找到要删除的这个节点
    //2 找到后，自我删除即可
    public void del(int no) {

        //判断当前链表是否为空
        if (doubleHead.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }


        DoubleHeroNode temp = doubleHead.next;
        boolean flag = false;//标识是否找到待删除节点的前一
        while (true) {
            if (temp == null) {  //已经找到链表的最后
                break;
            }
            if (temp.no == no) {
                //找到待删除节点的前一个绩点
                flag = true;
                break;
            }

            temp = temp.next; //temp 后移，遍历
        }
        if (flag) {
            //可以删除
            temp.pre.next = temp.next;

            //有问题
            //如果是最后一个节点，就不需要执行下面这句话，否则出现空指针
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的点 %d 节点不存在\n", no);
        }

    }


}