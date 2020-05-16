package aa;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @ClassName HDFSOpt
 * @Description TODO
 * @Author Liyihe
 * @Date 2020/05/16 下午12:30
 * @Version 1.0
 */
public class HDFSOpt2 {
    static FileSystem fs = HadoopInstance.getFileSystem();

    public static void copyToFileLocal(String localPath,String remotePath) {
        try {
            File file=new File(localPath);
            if (file.exists()){
                System.out.println(localPath+" 已存在");
                int i=0;
                while (true){
                    file=new File(localPath+"_"+i);
                    if (!file.exists()){
                        break;
                    }else {
                        i++;
                    }
                }
            }
            System.out.println("重命名为: "+file.getName());
            fs.copyToLocalFile(new Path(remotePath),new Path(file.getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        String localPath = "hadoop.txt";
        String remotePath = "/test";
        try {
            HDFSOpt2.copyToFileLocal(localPath,remotePath);
            System.out.println("下载完成");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
