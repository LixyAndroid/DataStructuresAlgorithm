package xuyang.datadtructuresalgorithm.search;

import java.util.Arrays;

/**
 * @author Li Xuyang
 * @date 2020/3/12 15:35
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }

        int index = insertValueSearch(arr, 0, arr.length - 1, 98);
        System.out.println("index = " + index);
    }
    //编写插值查找算法

    //说明：插值查找算法，也要求数组是有序的

    /**
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return 如果找到，返回对应的下标，如果没有找到，返回-1
     */
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        System.out.println("查找次数😊");
        //条件必须有findVal < arr[0] || findVal > arr[arr.length - 1]，否则可能越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }

        //求出mid，自适应
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right - arr[left]]);
        int midVal = arr[mid];
        if (findVal > midVal) {//向右
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { //向左
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else { //向左
            return mid;
        }
    }
}
