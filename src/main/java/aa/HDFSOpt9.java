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
public class HDFSOpt9 {
    static FileSystem fs = HadoopInstance.getFileSystem();


    public static void rm(String path) {
        try {
            fs.deleteOnExit(new Path(path));
            System.out.println(path+ " 已删除");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String dirpath = "/a1/a2";
        try {
         HDFSOpt9.rm(dirpath);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
