package aa;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

/**
 * @ClassName HDFSOpt
 * @Description TODO
 * @Author Liyihe
 * @Date 2020/05/16 下午12:30
 * @Version 1.0
 */
public class HDFSOpt4 {
    static FileSystem fs = HadoopInstance.getFileSystem();
    static SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void ll(String path) {
        try {
            FileStatus [] fileStatuses=fs.listStatus(new Path(path));
            for (FileStatus status: fileStatuses){
                System.out.println("路径: "+ status.getPath().toString());
                System.out.println("权限: "+ status.getPermission().toString());
                System.out.println("大小: "+ status.getLen());
                System.out.println("时间: "+ dateFormat.format(status.getModificationTime()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "/test";
        try {
            System.out.println("读取文件: "+ path);
            HDFSOpt4.ll(path);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
