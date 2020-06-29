package fileservice;

import java.util.ArrayList;

public class Search {

    //the method returns the index of search element if it is present in array else -1
    public static int searchBinary(ArrayList<Integer>arrayList, int x){
        int min=0, max = arrayList.size()-1;
        while (min<=max){
            int average = min+(max-1)/2;
            //check if x exists at average
            if(arrayList.get(average)==x){
                return x;
            }
            //if x greater, ignore left average
            if(arrayList.get(average)< x){
                min = average +1;
            }
            //if x is smaller, ignore right average
            else{
                max = average -1;
            }
        }return -1; // element is not present in the arrayList
    }

    public static int getMax(ArrayList<Integer> arrayList){
        int max = arrayList.get(0);
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i) > max){
                max=arrayList.get(i);
            }
        }return max;
    }


    public static int getMin(ArrayList<Integer> arrayList){
        int min = arrayList.get(0);
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i) < min){
                min=arrayList.get(i);
            }
        }return min;
    }
}
