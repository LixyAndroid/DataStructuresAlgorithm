package xuyang.datadtructuresalgorithm.sort;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Li Xuyang
 * @date 2020/2/24 15:42
 */
public class QuickSort {
    public static void main(String[] args) {

       // int[] arr = {-9, 78, 0, 23, -567, 70, -1, 53, 4234, -6};

       // quickSort1(arr, 0, arr.length - 1);
      //  System.out.println("arr=" + Arrays.toString(arr));

        int[] arr = new int[800000];

        for (int i = 0; i < 800000; i++) {
            arr[i] = (int) (Math.random() * 800000); //生成[0,80000)
        }

        Date date1 = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是 ： " + date1Str);

        quickSort1(arr,0,arr.length-1);

        Date date2 = new Date();


        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是 ： " + date2Str);
    }


    public static void quickSort(int[] arr, int left, int right) {

        int l = left;//左下标
        int r = right;//右下标

        //pivot 中轴值

        int pivot = arr[(left + right) / 2];
        //临时变量，交换时候使用
        int temp = 0;
        //while循环的目的的是让pivot值小的放到左边
        //while循环的目的的是让pivot值大的放到右边

        while (l < r) {

            //在pivot的左边一直找，找到大于等于pivot的值，才退出
            while (arr[l] < pivot) {
                l += 1;
            }

            //在pivot的右边一直找，找到小于等于pivot的值，才退出
            while (pivot < arr[r]) {
                r -= 1;
            }


            //如果l>=r 说明pivot的左右两的值，已经按照左边全部满足是
            //小于等于pivot值，右边全部是大于等于pivot值
            if (l >= r) {
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l]==pivot值相等 r-- ，前移

            if (arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r]==pivot值相等 l++ ，前移
            if (arr[r] == pivot) {
                l += 1;
            }

        }

        //如果l==r，必须l++,r--,否则出现栈溢出

        if (l == r) {
            l += 1;
            r -= 1;
        }

        //左递归
        if (left < r) {

            quickSort(arr, left, r);
        }


        //右递归
        if (right > l) {

            quickSort(arr, l, right);
        }


    }

    public static void quickSort1(int[] arr, int left, int right) {


        int l = left;//左下标
        int r = right;//右下标

        int pivot = arr[(left + right) / 2];//取中轴值

        int temp = 0;//交换的中间量；
        while (l < r) {

            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r -= 1;
            }


            //如果l>=r 说明pivot的左右两的值，已经按照左边全部满足是
            // 小于等于pivot值，右边全部是大于等于pivot值
            if (l >= r) {
                break;
            }

            //交换

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;


            //如果交换完，发现这个arr[l]==pivot值相等 r-- ，前移
            if (arr[l] == pivot) {
                r -= 1;
            }

            if (arr[r] == pivot) {

                l += 1;
            }


        }

        //如果l==r，必须l++,r--,否则出现栈溢出

        if (l == r) {
            l += 1;
            r -= 1;
        }

        //左递归

        if (left < r) {
            quickSort1(arr, left, r);
        }

        //右递归

        if (right > l) {
            quickSort1(arr, l, right);
        }


    }
}