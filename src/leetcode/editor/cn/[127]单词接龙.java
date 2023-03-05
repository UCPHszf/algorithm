//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列
// beginWord -> s1 -> s2 -> ... -> sk： 
//
// 
// 每一对相邻的单词只差一个字母。 
// 
// 对于 1 <= i <= k 时，每个
// si 都在
// wordList 中。注意， beginWord 不需要在
// wordList 中。
// 
// sk == endWord 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 
//中的 单词数目 。如果不存在这样的转换序列，返回 0 。 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
//
// Related Topics 广度优先搜索 哈希表 字符串 👍 1130 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<String, Integer> minSteps = new HashMap<>();
    Map<String, List<String>> transferList = new HashMap<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        if (!wordList.contains(endWord)) return 0;
        minSteps.put(beginWord, 1);
        transferList.put(beginWord, new ArrayList<>());
        for (String w : wordList) {
            transferList.put(w, new ArrayList<>());
            if (canTransfer(beginWord, w)) {
                transferList.get(beginWord).add(w);
            }
        }
        for (int i = 0; i < n; i++) {
            String w1 = wordList.get(i);
            for (int j = i + 1; j < n; j++) {
                String w2 = wordList.get(j);
                if (canTransfer(w1, w2)) {
                    transferList.get(w1).add(w2);
                    transferList.get(w2).add(w1);
                }
            }
        }
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        while (!q.isEmpty()) {
            String s = q.poll();
            int curStep = minSteps.get(s);
            List<String> t_list = transferList.get(s);
            for (String t : t_list) {
                if (!minSteps.containsKey(t)) {
                    q.add(t);
                    minSteps.put(t, curStep + 1);
                }
                if (t.equals(endWord)) {
                    return curStep + 1;
                }
            }
        }
        return 0;
    }


    boolean canTransfer(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
                if (diff == 2) return false;
            }
        }
        return diff == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
