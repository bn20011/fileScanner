import fileinfo.FileDirectory;
import fileservice.FileService;

public class Main {
    public static void main(String args[]){
        FileDirectory dir = new FileDirectory();
        FileService fs = new FileService(dir);
        fs.executeFiles();
    }
}
