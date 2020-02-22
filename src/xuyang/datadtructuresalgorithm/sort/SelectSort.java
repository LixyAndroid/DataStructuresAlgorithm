package xuyang.datadtructuresalgorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Li Xuyang
 * @date 2020/1/2 17:09
 */
public class SelectSort {
    public static void main(String[] args) {

        // int[] arr = {101,34,119,1};


        //创建个80000个随机的数组

        int[] arr = new int[80000];

        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); //生成[0,8000000)
        }

        Date date1 = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));


        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是 ： " + date1Str);

        selectSort(arr);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是 ： " + date2Str);

        System.out.println("排序后~~");
        System.out.println(Arrays.toString(arr));


    }

    //选择排序

    public static void selectSort(int[] arr) {


        //在推到的过程中，我们发现了规律，因此，可以使用for来解决
//选择排序的时间复杂度依旧是0(n^2)
        for (int i = 0; i < arr.length - 1; i++) {


            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {

                if (min > arr[j]) { //说明假定的最小值，并不是最小
                    min = arr[j]; //重置min
                    minIndex = j; //重置minIndex
                }
            }
            //将最小值，放在arr[0],即交换,赋值
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }


//            System.out.println("第"+(i+1)+"轮后~~");
//            System.out.println(Arrays.toString(arr));

        }

        //使用逐步推导的方式来，讲解选择排序
        //第一轮
        //原始数组：101，34，119，1
        //第一轮排序：1，34，119，101
        //排序 先简单 --》做复杂，就是可以把复杂的算法，拆分成简单的问题，-》逐步解决

//        //第1轮
//        int minIndex = 0;
//        int min = arr[0];
//        for (int j = 0+1; j < arr.length; j++) {
//
//            if (min>arr[j]){ //说明假定的最小值，并不是最小
//                min = arr[j]; //重置min
//                minIndex = j; //重置minIndex
//            }
//        }
//        //将最小值，放在arr[0],即交换,赋值
//        if (minIndex !=0 ){
//            arr[minIndex] = arr[0];
//            arr[0] = min;
//        }
//
//
//        System.out.println("第一轮后~~");
//        System.out.println(Arrays.toString(arr));
//
//
//        //第2轮
//        minIndex = 1;
//        min = arr[1];
//        for (int j = 1+1; j < arr.length; j++) {
//
//            if (min>arr[j]){ //说明假定的最小值，并不是最小
//                min = arr[j]; //重置min
//                minIndex = j; //重置minIndex
//            }
//        }
//        //将最小值，放在arr[1],即交换,赋值
//
//        if (minIndex !=1 ){
//            arr[minIndex] = arr[1];
//            arr[1] = min;
//        }
//
//
//        System.out.println("第二轮后~~");
//        System.out.println(Arrays.toString(arr));//1，34，119，101
//
//        //第3轮
//        minIndex = 2;
//        min = arr[2];
//        for (int j = 2+1; j < arr.length; j++) {
//
//            if (min>arr[j]){ //说明假定的最小值，并不是最小
//                min = arr[j]; //重置min
//                minIndex = j; //重置minIndex
//            }
//        }
//        //将最小值，放在arr[1],即交换,赋值
//
//        if (minIndex !=2 ){
//            arr[minIndex] = arr[2];
//            arr[2] = min;
//        }
//
//
//        System.out.println("第三轮后~~");
//        System.out.println(Arrays.toString(arr));//1，34，101，119
//


    }
}
