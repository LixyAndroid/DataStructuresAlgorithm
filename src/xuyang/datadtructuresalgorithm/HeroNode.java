package xuyang.datadtructuresalgorithm;

/**
 * @author Li Xuyang
 * @date : 2019/10/27 15:42
 */ //定义HeroNode,每个HeroNode对象就是一个节点
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
