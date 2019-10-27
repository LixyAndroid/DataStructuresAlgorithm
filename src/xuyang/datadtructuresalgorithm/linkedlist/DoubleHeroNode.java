package xuyang.datadtructuresalgorithm.linkedlist;

/**
 * @author Li Xuyang
 * @date : 2019/10/27 15:42
 */ //DoubleHeroNode, 双向链表每个HeroNode对象就是一个节点
class DoubleHeroNode {

    public int no;
    public String name;
    public String nickname;
    public DoubleHeroNode next; //指向下一个节点，默认为null
    public DoubleHeroNode pre; //指向前一个节点，默认为null



    //构造器
    public DoubleHeroNode(int no, String name, String nickname) {
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
