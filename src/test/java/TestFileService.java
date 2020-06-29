import fileinfo.FileDirectory;
import fileservice.FileService;
import org.junit.Test;

public class TestFileService {
    @Test
    public void testFileService(){
        FileDirectory dir = new FileDirectory();
        FileService fs = new FileService(dir);
        fs.executeFiles();
    }
}
