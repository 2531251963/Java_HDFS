package aa;




import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

import java.net.URI;


/**
 * @author liyihe
 * @version 1.0
 * @className HadoopInstance
 * @description TODO
 * @date 2020/5/14 16:10
 **/
public class HadoopInstance {
    private static FileSystem fileSystem = null;

    public static FileSystem getFileSystem()  {
        if (fileSystem==null){
            System.setProperty("hadoop.home.dir", "/home/liyihe/hadoop2.6");
            Configuration configuration = new Configuration();
            configuration.set("dfs.client.use.datanode.hostname", "true");
            try {
                fileSystem = FileSystem.get(new URI("hdfs://liyihe:9000"), configuration, "root");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return fileSystem;
    }



}
