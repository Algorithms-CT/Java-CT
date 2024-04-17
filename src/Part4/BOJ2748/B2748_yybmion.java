package Part4.BOJ2748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2748_yybmion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Long[] arr = new Long[n+1];

        arr[0] = 0L;
        arr[1] = 1L;

        for(int i=2;i<arr.length;i++){
            arr[i] = arr[i-1] + arr[i-2];
        }

        System.out.println(arr[n]);
    }
}

/**
 * 점화식을 세우자.
 * 하지만 점화식을 세우는 그 과정이 너무 어렵다.
 * 이 문제는 규칙을 찾아서 그대로 점화식을 코드로 녹였다.
 */
