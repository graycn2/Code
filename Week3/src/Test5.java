import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Test5 {
    public void readFile() throws IOException {
        // 创建一个FileReader对象:
        Reader reader = new FileReader("src/readme.txt"); // 字符编码是???
        for (;;) {
            int n = reader.read(); // 反复调用read()方法，直到返回-1
            if (n == -1) {
                break;
            }
            System.out.println((char)n); // 打印char
        }
        reader.close(); // 关闭流
    }
}
