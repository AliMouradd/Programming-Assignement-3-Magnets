import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner reader = new Scanner(new File("input.txt"));
        int magnetCount = reader.nextInt();
        System.out.println(magnetCount);

        String lineOne = reader.next();
        String lineTwo = reader.next();

        System.out.println(lineOne.length() + "\n" + lineTwo);

        char [][] charArr = new char [lineOne.length()][2];

        // for(int i = charArr.length-1; i >= 0; i --){
        //     for(int j = charArr[i].length-1; j >= 0; j-- ){
        //         System.out.println("["+i+"]["+j+"] ["+(i) +"]["+(j-1)+"]");
        //     }
        // }
        System.out.println(Arrays.deepToString(charArr));
    }
}
