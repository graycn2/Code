import java.io.*;

public class Test3 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("calcCharNum.txt");
        File file2 = new File("out.txt");

        FileInputStream fis =new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        byte[] bytes = new byte[1024];
        int len = 0;
        while((len=bis.read(bytes))!=-1){
            bos.write(bytes);
        }

        fis.close();
        fos.close();
        bis.close();
        bos.close();
    }
}
