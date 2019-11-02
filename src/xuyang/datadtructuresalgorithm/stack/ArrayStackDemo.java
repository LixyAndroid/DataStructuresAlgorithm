package xuyang.datadtructuresalgorithm.stack;

import java.util.Scanner;

/**
 * @author Li Xuyang
 * @date : 2019/11/2 21:30
 */
public class ArrayStackDemo {
    public static void main(String[] args) {

        //先创建ArrayStack一个对象
        ArrayStack stack = new ArrayStack(4);

        String key = "";
        boolean loop = true;//控制是否退出菜单
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show:表示显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:表示添加数据到栈（入栈）");
            System.out.println("pop:表示从栈中取出数据，出栈");
            System.out.println("请输入你的选择");

            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据为%d\n", res);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "exit":
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


