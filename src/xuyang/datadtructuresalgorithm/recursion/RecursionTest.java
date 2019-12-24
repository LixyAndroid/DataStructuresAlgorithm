package xuyang.datadtructuresalgorithm.recursion;

/**
 * @author Li Xuyang
 * @date 2019/12/24 20:23
 */
public class RecursionTest {

    public static void main(String[] args) {

        //通过打印问题，回顾递归调用机制
        test(5);

        System.out.println(factorial(5));

    }

    public  static  void  test(int n){
        if (n>2){
            test(n-1);
        }
        System.out.println("n=" + n);
    }

    //阶乘
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }}

}
