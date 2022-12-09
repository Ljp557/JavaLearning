package huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test4 {
    static List<List<Integer>> res = new ArrayList<>(); // 存放结果
    static LinkedList<Integer> path = new LinkedList<>(); // 存放每次满足条件的组合

    public static void main(String[] args) {
        new Test4().traversal(3, 9, 1, 0);
        System.out.println(res);
    }

    private void traversal(int k, int n, int startIndex, int sum) {
        if (path.size() == k && sum == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            traversal(k, n, i + 1, sum + i);
            path.removeLast();
        }
    }

}
