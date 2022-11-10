package Work;

import org.junit.Test;

import java.util.*;

public class Tests {
    public static void main(String[] args) {


    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public boolean isValid(String s) {
            int n = s.length();
            if (n % 2 == 1) {
                return false;
            }

            Map<Character, Character> pairs = new HashMap<Character, Character>() {{
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }};
            Deque<Character> stack = new LinkedList<Character>();
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (pairs.containsKey(ch)) {
                    if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                        return false;
                    }
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
            return stack.isEmpty();
        }
    // dr,dc 配合使用得到 grid[r][c] 上grid[r-1][c]左grid[r][c-1]下grid[r+1][c]右grid[r][c+1]的元素
    public int orangesRotting(int[][] grid) {
        // 获取二维数组的行数row 和 列数 column
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, -1, 0, 1};
        int R = grid.length, C = grid[0].length;

        // queue : all starting cells with rotten oranges
        Queue<Integer> queue = new ArrayDeque();
        Map<Integer, Integer> depth = new HashMap();
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c)
                if (grid[r][c] == 2) {
                    int code = r * C + c;  // 转化为索引唯一的一维数组
                    queue.add(code); //存储腐烂橘子
                    depth.put(code, 0); //存储橘子变为腐烂时的时间,key为橘子的一维数组下标，value为变腐烂的时间
                }

        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int r = code / C, c = code % C;
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    // 计次的关键 元素 grid[r][c] 的上左下右元素得腐烂时间应该一致
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }

        //检查grid，此时的grid能被感染已经都腐烂了，此时还新鲜的橘子无法被感染
        for (int[] row: grid)
            for (int v: row)
                if (v == 1)
                    return -1;
        return ans;

    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap();
        int n=s.length();
        int max=0,left=0;
        for(int i=0;i<n;i++){
            if(map.containsKey(s.charAt(i))){
                left=Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max=Math.max(max,i-left+1);
        }
        return max;
    }

    public long totalCost(int[] costs, int k, int candidates) {
        Queue<Integer> left = new PriorityQueue<>();
        Queue<Integer> right = new PriorityQueue<>();
        int n=costs.length;
        long res=0;
        if(n>candidates*2){

            for(int i=0;i<candidates;i++){
                left.add(costs[i]);
            }
            for(int i=n-1;i>=n-candidates;i--){
                right.add(costs[i]);
            }
            int l=candidates;
            int r=n-candidates-1;
            for(int i=0;i<k;i++){
                int a=999999999;
                int b=999999999;
                if(left.peek()!=null)a=left.peek();
                if(right.peek()!=null)b=right.peek();
                //System.out.println(a+" "+b);
                if(a<=b){
                    res+=a;
                    left.poll();
                    if(l<=r){
                        left.add(costs[l]);
                        l++;
                    }
                }
                else{
                    res+=b;
                    right.poll();
                    if(l<=r){
                        right.add(costs[r]);
                        r--;
                    }
                }

            }
        }
        else{
            Arrays.sort(costs);
            for(int i=0;i<k;i++){
                res+=costs[i];
            }
        }
        return res;
    }

}
