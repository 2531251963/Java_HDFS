package aa;

import org.apache.hadoop.fs.*;

import java.util.Scanner;

/**
 * @ClassName HDFSOpt
 * @Description TODO
 * @Author Liyihe
 * @Date 2020/05/16 下午12:30
 * @Version 1.0
 */
public class HDFSOpt11 {
    static FileSystem fs = HadoopInstance.getFileSystem();


    public static void mv(String oldPath,String newPath) {
        try {
            fs.rename(new Path(oldPath),new Path(newPath));
            System.out.println(oldPath+ " 移动到 "+newPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String oldPath = "/test";
        String newPath = "/test1";
        try {
         HDFSOpt11.mv(oldPath,newPath);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
