package Collections;
import java.util.ArrayList;

public class ArrayLists {
    public static void main(String[] args) {
        ArrayList <String> arrayList = new ArrayList<String>();

        arrayList.addFirst("0th Index");
        arrayList.add(1, "1st Index");
        arrayList.set(1,"Override");
        arrayList.addLast("Last Index");
        System.out.println(arrayList.contains("Last Index"));
        System.out.println(arrayList.size());

        ArrayList<String> arrayList2 = new ArrayList<String>(arrayList);
        arrayList2.add(1,"Unique Element");
        System.out.println(arrayList2);
        arrayList2.removeAll(arrayList);
        System.out.println(arrayList2);
    }
}
