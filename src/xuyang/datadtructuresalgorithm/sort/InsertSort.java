package xuyang.datadtructuresalgorithm.sort;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Li Xuyang
 * @date 2020/1/21 15:51
 */
public class InsertSort {

    public static void main(String[] args) {

        // int[] arr = {101, 34, 19, 1,-9,342};


        //创建个80000个随机的数组

        int[] arr = new int[80000];

        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000); //生成[0,80000)
        }

        Date date1 = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是 ： " + date1Str);

        insertSort(arr);

        Date date2 = new Date();


        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是 ： " + date2Str);

        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
    }

    //插入排序

    public static void insertSort(int[] arr) {

        //定义写到外面
        int insertVal = 0;
        int insertIndex = 0;
        //使用for循环把代码简化
        for (int i = 1; i < arr.length; i++) {
            //定义待插入的数
             insertVal = arr[i];
             insertIndex = i - 1;//即arr[1]的前面这个数的下标
            //1,insertIndex>=0保证再给insertVal找插入位置，不越界
            //2，insertVal < arr[insertIndex]待插入的数还没有找到插入位置
            //，3，需要将arr[insertIndex]后移
            //也可以从大到小
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {


                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //当退出while循环时，说明插入的位置找到，index+1
            //这里我们判断是否需要赋值
            if (insertIndex+1 != i){
                arr[insertIndex + 1] = insertVal;
            }
            //System.out.println("第" + i + "轮插入后：");
           // System.out.println(Arrays.toString(arr));
        }
//        //使用逐步推导的方式来讲解，便于理解
//        //第一轮{101, 34, 19, 1};=》{34,101, 19, 1};
//        //定义待插入的数
//        int insertVal = arr[1];
//        int insertIndex = 1 - 1;//即arr[1]的前面这个数的下标
//        //1,insertIndex>=0保证再给insertVal找插入位置，不越界
//        //2，insertVal < arr[insertIndex]待插入的数还没有找到插入位置
//        //，3，需要将arr[insertIndex]后移
//
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//
//
//            arr[insertIndex + 1] = arr[insertIndex];
//            insertIndex--;
//        }
//        //当退出while循环时，说明插入的位置找到，index+1
//        arr[insertIndex + 1] = insertVal;
//        System.out.println("第一轮插入后：");
//        System.out.println(Arrays.toString(arr));
//
//        //第二轮
//        insertVal = arr[2];
//        insertIndex = 2 - 1;//即arr[2]的前面这个数的下标
//
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//
//
//            arr[insertIndex + 1] = arr[insertIndex];
//            insertIndex--;
//        }
//        //当退出while循环时，说明插入的位置找到，index+1
//        arr[insertIndex + 1] = insertVal;
//        System.out.println("第二轮插入后：");
//        System.out.println(Arrays.toString(arr));
//
//        //第三轮
//        insertVal = arr[3];
//        insertIndex = 3 - 1;//即arr[2]的前面这个数的下标
//
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//
//
//            arr[insertIndex + 1] = arr[insertIndex];
//            insertIndex--;
//        }
//        //当退出while循环时，说明插入的位置找到，index+1
//        arr[insertIndex + 1] = insertVal;
//        System.out.println("第三轮插入后：");
//        System.out.println(Arrays.toString(arr));

    }
}
