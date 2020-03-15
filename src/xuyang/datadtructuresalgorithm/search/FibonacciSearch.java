package xuyang.datadtructuresalgorithm.search;

import java.util.Arrays;

/**
 * @author Li Xuyang
 * @date 2020/3/15 16:37
 */
public class FibonacciSearch {

    public static int maxSize = 20;
    public static void main(String[] args) {
        int[] arr={1,8,10,89,100,1234};
        System.out.println(fibSearch(arr,8));

    }

    //因为后面我们的mid = low+F(k-1)-1,需要使用到斐波那契数列，因此我们先获取到一个斐波那契数列
    //非递归的方法得到一个 斐波那契数列
    public static int[] fib(){

        int[] f = new int[maxSize];
        f[0]=1;
        f[1]=1;
        for (int i = 2; i < maxSize; i++) {
            f[i]=f[i-1]+f[i-2];
        }
        return f;
    }

    //编写斐波那契查找算法

    //非递归
    /**
     *
     * @param a
     * @param key
     * @return
     */
    public static int fibSearch(int[] a,int key){
        int low =0;
        int high = a.length-1;
        //表示斐波那契分割值的下标
        int k =0;
        //存放mid值
        int mid = 0;
        //获取到斐波那契数列
        int f[] = fib();
        //获取到斐波那契分割值到下标
        while (high>f[k]-1){
            k++;
        }
        //因为f[k]值可能大于a的长度，因此我们需要使用Arrays类，构造一个新的数组，并指向temp[]
        //不足的部分会使用0填充
        int[] temp = Arrays.copyOf(a,f[k] );
        //实际上需求使用a数组最后的数填充temp
        for (int i = high+1; i <temp.length ; i++) {
            temp[i] = a[high];
        }

        //使用while来循环处理,找到我们的数key
        while (low<=high){
            mid = low+f[k-1]-1;

            if (key<temp[mid]){
                high = mid-1;
                k--;
            }else if (key>temp[mid]){
                low = mid+1;
                k-=2 ;
            }else {
                //找到
                //需要确定，返回的是哪个下标
                if (mid<=high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;

    }
}
