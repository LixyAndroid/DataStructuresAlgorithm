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
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        //显示
        singleLinkedList.list();
    }


}

//定义SingleLinkedList 管理我们的英雄
class SingleLinkedList{
    //先初始化一个头节点，头节点不要动,不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");

    //添加节点到单链表
    /*
    思路：当不考虑编号顺序时
    1，找到当前链表的最后节点
    2，将最后这个节点的next 指向新的结点
     */
    public void add(HeroNode heroNode){

        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true){
            //找到链表的最后
            if (temp.next == null){
                break;
            }
            //如果没有找到最后，就将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后的节点的next
        temp.next = heroNode;

    }

    //显示链表（遍历）
    public  void list(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;

        while (true){

            //判断是否到链表的最后
            if (temp ==null){
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
class HeroNode{

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
