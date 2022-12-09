package huisu;

import java.util.ArrayList;
import java.util.List;

public class Test5 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23"));
    }
}

class Solution {
    String[] letterMap = {
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz", // 9
    };
    List<String> res = new ArrayList<>(); // 存放最终结果
    StringBuilder path = new StringBuilder(); // 存放每次中间结果

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        traversal(digits);
        return res;
    }

    // 递归
    public void traversal(String digits) {
        // 终止条件
        if (path.length() == digits.length()) {
            res.add(path.toString());
            return;
        }

        int index = path.length();
        String str = letterMap[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            path.append(str.charAt(i));
            traversal(digits);
            path.deleteCharAt(path.length()-1);
        }

    }
}
