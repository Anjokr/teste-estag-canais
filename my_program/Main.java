package my_program;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{

        File file = new File("C:\\Users\\Hyun Min Cho\\Documents\\codigos\\teste-estag-canais\\my_program\\entrada.txt");
        Scanner scan = new Scanner(file);
        
        Interface inface = new Interface(scan);
        inface.start();
    }
}