package giai_thuat;

import java.util.Set;
import java.util.TreeSet;

public class giai_thuat {
    public static void main(String[] args) {
        int[][] mang2d = {{6, 7, 8, 9,11,13}, {1, 2, 3, 4, 5}};
        for (Integer el : timSoNguyenTo(mang2d)
        ) {
            System.out.println(el);
        }
    }
    static int[] timSoNguyenTo(int[][] mang2D) {
        Set<Integer> resultList = new TreeSet<>();
        for (int[] ints : mang2D) {
            for (int anInt : ints) {
                if (kiemTraSoNguyenTo(anInt)) {
                    resultList.add(anInt);
                }
            }
        }
        int[] result = new int[resultList.size()];
        int i = 0;
        for (Integer num : resultList
        ) {
            result[i] = num;
            i++;
        }
        return result;
    }
    static boolean kiemTraSoNguyenTo(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        return count == 2;
    }
}
