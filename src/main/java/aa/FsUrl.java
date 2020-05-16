package aa;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.InputStream;
import java.net.URL;

/**
 * @ClassName FsUrl
 * @Description TODO
 * @Author Liyihe
 * @Date 2020/05/16 下午12:23
 * @Version 1.0
 */
public class FsUrl {
    static {
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
    }
    public static void cat (String remoteFilePath){
        try (InputStream in =HadoopInstance.getFileSystem().open(new Path(remoteFilePath))){
            IOUtils.copyBytes(in,System.out,4096,false);
            IOUtils.closeStream(in);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FsUrl.cat("/test");
    }
}
