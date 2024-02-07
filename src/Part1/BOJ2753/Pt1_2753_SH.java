package Part1.BOJ2753;

import java.io.*;

public class Pt1_2753_SH {

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        int year = Integer.parseInt(br.readLine());

        if(year % 4 == 0){
            if(year % 100 != 0 || year % 400 == 0){
                bw.write("1");
            }
            else
                bw.write("0");
        }
        else{
            bw.write("0");
        }

        bw.flush();
        br.close();
        bw.close();

    }
}

/**
 * easy.
 */



//(제 코멘트.. 킹받나유..? ㅎㅎ)
