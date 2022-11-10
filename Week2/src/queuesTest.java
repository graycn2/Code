import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class queuesTest {
    @Test
    public void test1(){
        Queue<String> q =new PriorityQueue<>();
        q.offer("apple");
        q.offer("banana");
        q.offer("pear");
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());

    }

    @Test
    public void teat2(){
        Queue<User> q = new PriorityQueue<>(new UserComparator());
        // 添加3个元素到队列:
        q.offer(new User("Bob", "A1"));
        q.offer(new User("Alice", "A2"));
        q.offer(new User("Boss", "V1"));
        System.out.println(q.poll()); // Boss/V1
        System.out.println(q.poll()); // Bob/A1
        System.out.println(q.poll()); // Alice/A2
        System.out.println(q.poll()); // null,因为队列为空
    }
    @Test
    public void test3(){
        increase(1);
    }
    static int increase(int x) {
        return increase(x) + 1;
    }

    @Test
    public void test4(){
        String hex = toHex(12500);
        if (hex.equalsIgnoreCase("30D4")) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }

    static String toHex(int n) {
        Deque s=new ArrayDeque();
        while(n>0){
           if(n%16==10) s.push("A");
           if(n%16==11) s.push("B");
           if(n%16==12) s.push("C");
           if(n%16==13) s.push("D");
           if(n%16==14) s.push("E");
           if(n%16==15) s.push("F");
           if(n%16<10&&n%16>=0) s.push(n%16+"");
            n/=16;
        }
        StringBuilder stringBuilder=new StringBuilder();
        while(!s.isEmpty()){
            stringBuilder.append(s.pop());
        }
        return stringBuilder.toString();
    }
}
