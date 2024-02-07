package Part1.BOJ10871;

import java.io.*;
import java.util.StringTokenizer;

public class Pt1_10871_HS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        int[] arr= new int[length];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<length; i++) {
            if(arr[i] < num) {
                bw.write(arr[i] + " ");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

/* TODO 24.02.05
 * BufferedWriter 사용 -> 216ms
 * StringBuilder 사용 -> 252ms
 *
 * BufferedWriter를 사용하는 게 조금 더 빠르다!
 * */