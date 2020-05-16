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
public class HDFSOpt10 {
    static FileSystem fs = HadoopInstance.getFileSystem();


    public static void rm(String path) {
        Scanner scanner=new Scanner(System.in);
        try {
            RemoteIterator<LocatedFileStatus> remoteIterator=fs.listFiles(new Path(path),false);
            while (remoteIterator.hasNext()){
                FileStatus fileStatus=remoteIterator.next();
                System.out.println(path+" 存在文件: "+fileStatus.getPath());
            }
            System.out.println("是否删除\n 1:是\n 2:否");
            String choose=scanner.next();
            if (choose.equals("1")){
                fs.deleteOnExit(new Path(path));
                System.out.println(path+ " 已删除");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String dirpath = "/a1";
        try {
         HDFSOpt10.rm(dirpath);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
