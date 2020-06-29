package fileservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

public class SortArrayList {

    public static ArrayList<String> sortAsc(ArrayList<String> arrList){
        Collections.sort(arrList);
        return arrList;
    }

    public static ArrayList<Integer> sortAscInteger(ArrayList<Integer> arrList){
        Collections.sort(arrList);
        return arrList;
    }

    public static ArrayList<String> sortDsc(ArrayList<String> arrList){
    Collections.sort(arrList, Collections.reverseOrder());
    return arrList;
    }

    public static ArrayList <String> removeDuplicateStr(ArrayList<String> arrList){
        LinkedHashSet <String> hashSet = new LinkedHashSet<String>(arrList);
        ArrayList <String> arrUnique = new ArrayList<String>(hashSet);
        return sortAsc(arrUnique);
    }

    public static ArrayList <Integer> removeDuplicateInt(ArrayList<Integer> arrList){
        LinkedHashSet <Integer> hashSet = new LinkedHashSet<Integer>(arrList);
        ArrayList <Integer> arrUnique = new ArrayList<Integer>(hashSet);
        return sortAscInteger(arrUnique);
    }

    public static void printStringArrayList(ArrayList<String> strList){
        for(int i=0; i<strList.size(); i++){
            System.out.println(strList.get(i));
        }
    }

    public static void printIntegerArrayList(ArrayList<Integer> strList){
        for(int i=0; i<strList.size(); i++){
            System.out.println(strList.get(i));
        }
    }
}
