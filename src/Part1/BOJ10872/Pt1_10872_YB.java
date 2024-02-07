package Part1.BOJ10872;

import java.io.*;

public class Pt1_10872_YB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int ret = factorial(N);

        if(N == 0) ret=1;

        bw.write(ret+"");
        bw.flush();

    }

    public static int factorial(int N) {

        if(N>0) {
            return N * factorial(N - 1);
        }else{
            return 1;
        }

    }
}
