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
        ArrayList<Character>arrayChars_tmp = new ArrayList();
        for (byte b : inputBuffer) arrayChars.add((char) b);



        if (CheckString(arrayChars)){
            System.out.println(-1);
        } else {
            for(int i = 0; i < arrayChars.size(); i++){
                arrayChars_tmp = arrayChars;
                if (arrayChars_tmp.get(i).equals("(") |
                        (arrayChars_tmp.get(i).equals(")"))){
                    arrayChars_tmp.remove(i);
                    if (CheckString(arrayChars_tmp)){
                        System.out.println(i+1);
                        break;
                    }
                }
                if (i == arrayChars.size()) System.out.println(-1);
            }
        }


//        System.out.println(CheckString(arrayChars));
//        arrayChars.forEach(System.out::print);
//
//        arrayChars.remove(5);
//        System.out.println();
//        arrayChars.forEach(System.out::print);
//        System.out.println();
//        System.out.println(arrayChars.remove(5));
//        arrayChars.forEach(System.out::print);
    }
    //хреновый поиск
    //не ищет )()(
    //Вроде ищет
    public static boolean CheckString(ArrayList<Character> arrayList){
        int[] countBrackets = {0,0,0};
        final boolean[] checkSide = {false};
        boolean[] checkBrackets = {false, false, false};
        if (arrayList.contains("=")){
            arrayList.forEach(ch ->{
                if (!checkSide[0]){
                    if (ch.equals("(")) countBrackets[0]++;
                    if (ch.equals(")")) countBrackets[0]--;
                    if (ch.equals("=")) checkSide[0] = true;
                    if (countBrackets[0] < 0) checkBrackets[0] = true;
                }
                else {
                    if (ch.equals("(")) countBrackets[1]++;
                    if (ch.equals(")")) countBrackets[1]--;
                    if (countBrackets[1] < 0) checkBrackets[1] = true;
                }
            });
        }
        else{
            arrayList.forEach(ch -> {
                if (ch.equals("(")) countBrackets[2]++;
                if (ch.equals(")")) countBrackets[2]--;
                if (countBrackets[2] < 0) checkBrackets[2] = true;
            });
        }
        if ((Arrays.equals(countBrackets, new int[]{0, 0, 0})) &
                (Arrays.equals(checkBrackets, new boolean[]{false, false, false}))){
            return true;
        }
        else
            return false;

    }
}
