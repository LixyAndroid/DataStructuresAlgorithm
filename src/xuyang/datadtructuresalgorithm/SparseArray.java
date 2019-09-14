package xuyang.datadtructuresalgorithm;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Li Xuyang
 * date  2019/9/14 12:49
 * 稀疏数组的创建与还原
 */
public class SparseArray {

    public static void main(String[] args) {
        //创建一个原始的二维数组 11*11
        // 0表示没有棋子，1表示黑子，2表示蓝子
        int chessArray1[][] = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;
        chessArray1[4][5] = 2;
        //输出原始二维数组
        System.out.println("原始的二维数组");
        for (int[] row : chessArray1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将二维数组转稀疏数组的思想
        //1，先遍历二维数组，得到非0数据的个数

        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray1[i][j] != 0) {
                    sum++;
                }

            }

        }
        System.out.println("sum=" + sum);


        //2,创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //给稀疏数组赋值

        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //遍历二维数组，将非0的值存放到sparseArr中
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArray1[i][j];
                }
            }

        }

        //输出稀疏数组
        System.out.println("得到的稀疏数组为");

        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }


        System.out.println();

        //将稀疏数组 --》 恢复成 原始的二维数组
		/*
		 *  1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的  chessArr2 = int [11][11]
			2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
		 */

        //1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int chessArray2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        //2. 在读取稀疏数组后几行的数据(从第二行开始)，并赋给 原始的二维数组 即可
        for (int i = 1; i < sparseArr.length; i++) {

            chessArray2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }


        // 输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");

        for (int[] row : chessArray2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        FileWriter writer = null;


        try {
            writer = new FileWriter("save.data");
            for (int i = 0; i < sparseArr.length; i++) {
                for (int j = 0; j < 3; j++) {
                    writer.write(sparseArr[i][j]);
                }
//				writer.write("\n");
//				写入的时候不需要换行！！我在这里摔倒了就不希望有人再在同一个地方摔倒。
//				如果你发现写入和读取的数字不对，第一件事情请看看你有没有把换行符之类的也写入了
//				导致reader把你的换行符也读取了。
            }

            writer.flush();
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        //   利用IO流将save1文件读取成稀疏数组
        FileReader reader = null;
        int[][] sparseArr2 = new int[sum + 1][3];
        int getNum = 0;
        try {
            reader = new FileReader("save.data");

            for (int i = 0; i < sparseArr2.length; i++) {
                for (int j = 0; j < 3; j++) {
                    getNum = reader.read();
                    sparseArr2[i][j] = getNum;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        //输出一下的稀疏数组
        System.out.println();
        System.out.println("读取后稀疏数组为");
        for (int i = 0; i < sparseArr2.length; i++) {
            //格式化输出
            System.out.printf("%d\t%d\t%d\n", sparseArr2[i][0], sparseArr2[i][1], sparseArr2[i][2]);
        }
        System.out.println();

        //首先把二维数组构建出来，利用稀疏数组的第一行
        int[][] chessArr3 = new int[sparseArr2[0][0]][sparseArr2[0][1]];

        //将稀疏数组恢复成原始的二维数组
        for (int i = 1; i < sparseArr2.length; i++) {
            //从稀疏数组的第二行开始
            chessArr3[sparseArr2[i][0]][sparseArr2[i][1]] = sparseArr2[i][2];
        }


        //遍历输出恢复后的二维数组
        System.out.println("从文件中读出的恢复的数组为：");
        for (int[] row : chessArr3) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }


    }
}
