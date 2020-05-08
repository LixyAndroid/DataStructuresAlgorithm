package xuyang.datadtructuresalgorithm.tree;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Li Xuyang
 * @date 2020/5/8 15:20
 */
public class HeapSort {

    //O(nlogn),线性对数阶
    public static void main(String[] args) {


//        int[] arr = {4, 6, 8, 5, 9,1,23,87,11,-22,3};
//        heapSort(arr);

        int[] arr = new int[8000000];

        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 800000); //生成[0,80000)
        }

        Date date1 = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是 ： " + date1Str);

        heapSort(arr);

        Date date2 = new Date();


        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是 ： " + date2Str);
    }

    //编写一个堆排序的方法
    public static void heapSort(int[] arr) {

        int temp =0;
        //分步完成
//        adjustHeap(arr,1,arr.length);
//        System.out.println("第一次"+Arrays.toString(arr));
//        adjustHeap(arr,0,arr.length);
//        System.out.println("第二次"+Arrays.toString(arr));

        //完成最终
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int j = arr.length-1; j >0 ; j--) {

            //交换
            temp = arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            adjustHeap(arr,0,j);
        }

      //  System.out.println(Arrays.toString(arr));


    }

    //将一个数组（二叉树），调整成一个大顶堆
    public static void adjustHeap(int[] arr, int i, int length) {

        //先取出当前元素的值，保存在临时变量
        int temp = arr[i];
        //开始调整

        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++; //k指向右子结点
            }

            if (arr[k] > temp) {
                arr[i] = arr[k];//把较大的值赋给当前的结点
                i = k; //i指向k,继续循环比较
            } else {
                break;
            }
        }

        //当for 结束后，我们已经将以i为父结点最大值，放在了最顶（局部）
        arr[i] = temp;//将temp放到调整后的位置

    }

}
