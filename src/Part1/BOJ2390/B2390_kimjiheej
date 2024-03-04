package Part1.BOJ2390;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B2390_kimjiheej {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];

        int total = 0;

        for(int i=0; i<9; i++){
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
        }

        int check = total - 100;

        int p = 0;
        int q = 0;

        boolean cc  = true;

        for(int i=0; i<9; i++){

            cc = false;
            for(int j=i+1; j<9; j++){
                if(arr[i]+arr[j] == check){
                    p = i;
                    q = j;
                    cc = true;
                    break;
                }
            }

            if(cc)
                break;

        }

        ArrayList<Integer> answer = new ArrayList<>();


        for(int i=0; i<9; i++){
            if(i != p && i !=q)
                answer.add(arr[i]);
        }


        Collections.sort(answer);

        for(int k : answer){
            System.out.println(k);
        }

    }
}
/*
  완적 탐색 문제이다 !! 반복문을 사용해서 풀었다 ~~

  완전 탐색의 개념 참고 : https://velog.io/@suk13574/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%99%84%EC%A0%84%ED%83%90%EC%83%89
 */
