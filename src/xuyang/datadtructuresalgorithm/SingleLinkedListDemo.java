package xuyang.datadtructuresalgorithm;

/**
 * @author Li Xuyang
 * date  2019/9/24 22:27
 * 带头结点单链表
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {

        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        //加入按照编号
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);

        singleLinkedList.list();


        //测试修改
        HeroNode newHerNode = new HeroNode(2, "小卢", "麒麟~~~~~");
        singleLinkedList.update(newHerNode);
        System.out.println("修改后的链表的情况~~~");


        //删除
        singleLinkedList.del(1);

        //显示
        singleLinkedList.list();

        System.out.println("有效的节点个数 = "+getLength(singleLinkedList.getHead()));

        HeroNode res = findLastIndexNode(singleLinkedList.getHead(),1);

        System.out.println(res);
    }



    //查找单链表中的倒数第k个结点 【新浪面试题】
    //思路
    /*
    1，编写一个方法，接收head节点，同时接收一个index
    2,index表示是倒数第index个节点
    3，先把链表从头到尾遍历，得到链表的总长度getLength
    4，得到size后，我们从链表的第一个开始遍历（size-index）个，就可以得到
    5，如果找到了，则返回该节点，否则返回null
     */
    public  static HeroNode findLastIndexNode(HeroNode head,int index){
        if (head.next == null){
            return  null; //没有找到
        }


        //第一次遍历得到链表的长度（节点个数）
        int size = getLength(head);

        //第二次遍历size-index 位置，就是我们倒数的第K个节点
        //先做一个index的校验
        if (index <=0 || index >size){
            return null;
        }
        //定义辅助变量,for循环定位到倒数的index
        HeroNode cur = head.next;

        for (int i = 0; i < size - index; i++){
            cur = cur.next;
        }
        return  cur;


    }





    //方法：获取到单链表的节点的个数（如果是带头节点的链表，需求不统计头节点）

    /**
     *
     * @param head 链表的头节点
     * @return 返回的就是有效节点的个数
     */

    public  static  int getLength(HeroNode head){
        if (head.next == null){ //空链表
            return 0;
        }

        int length = 0;

        //定义辅助变量，这里我们没有统计头节点
        HeroNode cur = head.next;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }


}

//定义SingleLinkedList 管理我们的英雄
class SingleLinkedList {
    //先初始化一个头节点，头节点不要动,不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");


    //返回头节点
    public HeroNode getHead() {
        return head;
    }

    //添加节点到单链表
    /*
    思路：当不考虑编号顺序时
    1，找到当前链表的最后节点
    2，将最后这个节点的next 指向新的结点
     */
    public void add(HeroNode heroNode) {

        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode temp = head;
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
        //将最后的节点的next
        temp.next = heroNode;

    }

    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    //（如果有这个排名，则添加失败，并给出提示）
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针（变量）来帮助找到添加的位置
        //因为单链表，因为我们找到的temp是位于添加位置的前一个节点，否则添加不了
        HeroNode temp = head;
        boolean flag = false; //标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) {//说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) { //位置找到，就在temp后面插入
                break;
            } else if (temp.next.no == heroNode.no) { //说明希望添加的heroNode的 编号已经存在

                flag = true;
                break;
            }
            temp = temp.next; //后移，遍历当前链表

        }

        //判断flag的值
        if (flag) { //不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号 %d 已经存在了，不能加入\n", heroNode.no);
        } else {
            //插入到链表中，temp后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }


    //修改节点的信息，根据no编号来修改，即no编号不能改
    //1，根据newHeroNode 的no 来修改
    public void update(HeroNode newHeroNode) {
        //判断是否空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助遍历
        HeroNode temp = head.next;
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


    //删除节点
    //思路
    //1,head不能动，因此我们需要一个temp 辅助节点找到待删除的节点的前一个节点
    //2，说明我们在比较时，是temp.next.no 和需要删除的节点no的比较
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;//标识是否找到待删除节点的前一
        while (true){
            if (temp.next == null){
                break;
            }if (temp.next.no == no){
                //找到待删除节点的前一个绩点
                flag = true;
                break;
            }

            temp = temp.next; //temp 后移，遍历
        }
        if (flag){
            //可以删除
            temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的点 %d 节点不存在\n",no);
        }

    }

    //显示链表（遍历）
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;

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
}


//定义HeroNode,每个HeroNode对象就是一个节点
class HeroNode {

    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点


    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方便

    /*
    修改toString,不打印next域
     */
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname +
                '}';
    }

}
