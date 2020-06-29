package fileservice;
import fileinfo.FileDirectory;
import fileinfo.ScanFile;
import java.io.File;
import java.util.ArrayList;

public class FileService {
    private File dirToDoFiles;
    private File dirDoneFiles;
    private FileDirectory dir;
    private static ArrayList<String> arrlistStr;
    private static ArrayList<Integer> arrlistInt;
    private static int maxFileValue;
    private static int minFileValue;



    public FileService(FileDirectory dir){
        this.dir = dir;
        dirToDoFiles = dir.getDirToDo();
        dirDoneFiles = dir.getDirDone();
    }

    public void executeFiles(){
        try {
            ArrayList<String> listToDo = dir.getListFilesToDo();
            for (int i = 0; i < listToDo.size(); i++) {
                String line = listToDo.get(i);
                String[] elements = line.split(",");
                String fileID = elements[0].trim();
                String operationID = elements[1].trim();
                File file = dir.searchFileByID(dirToDoFiles, fileID);
                int opID = Integer.parseInt(operationID);
                execute(opID, file);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void execute(int command, File file){
        if(command==0){
            System.out.println("No operation ");
          opeartionZero(file);
        }
        if(command==1){
            //to do
        }
        else if(command==2){
            //to do
        }
        else if(command==11){
            removeDuplicateStr(file);
        }
        else if(command==12){
            removeDuplicateInt(file);
        }
        else if(command==14){
            //to do
        }
        else if(command ==15){
            searchMax(file);
        }
        else if(command ==16){
            searchMin(file);
        }
    }

    private void searchMax(File file){
        ScanFile scanFile = new ScanFile();
        arrlistInt = scanFile.readIntToList(file);
        maxFileValue = Search.getMax(arrlistInt);
        String maxFileValueStr = Integer.toString(maxFileValue);
        String printValue = "Max value: " + maxFileValueStr;
        System.out.println(maxFileValue);
        String outputFile = dirDoneFiles.getPath() + "\\done_" + file.getName();
        System.out.println(dirDoneFiles.getPath());
        File outfile = new File(outputFile);
        ScanFile.writeValue(printValue, outfile);

    }

    private void opeartionZero(File file){
        String outputFile = dirDoneFiles.getPath() + "\\noChange_" + file.getName();
        File outfile = new File(outputFile);
        ScanFile.writeString("No changes", outfile);
    }

    private void searchMin(File file){
        arrlistInt = ScanFile.readIntToList(file);
        minFileValue = Search.getMin(arrlistInt);
        String printValue = "Min value: " + Integer.toString(minFileValue);;
        String outputFile = dirDoneFiles.getPath() + "\\done_" + file.getName();
        File outfile = new File(outputFile);
        ScanFile.writeValue(printValue, outfile);
         }

    private void removeDuplicateStr(File file){
        arrlistStr = ScanFile.readToList(file);
        arrlistStr = SortArrayList.removeDuplicateStr(arrlistStr);
        String outputFile = dirDoneFiles.getPath() + "\\done_" + file.getName();
        File outfile = new File(outputFile);
        ScanFile.writeStrToList(arrlistStr, outfile);
    }

    private void removeDuplicateInt(File file){
        arrlistInt = ScanFile.readIntToList(file);
        arrlistInt = SortArrayList.removeDuplicateInt(arrlistInt);
        String outputFile = dirDoneFiles.getPath() + "\\done_" + file.getName();
        File outfile = new File(outputFile);
        ScanFile.writeIntToList(arrlistInt, outfile);
    }

}


