package Part1.BOJ4344;

import java.io.*;
import java.util.StringTokenizer;

public class Pt1_4344_YB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int C = Integer.parseInt(br.readLine());
        int sum = 0;
        double avr = 0;
        double count = 0;

        for(int i=0;i<C;i++){
            StringTokenizer stt = new StringTokenizer(br.readLine());
            int how = Integer.parseInt(stt.nextToken());
            int[] arr = new int[how];
            for(int j=0; j<how;j++){
                int ret = Integer.parseInt(stt.nextToken());
                arr[j] = ret;
                sum+=ret;
            }
            avr = (double)sum/how;

            for(int k=0;k<how;k++){
                if(arr[k]>avr) count ++;
            }
            String formatResult = String.format("%.3f", (count / how) * 100);
            bw.write(formatResult + "%" +"\n");
            sum=0;
            avr=0;
            count =0;
        }
        bw.flush();

    }
}

/**
 * C변수는 총 몇개의 데이터를 앞으로 받을지에 대한 변수
 * sum변수는 앞으로 받을 점수들의 합을 나타내는 변수
 * avg는 그 합에 대한 평균
 * count변수는 각 입력받은 점수가 avg보다 크면 1씩 늘려 count하는 변수
 *
 * 먼저 몇개의 데이터를 받을지 how 변수에 저장하여
 * how변수를 통해 for문을 돌린다음 하나씩 점수를 가져온다. 가져온 점수는 arr 배열에 저장하고
 * 동시에 sum변수에 해당 줄의 점수들을 모두 더한다. 이후 avg를 구해준다.
 *
 * 다음 for문은 아까 저장한 점수에 대한 배열의 값을 하나씩 가져와서 방금 구한 avg와 비교하여
 * 평균(avg)보다 크면 count를 늘려주어 저장한다.
 *
 * 이를 %로 결과값을 나타내기 위해서는 String.format을 사용해야 한다. 해당 메소드는 다음 블로그를 참고하자.
 * https://youngjinmo.github.io/2021/02/string-format-with-casting/
 * 따라서 (count/how)*100을 통해 결과값을 가져온다.
 */
