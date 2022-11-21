import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Work3 {
    @Test
    public void test1(){
        File file=new File("D:","HelloWorld.txt");

        //创建文件，返回一个布尔值
        boolean isCreate;
        try {
            isCreate = file.createNewFile();
            if (isCreate) {
                System.out.println("创建文件成功！");
            }else {
                System.out.println("创建文件失败！文件已经存在");
            }
        } catch (IOException e) {
            System.out.println("创建文件失败！");
        }

        // 判断他是文件还是目录，
        if (file.isFile()) {
            System.out.println("这是一个文件");
        } else {
            System.out.println("这是一个目录");
        }

        //再创建一个目录IOTest
        File file2=new File("D:/IOTest");
        file2.mkdirs();

        //HelloWorld.txt移动到IOTest目录下去?失败？》
        if (file.renameTo(new File(file2.getPath() + "/" + file.getName()))) {
            System.out.println("文件移动成功！");
        } else {
            System.out.println("文件移动失败");
        }

        //遍历IOTest目录下的文件
        String[] arr=file2.list();
        for (String string : arr) {
            System.out.println(string);
        }
    }

    @Test
    public void test2(){
        List list=FileUtils.getAllFiles("D:");
        //输出所有的文件和文件夹的名字
        for (Object file : list) {
            System.out.println(file);
        }
    }

    @Test
    public void test3(){
        File file = new File("calcCharNum.txt");
        try {
            // 创建读取流即输入流
            FileInputStream fis = new FileInputStream(file);
            int len = 0;
            byte[] buf = new byte[1024];
            StringBuffer sb = new StringBuffer();
            // 把读取的数据添加到StringBuffer里面
            while ((len = fis.read(buf)) != -1) {
                sb.append(new String(buf, 0, len));
            }
            // 把StringBuffer里面的内容打印出来
            System.out.println(sb);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4(){
        File file = new File("Hello.txt");
        try {
            // 创建输出流
            FileOutputStream fos = new FileOutputStream(file);
            //把String类型的字符串转化为byte数组的数据保存在输出流中
            fos.write("HelloJavaWorld你好世界".getBytes());
            fos.flush();//刷新输出流
            fos.close();//关闭输出流
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
