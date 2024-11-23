package Part1.BOJ9663;

import java.io.*;

public class B9663_yybmion {

    static int N=0;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        n_Queen(0, arr);
        bw.write(count+"");
        bw.flush();

    }

    public static void n_Queen(int depth, int[] arr){
        if(depth==N){
            count++;
            return;
        }
        for(int i=0;i<N;i++){
            arr[depth]=i;
            if(checkQ(depth,arr)) {
                n_Queen(depth+1,arr);
            }
        }
    }

    public static boolean checkQ(int i,int[] arr){
        for(int j=0;j<i;j++){
            if(arr[i]==arr[j]) return false;

            if(Math.abs(i-j)==Math.abs(arr[i]-arr[j])) return false;
        }
        return true;
    }
}


/**
 * 작성 예정 ㅜㅜ
 * https://jisunshine.tistory.com/186
 */
