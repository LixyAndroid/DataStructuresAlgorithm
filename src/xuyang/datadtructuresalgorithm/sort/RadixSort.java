package xuyang.datadtructuresalgorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Li Xuyang
 * @date 2020/3/9 11:02
 * 负数不支持
 */
public class RadixSort {
    public static void main(String[] args) {

//        int arr[] = {53, 3, 542, 748, 14, 214};
//        radixSort(arr);

        //基数排序会很消耗空间
        int[] arr = new int[800000];
        int temp[] = new int[arr.length];//归并排序需要一个额外的空间

        for (int i = 0; i < 800000; i++) {
            arr[i] = (int) (Math.random() * 800000); //生成[0,80000)
        }

        Date date1 = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是 ： " + date1Str);

        radixSort(arr);

        Date date2 = new Date();


        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是 ： " + date2Str);

       // System.out.println(Arrays.toString(arr));
    }

    //基数排序方法

    public static void radixSort(int[] arr) {


        //根据前面对推导过程，我们可以得到最终对基数排序代码

        //1，得到数组中最大对数对位数
        int max = arr[0];//假设第一个数是最大的
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        //得到最大数是几位数
        int maxLength = (max + "").length();


        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中，实际存放了多少个数据，我们定义一个一维数组，来记录各个桶的每次放入数据的个数
        //可以这样理解
        //比如：bucketElementCounts[0],记录的就是bucket[0]桶的放入数据的个数
        int[] bucketElementCounts = new int[10];

        //这里我们使用循环，
        for (int i = 0, n = 1; i < maxLength; i++,n*=10) {
            //针对每个元素对应的位进行排序处理，依次
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                //放入到对应到桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];

                bucketElementCounts[digitOfElement]++;
            }

            //按照这个桶到顺序（一维数组的下标依次取出数据，放入原来数组）
            int index = 0;
            //遍历每一个桶，并将桶中的数据，放入原数组

            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据，我们才放入原数组
                if (bucketElementCounts[k] != 0) {

                    //循环该桶，即第k个桶，即第k个一维数组，放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入arr

                        arr[index] = bucket[k][l];
                        index++;
                    }


                }
                //第i+1轮处理后，需要将每个bucketElementCounts[k] =0！！！
                bucketElementCounts[k] = 0;
            }
         //   System.out.println("第"+(i+1)+"轮，arr = " + Arrays.toString(arr));
        }


//        //第1轮（针对米格元素的个位数进行排序）
//        //定义一个二维数组，表示10个桶，每个桶都是一个一维数组
//        //说明
//        //1。二维数组包含10个一维数组
//        //2。为了防止放入数的时候，数据溢出，则每一个一维数组，大小定为arr.length
//        //3.很明确，基数排序是使用空间换时间的经典算法
//
//        int[][] bucket = new int[10][arr.length];
//
//        //为了记录每个桶中，实际存放了多少个数据，我们定义一个一维数组，来记录各个桶的每次放入数据的个数
//        //可以这样理解
//        //比如：bucketElementCounts[0],记录的就是bucket[0]桶的放入数据的个数
//        int[] bucketElementCounts = new int[10];
//
//        //第1轮（针对每个元素的个位进行排序处理）
//        for (int j = 0; j < arr.length; j++) {
//            //对10取余，即取出每个元素个位的值
//            int digitOfElement = arr[j] / 1 % 10;
//            //放入到对应到桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//
//            bucketElementCounts[digitOfElement]++;
//        }
//
//        //按照这个桶到顺序（一维数组的下标依次取出数据，放入原来数组）
//        int index = 0;
//        //遍历每一个桶，并将桶中的数据，放入原数组
//
//        for (int k = 0; k < bucketElementCounts.length; k++) {
//            //如果桶中有数据，我们才放入原数组
//            if (bucketElementCounts[k] != 0) {
//
//                //循环该桶，即第k个桶，即第k个一维数组，放入
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    //取出元素放入arr
//
//                    arr[index] = bucket[k][l];
//                    index++;
//                }
//
//
//            }
//            //第一轮处理后，需要将每个bucketElementCounts[k] =0！！！
//            bucketElementCounts[k] = 0;
//        }
//
//        System.out.println("第一轮，对个位对排序处理arr = " + Arrays.toString(arr));
//
//
//        //==========================
//
//
//        //第2轮（针对每个元素的十位进行排序处理）
//        for (int j = 0; j < arr.length; j++) {
//            //对10取余，即取出每个元素十位的值
//            int digitOfElement = arr[j] / 10 % 10;
//            //放入到对应到桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//
//            bucketElementCounts[digitOfElement]++;
//        }
//
//        //按照这个桶到顺序（一维数组的下标依次取出数据，放入原来数组）
//        index = 0;
//        //遍历每一个桶，并将桶中的数据，放入原数组
//
//        for (int k = 0; k < bucketElementCounts.length; k++) {
//            //如果桶中有数据，我们才放入原数组
//            if (bucketElementCounts[k] != 0) {
//
//                //循环该桶，即第k个桶，即第k个一维数组，放入
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    //取出元素放入arr
//
//                    arr[index] = bucket[k][l];
//                    index++;
//                }
//
//
//            }
//
//            //第二轮处理后，需要将每个bucketElementCounts[k] =0！！！
//            bucketElementCounts[k] = 0;
//
//        }
//
//        System.out.println("第二轮，对个位对排序处理arr = " + Arrays.toString(arr));
//
//        //==========================
//
//
//        //第3轮（针对每个元素的百位进行排序处理）
//        for (int j = 0; j < arr.length; j++) {
//            //对10取余，即取出每个元素百位的值
//            int digitOfElement = arr[j] / 100 % 10;
//            //放入到对应到桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//
//            bucketElementCounts[digitOfElement]++;
//        }
//
//        //按照这个桶到顺序（一维数组的下标依次取出数据，放入原来数组）
//        index = 0;
//        //遍历每一个桶，并将桶中的数据，放入原数组
//
//        for (int k = 0; k < bucketElementCounts.length; k++) {
//            //如果桶中有数据，我们才放入原数组
//            if (bucketElementCounts[k] != 0) {
//
//                //循环该桶，即第k个桶，即第k个一维数组，放入
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    //取出元素放入arr
//
//                    arr[index] = bucket[k][l];
//                    index++;
//                }
//
//
//            }
//
//            //第三轮处理后，需要将每个bucketElementCounts[k] =0！！！
//            bucketElementCounts[k] = 0;
//
//        }
//
//        System.out.println("第三轮，对个位对排序处理arr = " + Arrays.toString(arr));
//    }
    }

}
