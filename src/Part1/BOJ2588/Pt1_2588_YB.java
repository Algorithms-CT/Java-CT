package Part1.BOJ2588;

import java.io.*;

public class Pt1_2588_YB {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        for (int i=String.valueOf(M).length()-1 ; i>=0 ; i--){
            char target;
            target = String.valueOf(M).charAt(i);

            bw.write((Character.getNumericValue(target) * N) +"\n");
        }

        bw.write(String.valueOf(N*M));

        bw.flush();

    }
}

/**
 * test comment
 */

/**
 * conlict test ++
 */
