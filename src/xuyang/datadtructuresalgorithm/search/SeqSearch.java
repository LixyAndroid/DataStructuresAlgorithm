package xuyang.datadtructuresalgorithm.search;

/**
 * @author Li Xuyang
 * @date 2020/3/9 16:13
 */
public class SeqSearch {
    public static void main(String[] args) {

        int[] arr = {1,9,11,-1,89,24};
        int index = seqSearch(arr,11);
        if (index == -1){
            System.out.println("没有找到");
        }else {
            System.out.println("找到了，下标为  "+index);
        }

    }

    /**
     * 这里我们实现线性查找是找到一个满足条件到值，就返回
     * @param arr
     * @param value
     * @return
     */
    public static int seqSearch(int[] arr,int value){

        //线性查找是逐一比对，发现有相同值，就返回下标
        for (int i = 0; i < arr.length; i++) {

            if (arr[i]==value){
                return i;
            }
        }
        return -1;

    }

}
