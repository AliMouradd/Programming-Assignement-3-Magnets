import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner reader = new Scanner(new File("input.txt"));
        int magnetCount = reader.nextInt();
        System.out.println(magnetCount);

        String lineOne = reader.next();
        lineOne += reader.next();

        System.out.println(lineOne.length() + "\n" + lineOne);

        char [][] charArr = new char [lineOne.length()/2][2];

        for(int i = 0; i<charArr.length; i ++){
            for(int j = 0; j<charArr[i].length-1; j+=2){
                charArr[i][j] = lineOne.charAt(i);
                charArr[i][j+1] = lineOne.charAt(i+(lineOne.length()/2));
                System.out.println("Values at arr["+i+"]["+j+"] ["+i+"]["+(j+1)+"] is "+charArr[i][j] + " " + charArr[i][j+1]);
            }
        }

        System.out.println(Arrays.deepToString(charArr));

        String location = "";
        while(magnetCount != 0){
            for(int i = 0; i < charArr.length; i++){
                for(int j = 0; j < charArr[i].length-1; j+=2){
                    // Checks space for [+ ,*] then fills * with -
                    if(charArr[i][j] == '+' && charArr[i][j+1] == '*'){
                        charArr[i][j+1] = '-';
                        //keep track of location of full magnet using string 
                        location += (i +" " + j + " "+ i + " " + (j+1) + "\n");
                        magnetCount--;
                    // Checks Space for [*, +] and fills * with -
                    }else if(charArr[i][j] == '*' && charArr[i][j+1] == '+'){
                        charArr[i][j] = '-';
                        //keep track of location of full magnet using string 
                        location += (i +" " + (j+1) + " "+ i + " " + j+ "\n");
                        magnetCount--;
                    //checks space for [-,*] and fills * with +
                    }else if(charArr[i][j] == '-' && charArr[i][j+1] == '*'){
                        charArr[i][j+1] = '+';
                        //keep track of location of full magnet using string 
                        location += (i +" " + (j+1) + " "+ i + " " + j+ "\n");
                        magnetCount--;
                    //checks space for [*,-] and fills * with +
                    }else if(charArr[i][j] == '*' && charArr[i][j+1] == '-'){
                        charArr[i][j] = '+';
                        //keep track of location of full magnet using string 
                        location += (i +" " + j + " "+ i + " " + (j+1)+ "\n");
                        magnetCount--;
                    //checks space for [+,-] and keeps track of magnet location
                    }else if(charArr[i][j] == '+' && charArr[i][j+1] == '-'){
                        //keep track of location of full magnet using string 
                        location += (i +" " + j + " "+ i + " " + (j+1)+ "\n");
                        magnetCount--;
                    //checks space for [-,+] and fills * with +
                    }else if(charArr[i][j] == '-' && charArr[i][j+1] == '+'){
                        //keep track of location of full magnet using string 
                        location += (i +" " + (j+1) + " "+ i + " " + j+ "\n");
                        magnetCount--;
                    }
                }
            }
        }
    }
}
