package FileHandling;

import java.io.*;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static String name, data;
    private static int id, mark;

    public static void main(String[] args) throws IOException {
        boolean runFlag = true;
        File studentData = new File("src\\FileHandling\\StudentData.txt");
        while (runFlag){
            showMenu();
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    getStudentData(studentData);
                    break;
                case 2:
                    readFile(studentData);
                    break;
                case 3:
                    System.out.println("Good Bye");
                    runFlag = false;
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
                }
            }
        }

    private static void showMenu(){
        System.out.println("Menu \n1 - Add Student in the List and save to File \n2 - Read Students List from a file and display on the screen \n3 - Exit \nEnter Your Choice:");
    }

    private static void getStudentData(File studentData) throws IOException{
        data = null;
        System.out.println("Enter Student Name");
        name = scanner.next();

        System.out.println("Enter Student Id");
        id = scanner.nextInt();

        System.out.println("Enter Student Mark");
        mark = scanner.nextInt();

        data = String.format("Name: %s %nId: %d %nMark: %d%n", name,id,mark);
        writeToFile(studentData);
    }

    private static void writeToFile(File studentData) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(studentData,true));
        bw.write(data);
        bw.newLine();
        bw.close();
    }
    private static void readFile(File studentData) throws IOException{
        BufferedReader br = new BufferedReader((new FileReader((studentData))));
        String line = br.readLine();
        while(line != null){
            System.out.println(line);
            line = br.readLine();
        }
        br.close();
    }
}

