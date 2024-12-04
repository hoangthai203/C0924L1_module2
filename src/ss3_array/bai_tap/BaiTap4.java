package ss3_array.bai_tap;

public class BaiTap4 {
    public static void main(String[] args) {
        int[][] matrix = {
                {5, 92, 8},
                {9, 7, 6},
                {11, 12, 15},
        };
        int max = matrix[0][0];
        int maxRow = 0, maxCol = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        System.out.println("Phần tử lớn nhất trong ma trận là: " + max);
        System.out.println("Tọa độ của phần tử này: [" + maxRow + "][" + maxCol + "]");
    }
}

