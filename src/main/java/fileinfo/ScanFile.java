package fileinfo;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ScanFile {

public static ArrayList<String> readToList(File rFile){
        try {
            Scanner scn = new Scanner(rFile);
            ArrayList<String> wList = new ArrayList<String>();
            while (scn.hasNext()) {
                String word = scn.next();
                wList.add(word);
            }
            return wList;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Integer> readIntToList(File rFile){
        ArrayList<Integer> wList = new ArrayList<Integer>();
        try {
           Scanner scn = new Scanner(rFile);

            while (scn.hasNextInt()) {
                int value = scn.nextInt();
                wList.add(value);
            }
            return wList;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wList;
    }

    public static ArrayList<String> readToListByLine(File rFile){
        ArrayList<String> wList = new ArrayList<String>();
    try {
            Scanner scn = new Scanner(rFile);
            while (scn.hasNextLine()) {
                String line = scn.nextLine();
                wList.add(line);
            }
            return wList;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wList;
    }

    public static void writeStrToList(ArrayList<String> list, File writeFile){

        try {
            FileWriter writer = new FileWriter(writeFile, false);
            BufferedWriter bw = new BufferedWriter(writer);
            int count = 0;
            while (list.size() > count) {
                bw.write(list.get(count));
                bw.newLine();
                count++;
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeIntToList(ArrayList<Integer> list, File writeFile ){
        try {
            FileWriter writer = new FileWriter(writeFile, false);
            BufferedWriter bw = new BufferedWriter(writer);
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                int value = list.get(i);
                String printValue = Integer.toString(value);
                bw.write(printValue);
                bw.newLine();
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeValue(String value, File writeFile){

        try {
            FileWriter writer = new FileWriter(writeFile, false);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(value);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static void writeString(String str, File writeFile){

        try {
            FileWriter writer = new FileWriter(writeFile, false);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(str);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void writeListCSV(ArrayList<String> list, String writeFile){

        try {
            FileWriter writer = new FileWriter(writeFile, false);
            BufferedWriter bw = new BufferedWriter(writer);
            int count = 0;
            while (list.size() > count) {
                bw.write(list.get(count));
                bw.write(',');
                bw.newLine();
                count++;
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
