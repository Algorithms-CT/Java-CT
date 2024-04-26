package Part4.BOJ2748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2748_llocr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n+1];     //숫자가 매우 커질 수도 있으니 long 타입 사용하자..!

        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2; i<=n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        System.out.println(arr[n]);
    }
}

/*
* DP를 사용하는 첫 문제라서 그런지 쉬웠다!
* DP 개념에 대해서 영상을 본 후 풀었더니, 이 문제를 어떻게 하면 중복 연산 없이 진행할 수 있을까 생각해보게 되었고?
* 중복 연산을 하지 않고 n번째 수를 구하기 위해서 배열을 선언해서 거기에 값을 쭉 넣는 방식으로 진행했다!
*
* DP가 굉장히 어렵다고 하니,, 다양한 문제를 풀어보면서 시야를 키우고 하위 알고리즘 개념들도 더 학습해야겠다고 생각하게 된다 :(
* */