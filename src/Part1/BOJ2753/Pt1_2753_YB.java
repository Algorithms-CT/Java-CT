package Part1.BOJ2753;

import java.io.*;

public class Pt1_2753_YB {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());

        if((N%4 == 0 && N%100 != 0) || N%400 == 0){
            bw.write("1");
        }else{
            bw.write("0");
        }

        bw.flush();
    }
}

/**
 * conlict test ++
 */
