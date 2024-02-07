package Part1.BOJ2869;

import java.io.*;
import java.util.StringTokenizer;

public class Pt1_2869_YB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stt = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(stt.nextToken());
        int B = Integer.parseInt(stt.nextToken());
        int V = Integer.parseInt(stt.nextToken());

        int day = (V-B)/(A-B);

        if(((V-B) % (A-B)) != 0){
            day++;
            bw.write(String.valueOf(day));
        }else{
            bw.write(String.valueOf(day));
        }

        bw.flush();
    }
}

/**
 * 음... 처음에 While문으로 풀어 시간초과를 마주하고 반복문을 사용하면 무조건 시간초과가 될것같아
 * if문만으로 풀어야하다는 것까지는 알았는데 계속 도전해봐도 알고리즘이 틀렸다고 나왔다.
 *
 * 블로그를 보며 무엇이 잘못되었는지 풀이를 확인했다. ㅜㅜ
 * V % (A-B) 가 0 이거나 0이 아니거나 까지는 도출해냈지만 V에서 내려가는 B의 값을 뺴주어 %를 계산해주었다.
 * 그래서 결론적으로 (V-B) % (A-B)로 계산을 계산을 했는데 아니 대체 왜 V에서 B를 빼는 지 이해가 되질 않았다.
 *
 * 찾아보니 조건중에는 일단 정상에 한번 도착하고 나면 더이상 미끄러지지 않는다는 조건이 있다.
 *
 * 따라서 만약 3 1 8 을 예로 든다면
 * 첫째날 UP : 3 DOWN : 2
 * 둘쨰날 UP : 5 DOWN : 4
 * 셋째날 UP : 7 DOWN : 6
 * 넷째날 UP : 9 여기서 8 넘었으니 종료!
 *
 * 원래는 그냥 V % (A-B)로 계산하면 딱 4로 나누어떨어졌다.
 * 하지만 V에서 B를 먼저 빼주고 (미끄러지는 걸 미리 계산) (A-B)를 해주면 (7 % 2) 로
 * 몫이 3이 나온다. 나머지가 있다는 것은 하루 더 올라가야한다는 의미로 나누어떨어지지 않는다면
 * 해당 몫에서 +1을 해주어야 답이 나온다.
 *
 * 그냥 쉽게 말해 up-down (A-B)는 이미 올라갔다가 내려간 것을 반영했으니, 가장 마지막에 내려가는
 * 조건을 막기 위해 먼저 V-B를 해줘서 미리 내려가는 것을 제외시켜버리고 계산하면
 * 최소한의 DAY값이 나오는 것이다.
 *
 * 거기서 딱 나누어떨어지면 그 최소값이 답이고 안 나누어떨어지면 +1 한 값이 답인것이다.
 *
 * https://st-lab.tistory.com/75
 */
