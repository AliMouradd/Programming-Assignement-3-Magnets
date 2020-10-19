//Ali Mourad

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(new File("input.txt"));
        int magnetCount = reader.nextInt();
        //System.out.println(magnetCount);

        String lineOne = reader.next();
        lineOne += reader.next();

        //System.out.println(lineOne.length() + "\n" + lineOne);

        char [][] charArr = new char [lineOne.length()/2][2];

        for(int i = 0; i<charArr.length; i ++){
            for(int j = 0; j<charArr[i].length-1; j+=2){
                charArr[i][j] = lineOne.charAt(i);
                charArr[i][j+1] = lineOne.charAt(i+(lineOne.length()/2));
                //System.out.println("Values at arr["+j+"]["+i+"] ["+(j+1)+"]["+i+"] is "+charArr[i][j] + " " + charArr[i][j+1]);
            }
        }

        //System.out.println(Arrays.deepToString(charArr));

        String location = "";
        for(int i = 0; i < charArr.length; i++){
            if(magnetCount == 0){
                break;
            }
            //System.out.println("Outerloop not **");
            for(int j = 0; j < charArr[i].length-1; j+=2){

                if(magnetCount == 0){
                    break;
                }
                //System.out.println("Inner loop not **");
                // Checks space for [+ ,*] then fills * with -
                if(charArr[i][j] == '+' && charArr[i][j+1] == '*'){
                    charArr[i][j+1] = '-';
                    //keep track of location of full magnet using string
                    location += (j +" " + i + " "+ (j+1) + " " + i +"\n");
                    magnetCount--;

                    // Checks Space for [*, +] and fills * with -
                }else if(charArr[i][j] == '*' && charArr[i][j+1] == '+'){
                    charArr[i][j] = '-';
                    //keep track of location of full magnet using string
                    location += ((j+1) +" " + i + " "+ j + " " + i+"\n" );
                    magnetCount--;

                    //checks space for [-,*] and fills * with +
                }else if(charArr[i][j] == '-' && charArr[i][j+1] == '*'){
                    charArr[i][j+1] = '+';
                    //keep track of location of full magnet using string
                    location += ((j+1) +" " + i + " "+ j + " " + i+ "\n");
                    magnetCount--;

                    //checks space for [*,-] and fills * with +
                }else if(charArr[i][j] == '*' && charArr[i][j+1] == '-'){
                    charArr[i][j] = '+';
                    //keep track of location of full magnet using string
                    location += (j +" " + i + " "+ (j+1) + " " + i+ "\n");
                    magnetCount--;

                    //checks space for [+,-] and keeps track of magnet location
                }else if(charArr[i][j] == '+' && charArr[i][j+1] == '-'){
                    //keep track of location of full magnet using string
                    location += (j +" " + i + " "+ (j+1) + " " + i + "\n");
                    magnetCount--;

                    //checks space for [-,+] and fills * with +
                }else if(charArr[i][j] == '-' && charArr[i][j+1] == '+'){
                    //keep track of location of full magnet using string
                    location += ((j+1) +" " + i + " "+ j + " " + i + "\n");
                    magnetCount--;

                }
            }
        }

        if(magnetCount != 0){
            for(int i = 0; i < charArr.length; i++){
                if(magnetCount == 0){
                    break;
                }
                //System.out.println("Outerloop **");
                for(int j = 0; j < charArr[i].length-1; j+=2){
                    if(magnetCount == 0){
                        break;
                    }
                    //System.out.println("Inner loop **");
                    if(charArr[i][j] == '*' && charArr[i][j+1] == '*'){
                        if(i == charArr.length-1){
                            if(charArr[i-1][j] == '+'){
                                charArr[i][j] = '-';
                                charArr[i][j+1] = '+';
                                location += ((j+1) +" " + i + " "+ j + " " + i + "\n");
                                magnetCount --;
                            }else{
                                charArr[i][j] = '+';
                                charArr[i][j+1] = '-';
                                location += ( j +" " + i + " "+ (j+1) + " " + i + "\n");
                                magnetCount --;
                            }
                        }else if (i == 0){
                            if(charArr[i+1][j] == '+'){
                                charArr[i][j] = '-';
                                charArr[i][j+1] = '+';
                                location += ((j+1) +" " + i + " "+ j + " " + i + "\n");
                                magnetCount --;
                            }else{
                                charArr[i][j] = '+';
                                charArr[i][j+1] = '-';
                                location += ( j +" " + i + " "+ (j+1) + " " + i + "\n");
                                magnetCount --;
                            }
                        }else{
                            if(charArr[i-1][j] == '+' && charArr[i+1][j] == '-'){
                                break;
                            }
                            if(charArr[i-1][j] == '-' && charArr[i+1][j] == '+'){
                                break;
                            }
                            if(charArr[i-1][j] == '+'){
                                charArr[i][j] = '-';
                                charArr[i][j+1] = '+';
                                location += ((j+1) +" " + i + " "+ j + " " + i + "\n");
                                magnetCount --;
                            }else{
                                charArr[i][j] = '+';
                                charArr[i][j+1] = '-';
                                location += ( j +" " + i + " "+ (j+1) + " " + i + "\n");
                                magnetCount --;
                            }
                        }
                    }
                }
            }
        }

        //System.out.println(Arrays.deepToString(charArr));
        FileWriter writer = new FileWriter("output.txt");
        writer.write(location);
        writer.close();
    }
}
