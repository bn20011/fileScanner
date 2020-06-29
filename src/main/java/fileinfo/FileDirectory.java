package fileinfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Set;

public class FileDirectory {
    private static final String dirToDoFiles = "files\\todoFiles\\";
    private static final String dirDoneFiles = "files\\doneFiles\\";
    private static final String dirConfigFile = "files\\configFiles\\";
    private static final String configFileName = "10configFile.txt";
    private File dirToDo;
    private File dirDone;
    private File dirConfig;
    private File fileConfig;
    private int checkDirToDo;
    private int checkDirDone;
    private int checkDirConfig;
    private ArrayList<String> listFilesToDo;


    public FileDirectory(){
        setDir();
    }

    public int getCheckDirToDo(){
        return checkDirToDo;
    }

    public int getCheckDirDone(){
        return checkDirDone;
    }

    public int getCheckDirConfig(){
        return checkDirConfig;
    }

    private void setDir(){
        setDirConfig();
        setDirToDo();
        setDirDone();
        setCheckDirResult();
        setConfigFile();
        setListFilesToDo();
    }

    private void setDirToDo(){
             File dirToDo = new File(dirToDoFiles);
             this.dirToDo = dirToDo;
    }

    private void setDirDone(){
        File dirDone = new File(dirDoneFiles);
        this.dirDone = dirDone;
    }

    private void setDirConfig(){
        File dirConfig = new File(dirConfigFile);
        this.dirConfig = dirConfig;
    }

    public File getDirToDo(){
        return this.dirToDo;
    }

    public File getDirDone(){
        return this.dirDone;
    }

    private void setConfigFile(){
        String pathFileConfig = dirConfigFile + configFileName;
        fileConfig = new File(pathFileConfig);
    }

    private void setListFilesToDo(){
        listFilesToDo = ScanFile.readToListByLine(fileConfig);
    }

    public ArrayList<String> getListFilesToDo(){
        return listFilesToDo;
    }


    public void  printListDirFiles(File dir){
        File[] files = dir.listFiles();
        for (int i = 0; i <files.length ; i++) {
            System.out.println(files[i]);
        }
    }

    public String searchFileName(Set<String> fileList, String fileName){
        String fileListName="";
        for(int i=0; i< fileList.size();i++){
            String searchFile = fileList.toString();
            if(searchFile.equals(fileName)){
                fileListName=searchFile;
                break;}
                else {
                fileListName ="noSuchFile.txt";
            }
        }

        return fileListName;
    }

    public File searchFileByID(File dir, String id){
        File[] files = dir.listFiles();
        File searchFile = null;

        for(int i=0; i< files.length;i++){
            String searchFileName = files[i].getName();
            String fileID = searchFileName.substring(0,3);
            if(id.equals(fileID)){
                searchFile = files[i];
                break;}
            else {
                System.out.println("not found");
            }
        }

        return searchFile;
    }

    //check directory status

    private int getCheckResult(File file){
        int dirExists = checkFileExists(file);
        int isDir = checkIsDirectory(file);
        int result = dirExists + isDir; // result =2 means check passed else failed
        return result;
    }

    private void passedNotification(){
        System.out.println("Check dir passed");

    }

    private void failedNotification(){
        System.out.println("Check dir failed");
    }

    private void setCheckDirResult(){
        if(getCheckResult(dirToDo)==2){
            passedNotification();
            checkDirDone = 2;
        }
        if(getCheckResult(dirDone)==2){
            passedNotification();
            checkDirToDo=2;
        }
        if(getCheckResult(dirConfig)==2){
            passedNotification();
            checkDirConfig=2;
        }
        else{
            failedNotification();
            checkDirDone=0;
            checkDirToDo =0;
            checkDirConfig=0;
        }
    }

    //check that directory exists
    private int checkFileExists(File file){
        int status =0; // if dir exists status is 0
        if(! file.exists()){
            System.out.println("Dir does not exists");
            status = 0;
        }
        else{status =1;}
        return status;
    }

    private int checkIsDirectory(File file){
        int status = 0;
        if(! file.isDirectory()){
            System.out.println("File is not directory");
            status = 0;
        }
        else{status =1;}
        return status;
    }
}
