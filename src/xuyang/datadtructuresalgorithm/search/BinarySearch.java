package xuyang.datadtructuresalgorithm.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li Xuyang
 * @date 2020/3/9 16:39
 * 注意：使用二分查找的前提是，该数组是有序的
 */
public class BinarySearch {
    public static void main(String[] args) {
        //要有序，才可以
        int[] arr = {1, 9,11, 34, 89, 89,89, 89, 90, 90, 89124};
        int resIndex = binarySearch(arr, 0, arr.length - 1, 14343);
        System.out.println("resIndex = " + resIndex);

        List<Integer> resIndexList = binarySearch2(arr, 0, arr.length-1, 89);
        System.out.println("resIndexList= " + resIndexList);

    }

    //二分查找算法

    /**
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {

        //当left > right 时说明递归整个数组，但是没有找到
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) {
            //向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            //向右递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }

    }


    //当有重复的时候，找出全部
    /*
    思路分析：
    1，找到mid值，不要马上返回
    2，向mid索引值的左边扫描，将所有满足1000的元素的下标，加入到集合ArrayList
    3, 向mid索引值的右边扫描，将所有满足1000的元素的下标，加入到集合ArrayList
    4，将ArrayList返回
     */
    public static List binarySearch2(int[] arr, int left, int right, int findVal) {

        //当left > right 时说明递归整个数组，但是没有找到
        if (left > right) {
            return new ArrayList<Integer>();
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) {
            //向右递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            //向右递归
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            //1，找到mid值，不要马上返回
            //  2，向mid索引值的左边扫描，将所有满足1000的元素的下标，加入到集合ArrayList
            //  3, 向mid索引值的右边扫描，将所有满足1000的元素的下标，加入到集合ArrayList
            //    4，将ArrayList返回
            List<Integer> resIndexList = new ArrayList<>();

            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                //否则，就temp放入resIndexList
                resIndexList.add(temp);
                temp -= 1;//temp左移
            }
            resIndexList.add(mid);
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                //否则，就temp放入resIndexList
                resIndexList.add(temp);
                temp += 1;//temp右移
            }
            return resIndexList;
        }

    }

}
