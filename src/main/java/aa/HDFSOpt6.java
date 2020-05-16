package aa;

import org.apache.hadoop.fs.*;

/**
 * @ClassName HDFSOpt
 * @Description TODO
 * @Author Liyihe
 * @Date 2020/05/16 下午12:30
 * @Version 1.0
 */
public class HDFSOpt6 {
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

    public static void touchz(String path) {
        try {
            FSDataOutputStream outputStream=fs.create(new Path(path));
            outputStream.close();
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
        String filepath = "/a1/a2/a1.txt";
        String dirpath = "/a1/a2";
        try {
           if (HDFSOpt6.exists(filepath)){
               HDFSOpt6.rm(filepath);
               System.out.println("删除文件 :" +filepath);
           }else {
               if (HDFSOpt6.exists(dirpath)){
                   HDFSOpt6.mkdir(dirpath);
                   System.out.println("创建文件夹: "+dirpath);
               }
               HDFSOpt6.touchz(filepath);
               System.out.println("创建文件: "+filepath);
           }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
