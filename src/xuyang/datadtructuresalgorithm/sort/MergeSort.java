package xuyang.datadtructuresalgorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Li Xuyang
 * @date 2020/3/8 15:46
 * 归并排序
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(N)
 */
public class MergeSort {

    public static void main(String[] args) {
        // int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};


        int[] arr = new int[80000];
        int temp[] = new int[arr.length];//归并排序需要一个额外的空间

        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000); //生成[0,80000)
        }

        Date date1 = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是 ： " + date1Str);

        mergeSort(arr, 0, arr.length - 1, temp);

        Date date2 = new Date();


        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是 ： " + date2Str);
    }


    //分+合的方法

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2; //中间索引

            //向左递归进行分解
            mergeSort(arr, left, mid, temp);

            //向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);

            //到合并
            merge(arr, left, mid, right, temp);
        }

    }


    //合并的方法

    /**
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // System.out.println("😊");
        int i = left;//初始化i,左边有序序列的初始索引
        int j = mid + 1;//初始化j,右边有序序列的初始索引
        int t = 0;//指向temp数组的当前索引

        //（一）
        //先把左右两边（有序）的数据按照规则填充到temp数组
        //直到左右两边到有序序列，有一边完毕为止

        while (i <= mid && j <= right) {//继续

            //如果左边有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素，填充到temp数组
            //然后t++，i++
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {//反之
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }

        }


        //（二）
        //把有剩余数据到一边到数据依次全部填充到temp

        while (i <= mid) {//左边到有序序列还有剩余元素，就全部填充到temp
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }


        while (j <= right) {//右边到有序序列还有剩余元素，就全部填充到temp
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        //(三)
        //将temp数组到元素拷贝到arr
        //注意，并不是每一次都是拷贝所有

        t = 0;
        int tempLeft = left;
        //第一次合并tempLeft=0,right =1
        //  System.out.println("tempLeft= "+ tempLeft+" right= "+ right);
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }

    }
}
