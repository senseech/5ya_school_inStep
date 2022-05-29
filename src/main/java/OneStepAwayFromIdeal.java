import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class OneStepAwayFromIdeal {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream(in.nextLine());
        byte[] inputBuffer = new byte[fileInputStream.available()];
        fileInputStream.read(inputBuffer, 0, fileInputStream.available());
        ArrayList<Character> arrayChars = new ArrayList();
        for (int i = 0; i < inputBuffer.length; i++)
            arrayChars.add((char)(inputBuffer[i]));













        arrayChars.forEach(System.out::print);




//        char[] strChars = new char[inputBuffer.length];
//        for (int i = 0; i < inputBuffer.length; i++)
//            strChars[i] = (char)(inputBuffer[i]);
//
//        strChars.
//
//        Arrays.stream(strChars).findFirst("(");























    }
    public int CheckString(ArrayList<Character> arrayList){
        final int[] countBrackets = {0,0,0};
        boolean check = false;
        if (arrayList.contains("=")){
            arrayList.forEach(ch ->{
                if (!check){
                    if (ch.equals("(")) countBrackets[0]++;
                    if (ch.equals(")")) countBrackets[0]--;
                }
                else {
                    if (ch.equals("(")) countBrackets[1]++;
                    if (ch.equals(")")) countBrackets[1]--;
                }
            });
        }
        else{
            arrayList.forEach(ch -> {
                if (ch.equals("(")) countBrackets[2]++;
                if (ch.equals(")")) countBrackets[2]--;
            });
        }


        return 1;
    }
}
