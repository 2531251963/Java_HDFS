package aa;

import com.jcraft.jsch.IO;
import org.apache.commons.io.IOUtils;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

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
public class HDFSOpt1 {
    static FileSystem fs = HadoopInstance.getFileSystem();

    /**
     * 判断文件是否存在
     */
    public static boolean exists(String path) {
        try {
            return fs.exists(new Path(path));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 文件覆盖
     */
    public static void copyFromLocalFile(String localPath, String remotePath) {
        try {
            fs.copyFromLocalFile(false, true, new Path(localPath), new Path(remotePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件追加
     */
    public static void appendToFile(String localPath, String remotePath) {
        try {
            FileInputStream in = new FileInputStream(localPath);
            FSDataOutputStream out = fs.append(new Path(remotePath));
            byte[] data = new byte[1024];
            int read = -1;
            while ((read = in.read(data)) > 0) {
                out.write(data, 0, read);
            }
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String localPath = "hadoop";
        String remotePath = "/test";
        Scanner sc = new Scanner(System.in);
        String choose = "";
        try {
            boolean fileExists = false;
            if (HDFSOpt1.exists(remotePath)) {
                fileExists = true;
                System.out.println(remotePath + " 已存在");
                System.out.println("选择操作\n 1:覆盖文件内容\n 2:追加文件末尾");
                choose = sc.next();
            } else {
                System.out.println(remotePath + " 不存在");
            }
            System.out.println();
            if (!fileExists) {
                HDFSOpt1.copyFromLocalFile(localPath, remotePath);
                System.out.println(localPath + " 已上传至 " + remotePath);
            } else if (choose.equals("1")) {
                HDFSOpt1.copyFromLocalFile(localPath, remotePath);
                System.out.println(localPath + " 已覆盖 " + remotePath);
            } else {
                HDFSOpt1.appendToFile(localPath, remotePath);
                System.out.println(localPath + " 已追加 " + remotePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
