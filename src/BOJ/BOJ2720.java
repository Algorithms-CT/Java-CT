package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2720 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int N = Integer.parseInt(br.readLine());

            for(int i=0;i<N;i++){
                int[] arr = {1,1,1,1};
                int[] price = {25,10,5,1};
                int value = Integer.parseInt(br.readLine());

                greed(value,arr,price);
            }
        }

        private static void greed(int value,int[] arr,int[] price) {
            for (int i = 0; i < 4; i++) {
                if (value - price[i] >= 0) {
                    arr[i] += value / price[i];
                    value = value % price[i];
                }
            }

            for (int i : arr) {
                System.out.print(i - 1 + " ");
            }

        }

}
