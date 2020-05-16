package aa;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * @ClassName HDFSOpt
 * @Description TODO
 * @Author Liyihe
 * @Date 2020/05/16 下午12:30
 * @Version 1.0
 */
public class HDFSOpt8 {
    static FileSystem fs = HadoopInstance.getFileSystem();

    public static boolean exists(String path) {
        try {
            return fs.exists(new Path(path));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void mkdir(String path) {
        try {
             fs.mkdirs(new Path(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void rm(String path) {
        try {
            fs.deleteOnExit(new Path(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String dirpath = "/a1/a2";
        try {
           if (HDFSOpt8.exists(dirpath)){
               HDFSOpt8.rm(dirpath);
               System.out.println("删除目录 :" +dirpath);
           }else {
                   HDFSOpt8.mkdir(dirpath);
                   System.out.println("创建目录: "+dirpath);
           }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
