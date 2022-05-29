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
        for (byte b : inputBuffer) arrayChars.add((char) b);








        System.out.println(CheckString(arrayChars));
        arrayChars.forEach(System.out::print);
        System.out.println();
    }
    //хреновый поиск
    //не ищет )()(
    //Вроде ищет
    public static int CheckString(ArrayList<Character> arrayList){
        int[] countBrackets = {0,0,0};
        boolean checkSide = false;
        boolean[] checkBrackets = {false, false, false};
        if (arrayList.contains("=")){
            arrayList.forEach(ch ->{
                if (!checkSide){
                    if (ch.equals("(")) countBrackets[0]++;
                    if (ch.equals(")")) countBrackets[0]--;
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
            return 1;
        }
        else
            return 0;

    }
}
