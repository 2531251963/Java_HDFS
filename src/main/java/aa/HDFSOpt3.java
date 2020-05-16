package aa;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * @ClassName HDFSOpt
 * @Description TODO
 * @Author Liyihe
 * @Date 2020/05/16 下午12:30
 * @Version 1.0
 */
public class HDFSOpt3 {
    static FileSystem fs = HadoopInstance.getFileSystem();

    public static void cat(String path) {
        try {
            FSDataInputStream in=fs.open(new Path(path));
            BufferedReader d=new BufferedReader(new InputStreamReader(in));
            String line="";
            while ((line=d.readLine())!=null){
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "/test";
        try {
            HDFSOpt3.cat(path);
            System.out.println("读取完成");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
