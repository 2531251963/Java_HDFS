package aa;

import org.apache.hadoop.fs.*;

import java.text.SimpleDateFormat;

/**
 * @ClassName HDFSOpt
 * @Description TODO
 * @Author Liyihe
 * @Date 2020/05/16 下午12:30
 * @Version 1.0
 */
public class HDFSOpt5 {
    static FileSystem fs = HadoopInstance.getFileSystem();
    static SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void ll(String path) {
        try {
            RemoteIterator<LocatedFileStatus> remoteIterator=fs.listFiles(new Path(path),false);
            while (remoteIterator.hasNext()){
                FileStatus status=remoteIterator.next();
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
        String path = "/a1/a2";
        try {
            System.out.println("读取文件: "+ path);
            HDFSOpt5.ll(path);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
