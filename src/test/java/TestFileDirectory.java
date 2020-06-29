import fileinfo.FileDirectory;
import org.junit.Test;

import java.io.File;
import static org.junit.Assert.assertEquals;

public class TestFileDirectory {
    private static final String dirToDoFiles = "files\\test\\todoFiles\\";
    private static final String dirDoneFiles = "files\\test\\doneFiles\\";
    private static final String dirConfigFile = "files\\test\\configFiles\\";
    private static final String configFileName = "10configFile.txt";

    @Test
    public void testDir(){
        FileDirectory fileDirectory = new FileDirectory();
        int checkDirToDo = fileDirectory.getCheckDirToDo();
        int checkDirDone = fileDirectory.getCheckDirDone();
        int checkDirConfig = fileDirectory.getCheckDirConfig();
        System.out.println(checkDirDone);
        System.out.println(checkDirToDo);
        System.out.println(checkDirConfig);
        assertEquals(checkDirDone, 2);
        assertEquals(checkDirToDo, 2);
        assertEquals(checkDirConfig, 2);
    }

    @Test
    public void printFilesToDo(){
        FileDirectory dir = new FileDirectory();
        File dirTodo = dir.getDirToDo();
        dir.printListDirFiles(dirTodo);
    }

}
