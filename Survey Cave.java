import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in[] = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);
        in = br.readLine().split(" ");
        int minClear = 101;
        int s = 0;
        for(int i = 0; i < N; i++){
            s = Integer.parseInt(in[i]);
            if(M - s < minClear) minClear = M - s;
        }
        if(minClear == 101) minClear = M;
        System.out.println(minClear);
        
    }
}