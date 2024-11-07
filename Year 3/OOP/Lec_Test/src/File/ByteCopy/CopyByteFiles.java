package File.ByteCopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyByteFiles {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("src\\File\\ByteCopy\\Text.txt");
        File outputFile = new File("src\\File\\ByteCopy\\Text_Copy.txt");

        FileInputStream in = new FileInputStream(inputFile);
        FileOutputStream out = new FileOutputStream(outputFile);

        int c;
        while ((c = in.read())!= -1){
            out.write(c);
        }
        in.close();
        out.close();
    }
}
