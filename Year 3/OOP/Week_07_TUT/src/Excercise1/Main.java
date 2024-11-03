package Excercise1;

import org.jetbrains.annotations.NotNull;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        arrayInitializer();
    }

    public static void loadArray(int @NotNull [] list){
        for(int i = 1; i < list.length; i++){
            list[i] = list[i] + list[i-1];
        }
    }

    public static void arrayInitializer(){
        int[][] array = {{7}, {3,6}, {4,6,8}, {1,2,3,4}, {8,4,2,0,4}};
        for (int[]row: array){
//            System.out.println(Arrays.toString(row));
            loadArray(row);
            System.out.println(Arrays.toString(row));
        }
    }
}
