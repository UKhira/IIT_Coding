package Excercise2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        arrayListInitializer();
    }

    public static void listDemo(@org.jetbrains.annotations.NotNull ArrayList<Integer> list){
        for(int i = 0; i < list.size(); i++){
            int element = list.get(i);
            list.remove(i);
            list.addFirst(element + 1);
        }
        System.out.println("After: " + list);
    }

    public static void arrayListInitializer(){
        ArrayList <Integer> arrayList = new ArrayList<Integer>();
        int[][] arrayListDummy = {{5,10,15}, {8,2,7,8}, {-1,3,28,17,9,30}};

        for(int[]row:arrayListDummy){
            for(int i = 0; i < row.length; i++){
                arrayList.add(i, row[i]);
            }
            System.out.println("Before: " + arrayList);
            listDemo(arrayList);
            arrayList.clear();
        }
    }
}
