package File.ListingFiles;

import java.io.File;

public class ListFile {
    public static void main(String[] args) {
        File currentDirectory = new File(".");
        String[] contents = currentDirectory.list();

        for(int i = 0; i < contents.length; i++){
            System.out.println(contents[i]);
        }
    }
}
