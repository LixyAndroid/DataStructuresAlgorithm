package xuyang.datadtructuresalgorithm;

import java.util.Scanner;

/**
 * @author Li Xuyang
 * date  2019/9/14 15:57
 * 数组模拟队列
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {

        //初始化，创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);

         //接收用户输入
        char key = ' ';

        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            System.out.println("请输入上述指令：");
            //接收一个字符
            key = scanner.next().charAt(0);

            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;

                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                    //查看队列头
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                    //退出
                case  'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;

            }
        }
        System.out.println("程序退出");
    }


}

//使用数组模拟队列 编写一个ArrayQueue类
class ArrayQueue {
    //最大容量
    private int maxSize;
    //头
    private int front;
    //尾
    private int rear;
    //该数组用于存放数据，模拟队列
    private int[] arr;
    //创建队列的构造器

    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头部，分析出front是指向队列头的前一个位置
        rear = -1;//指向队列尾，指向队列尾的数据（即就是队列最后的一个数据）
    }

    //判读队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return  rear==front;
    }

    //添加数据到队列
    public  void addQueue(int n){
        //判断队列是否满
        if (isFull()){
            System.out.println("队列满");
            return;
        }

        //让rear后移
        rear++;
        arr[rear] = n;

    }

    //获取队列的数据，出队列

    public int getQueue(){
        //判断队列是否为空
        if (isEmpty()){

            //通过抛出异常,throw导致代码return;
            throw new  RuntimeException("队列为空，不能取数据");
        }
        
        front++; //front后移
        
        return arr[front];
        
    }
    
    //显示队列的所有数据
    public void showQueue(){
        //遍历
        if (isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }


        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);

        }
        
    }

    //显示队列的头数据，不是取出数据
     public int headQueue(){
        //判断
         if (isEmpty()){
             throw new RuntimeException("队列为空，没有数据");
         }
         return arr[front+1];
     }


}
