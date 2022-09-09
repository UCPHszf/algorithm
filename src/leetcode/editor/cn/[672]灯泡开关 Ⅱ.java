package leetcode.editor.cn;//现有一个房间，墙上挂有 n 只已经打开的灯泡和 4 个按钮。在进行了 m 次未知操作后，你需要返回这 n 只灯泡可能有多少种不同的状态。
//
// 假设这 n 只灯泡被编号为 [1, 2, 3 ..., n]，这 4 个按钮的功能如下： 
//
// 
// 将所有灯泡的状态反转（即开变为关，关变为开） 
// 将编号为偶数的灯泡的状态反转 
// 将编号为奇数的灯泡的状态反转 
// 将编号为 3k+1 的灯泡的状态反转（k = 0, 1, 2, ...) 
// 
//
// 示例 1: 
//
// 输入: n = 1, m = 1.
//输出: 2
//说明: 状态为: [开], [关]
// 
//
// 示例 2: 
//
// 输入: n = 2, m = 1.
//输出: 3
//说明: 状态为: [开, 关], [关, 开], [关, 关]
// 
//
// 示例 3: 
//
// 输入: n = 3, m = 1.
//输出: 4
//说明: 状态为: [关, 开, 关], [开, 关, 开], [关, 关, 关], [关, 开, 开].
// 
//
// 注意： n 和 m 都属于 [0, 1000]. 
//
// Related Topics 位运算 深度优先搜索 广度优先搜索 数学 👍 101 👎 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class BulbSwitchII672 {

    int[][] state =
            {{1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0},
                    {1, 0, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1},
                    {0, 1, 1, 0, 1, 1}, {1, 0, 0, 1, 0, 0},
                    {0, 0, 1, 1, 1, 0}, {1, 1, 0, 0, 0, 1}};

    int work(int n, int[] ops) {
        Set<Integer> s = new HashSet<>();
        for (int op : ops) {
            int t = 0;
            for (int i = 0; i < n; i++) {
                t = t * 2 + state[op][i];
            }
            s.add(t);
        }
        return s.size();
    }

    public int flipLights(int n, int presses) {
        n = Math.min(n, 6);
        if (presses == 0) return work(n, new int[]{0});
        else if (presses == 1) return work(n, new int[]{1, 2, 3, 4});
        else if (presses == 2) return work(n, new int[]{1, 2, 3, 4, 5, 6, 7});
        else return work(n, new int[]{0, 1, 2, 3, 4, 5, 6, 7});
    }
}
//leetcode submit region end(Prohibit modification and deletion)
