package xuyang.datadtructuresalgorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Li Xuyang
 * @date 2020/1/1 21:38
 */
public class BubbleSort {
    public static void main(String[] args) {
      //  int arr[]={3, 9, -1, 10, -2};
      //  int arr[]={1, 2, 3, 4, 5};


//        System.out.println("排序前：");
//        System.out.println(Arrays.toString(arr));



        //测试一下冒泡排序的速度O（n^2）,给80000个数据，测试

        //创建个80000个随机的数组

        int[] arr = new int[80000];

        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random()*80000); //生成[0,80000)
        }

        Date date1 = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是 ： " + date1Str);


//        System.out.println("排序前：");
//        System.out.println(Arrays.toString(arr));

        bubbleSort(arr);

        Date date2 = new Date();


        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是 ： " + date2Str);

        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));

//        //为了容易理解，我们把冒泡排序的演示过程，给大家展示
//
//        //第一趟，
//
//        int temp = 0 ;// 临时变量
//        for (int j = 0; j < arr.length-1; j++) {
//            //如果前面的数比后面的数大，则交换
//            if (arr[j]>arr[j+1]){
//                temp = arr[j];
//                arr[j]= arr[j+1];
//                arr[j+1] = temp;
//            }
//
//        }
//
//        System.out.println("第一趟排序后：");
//        System.out.println(Arrays.toString(arr));
//
//        //第二趟排序，就是将第二大的数排在倒数第二位
//
//        for (int j = 0; j < arr.length-1-1; j++) {
//            //如果前面的数比后面的数大，则交换
//            if (arr[j]>arr[j+1]){
//                temp = arr[j];
//                arr[j]= arr[j+1];
//                arr[j+1] = temp;
//            }
//
//        }
//
//        System.out.println("第二趟排序后：");
//        System.out.println(Arrays.toString(arr));
//
//        //第三趟排序，就是将第二大的数排在倒数第二位
//
//        for (int j = 0; j < arr.length-1-1-1; j++) {
//            //如果前面的数比后面的数大，则交换
//            if (arr[j]>arr[j+1]){
//                temp = arr[j];
//                arr[j]= arr[j+1];
//                arr[j+1] = temp;
//            }
//
//        }
//
//        System.out.println("第三趟排序后：");
//        System.out.println(Arrays.toString(arr));
//
//        //第四趟排序，就是将第二大的数排在倒数第二位
//
//        for (int j = 0; j < arr.length-1-1-1-1; j++) {
//            //如果前面的数比后面的数大，则交换
//            if (arr[j]>arr[j+1]){
//                temp = arr[j];
//                arr[j]= arr[j+1];
//                arr[j+1] = temp;
//            }
//
//        }
//
//        System.out.println("第四趟排序后：");
//        System.out.println(Arrays.toString(arr));


    }

    public static  void  bubbleSort(int[] arr){
        //冒泡排序
        int temp = 0;// 临时变量

        boolean flag = false;//标识变量，表示是否进行过交换
        for (int i = 0; i < arr.length-1; i++) {

            for (int j = 0; j < arr.length - 1-i; j++) {
                //如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {

                    flag  = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }

            //优化
            if (!flag){ //在一趟排序中，一次交换都没有发生
                break;
            }else {
                flag = false; //重置flag！！！,进行下次判断
            }
        }
    }


}
