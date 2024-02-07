package Part1.BOJ1978;

import java.io.*;
import java.util.StringTokenizer;

public class Pt1_1978_YB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count =0;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer stt = new StringTokenizer(br.readLine());

        for(int i=0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(stt.nextToken());
        }


            for (int j = 0; j < arr.length; j++) {

                int w;

                for(w = 2 ; w<arr[j] ; w++) {
                    if ((arr[j] % w) == 0) {
                        break;
                    }
                }
                if(arr[j] == w) count++;
            }

        bw.write(String.valueOf(count));
        bw.flush();
    }
}

/** 처음에 시간복잡도를 낮추기 위해 이중for문을 최대한 쓰지 않으려고 알고리즘을 계속 생각해보았는데
 * 아직 실력이 부족하여 계속 알고리즘이 틀렸다고 나왔다. 결국 이중 For문을 사용하였다.
 *
 * 알고리즘은 간단하다 배열에 입력받은 수 다 저장하고 하나씩 가져와서 w변수 숫자 2부터 입력받은 숫자 -1까지
 * w수를 늘려가며 나눠지는 숫자가 있는지 판단하는것이다. 만약 나누어지는 숫자가 있으면 그것은 소수가 아니라는 의미이다.
 * 따라서 arr[j]%w==0을 통해서 나눠지는게 있으면 바로 패스하고 다음 입력 값 확인
 * 근데 계속해서 나눠지는게 없고 입력값까지 w가 증가되었다면 이는 소수라는 의미이므로 count++ 해준다.
 *
 * 뭔가 이중 For문이 아닌 방법으로 다시 한번 풀어보고싶다.
 *
 * */
