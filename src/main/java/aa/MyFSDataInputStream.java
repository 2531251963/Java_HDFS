package aa;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.*;

/**
 * @ClassName MyFSDataInputStream
 * @Description TODO
 * @Author Liyihe
 * @Date 2020/05/14 下午11:38
 * @Version 1.0
 */
public class MyFSDataInputStream extends FSDataInputStream {


    public MyFSDataInputStream(InputStream in) {
        super(in);
    }
    public static String readline(String filePath) {
        try {
            InputStream inputStream = HadoopInstance.getFileSystem().open(new Path(filePath));
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(inputStream));
            String line;
            if ((line = bufferedReader.readLine()) != null) {
                bufferedReader.close();
                inputStream.close();
                return line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(MyFSDataInputStream.readline("/test"));
    }
}
