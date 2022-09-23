import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        for(int i =0;i<s.length();i++){
            // System.out.println(s.charAt(i));
            
        }
        int hour=(s.charAt(0)-'0')*10 + s.charAt(1)-'0';
        int minute = (s.charAt(3)-'0')*10 + s.charAt(4)-'0';
        int second = (s.charAt(6)-'0')*10 + s.charAt(7)-'0';
        
        
        
        // System.out.printf("%02d:%02d:%02d",hour,minute,second);
        
        if(s.charAt(8)=='p'|| s.charAt(8)=='P' && hour<12){
            hour= hour+12;
        }
        else if(s.charAt(8)=='a'|| s.charAt(8)=='A'){
            hour= hour%12;
            
        }
        String str = String.format("%02d:%02d:%02d",hour,minute,second);
return str;
    }
    

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
