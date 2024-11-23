package Part4.BOJ11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047_yybmion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stt = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stt.nextToken());
        int value = Integer.parseInt(stt.nextToken());
        int j=N-1;
        int count=1;

        int[] arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        while(true){
            if(value-arr[j]>=0){            // 최종 값에서 정렬되어있는 값중 가장 큰 값 부터 빼서 그 값이 0보다 크거나 같으면 일단 나눌 수 있다는 것
                count+=value/arr[j];        // 하지만 나눌수 있다고 했지 몫이 나오지 않을 수 있다. 몫이 나오면 그 값만큼 count 올려준다.
                value = value % arr[j];     // value 값 갱신해준다.
                if(value==0) break;         // 0 되면 break;
            }
            j--;
        }

        System.out.println(count-1);
    }
}
