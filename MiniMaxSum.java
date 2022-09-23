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
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        
        // BigInteger  min=new BigInteger("0");
        // BigInteger  max=new BigInteger("0");
        Long min= 0L;
        Long max= 0L;
        
        for(int i=0;i<arr.size()-1;i++){
            // min.add(new BigInteger("arr.get(i)"));
            //  max.add(new BigInteger("arr.get(i)"));
           min= min+ arr.get(i);
           max= max+ arr.get(i);
        }
        for(int i =0;i<arr.size();i++){
        //   BigInteger sum= new BigInteger("0");
        Long sum= 0L;
            for(int j=0;j<arr.size();j++){
                if(i!=j){
                    // sum.add(new BigInteger("arr.get(j)"));
                    sum = sum+arr.get(j);
                // System.out.println("inside j loop"+j);
                // System.out.println(sum);
                }
                
               
                
            }
            if(min<=sum){
                if(max<=sum){
                    max= sum;
                }
            }
            else{
                min = sum;
            }
           
            // if(min.compareTo(sum)<=0){
            //     if(max.compareTo(sum)<=0){
            //         max= sum;
            //     }
            // }
            
            // else{
            //     min= sum;
            // }
                 
        }
        System.out.println(min+" "+max);
        
        
        
        
    // Write your code here

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
