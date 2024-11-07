package File.Buffer;

import java.io.*;

public class ReadString {
    public static void main(String[] args) throws IOException {
        FileReader in = new FileReader("src\\File\\Buffer\\File1.txt");
        BufferedReader br = new BufferedReader(in);

        FileWriter out = new FileWriter("src\\File\\Buffer\\File2.txt", true);
        BufferedWriter bw = new BufferedWriter(out);

        String line = br.readLine();
        while(line != null){
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        }
        in.close();
        br.close();
        bw.close();
        out.close();
    }
}
