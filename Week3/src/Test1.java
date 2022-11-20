import java.io.File;

public class Test1 {
    public static void main(String[] args) {
        File f = new File("D:\\");
        File[] fs1 = f.listFiles();
        if(fs1!=null){
            for (File fe : fs1){
                System.out.println(fe);
                File[] fs2 = fe.listFiles();
                if(fs2!=null){
                    for (File fe2 : fs2){
                        System.out.println(fe2);
                    }
                }
            }
        }
    }
}
