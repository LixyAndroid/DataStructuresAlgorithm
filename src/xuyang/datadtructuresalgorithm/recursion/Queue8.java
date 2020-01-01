package xuyang.datadtructuresalgorithm.recursion;

/**
 * @author Li Xuyang
 * @date 2020/1/1 16:46
 */
public class Queue8 {

    //定义一个max 表示共有多少个皇后
    int max = 8;
    //定义一个一维数组，保存皇后的位置结果，比如arr = {0,4,7,5,2,6,1,3}
    int[] array = new int[max];

    static int count = 0;

    static int judgeCount = 0;

    public static void main(String[] args) {

        //测试一把，8皇后是否正确
        Queue8 queue8 = new Queue8();
        queue8.check(0);


        System.out.printf("一共有%d种解法", count);
        System.out.printf("判断冲突的%d次数", judgeCount);
    }

    //编写一个方法，放置第n个皇后
    //特别注意： check 是 每一次递归时，进入到check中都有  for(int i = 0; i < max; i++)，因此会有回溯

    private void check(int n) {
        if (n == max) { //n=8,其实8个皇后就依然放好了
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n,放到改行的第一列
            array[n] = i;
            //判断当前位置第n个皇后到i列时，是否冲突
            if (judge(n)) {//不冲突
                //接着放n+1个皇后，即开始递归
                check(n + 1);

            }

            //如果冲突，就继续执行 array[n] = i; 即将第n个皇后，放置在本行得 后移的一个位置

        }


    }


    //写一个方法，可以将皇后摆放的位置输出

    //查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突

    /**
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            // 判断同一列，同一斜线
            // 说明
            //1. array[i] == array[n]  表示判断 第n个皇后是否和前面的n-1个皇后在同一列
            //2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第n个皇后是否和第i皇后是否在同一斜线
            // n = 1  放置第 2列 1 n = 1 array[1] = 1
            // Math.abs(1-0) == 1  Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1
            //3. 判断是否在同一行, 没有必要，n 每次都在递增
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }


        }
        return true;

    }

    private void print() {

        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
