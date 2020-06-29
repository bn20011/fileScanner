import fileinfo.ScanFile;
import org.junit.Test;

import java.io.File;

public class TestScanFile {

    @Test
    public void testFileWriter(){
        String path = "files\\doneFiles\\done_test.txt";
        File file = new File(path);
        int value = 100;
        String val = Integer.toString(value);
        ScanFile.writeString(val, file);
    }
}
