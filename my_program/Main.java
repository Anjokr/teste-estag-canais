package my_program;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        String dir = System.getProperty("user.dir"); //get current directory path
        File file = new File(dir + "/my_program/entrada.txt");
        Scanner scan = new Scanner(file);
        
        Interface inFace = new Interface(scan);
        inFace.start();
    }
}