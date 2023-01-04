import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] parent = {4,5,2,3,2,3};
        int[] child = {1, 2, 3};
        System.out.println(solution(parent, child));
    }

    static int solution(int[] parent, int[] child) {
        List<Integer> parentList = new ArrayList<>();

        for (int j : parent) {
            parentList.add(j);
        }
        int count = 0;
        int count2 = 0;
        for (int m = 0; m < child.length; m++) {
            for (int n = 0; n < parentList.size(); n++) {
                if (child[m] == parentList.get(n)) {
                    for (int j = 0; j < child.length; j++) {
                        for (int i = 0; i < parentList.size(); i++) {
                            if (child[j] == parentList.get(i)) {
                                parentList.remove(i);
                                count++;
                                break;
                            }
                        }
                        if (count == child.length) {
                            count2++;
                            count = 0;
                        }
                    }
                }
            }
        }
        return count2;
    }
}