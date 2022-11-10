package List;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 构造从start到end的序列：
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        System.out.println(list);
        // 随机删除List中的一个元素:
        int removed = list.remove((int) (Math.random() * list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");
    }

    static int findMissingNumber(int start, int end, List<Integer> list) {
        int[] s =new int[list.size()];

        for(int i=0;i< list.size();i++){
            s[i]= list.get(i);
        }
        for(int i=0;i<s.length-1;i++){
            if(s[i+1]-s[i]>1){
                return s[i]+1;
            }
        }
        return 0;
    }
}

