package Part1.BOJ1914;

import java.io.*;
import java.math.BigInteger;

public class Pt1_1914_YB {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger res = new BigInteger("2");
        int N = Integer.parseInt(br.readLine());

        if(N<=20) {
            bw.write((int)Math.pow(2,N)-1+"\n");
            hanoi(N, 1, 2, 3);
        }else{
            BigInteger ansValue = res.pow(N).subtract(BigInteger.ONE);
            bw.write(ansValue + "\n");
        }
        bw.flush();
    }

    public static void hanoi(int N, int start, int mid, int to) throws IOException{
        if(N==1){
            bw.write(start +" "+ to+"\n");
        }else {
            hanoi(N - 1, start, to, mid);
            bw.write(start + " " + to + "\n");
            hanoi(N - 1, mid, start, to);
        }

    }

}

/**
 * 재귀는 정확히 2가지만 기억하면 된다.
 * 첫번째 문제의 정의를 정확히 표기한다.
 * 두번째 종료조건 기술
 *
 * 그리고 또 재귀함수를 이해하기 위해 선언형(declarative) vs 명령형(Imperative)를 알 필요가 있는데
 * 명령형 프로그램은 알고리즘을 명시하고 목표는 명시하지 않는 데 반해
 * 선언형 프로그램은 목표를 명시하고 알고리즘을 명시하지 않는 것이다.
 * 재귀는 선언형 프로그램으로 앞서 말한 문제의 정의를 표기만 하면 알고리즘을 적어주지 않아도 알아서 컴퓨터가 계산해서 결과를 도출해낸다.
 *
 * 그럼 하노이탑의 문제의 정의를 알아보자
 * N개의 블록이 start에 처음에 있을것이다. N개의 블록중 가장 마지막블록이 세번째 도착지에 들어와야 한다는 사실은 알것이다.
 * 그려려면 N-1개의 블록이 중간지점에 순서대로 정렬되어있어야 마지막 블록을 첫번째에서 세번째로 옮길 수 있을 것이다.
 * 그럼 마지막 블록을 세번째에 옮겼다고 가정을 해보자 그럼 두번쨰의 정렬되어있는 N-1개의 블록중 마지막 블록을 또 세번째에 옮겨야할것이다.
 * 그럼 그 얘기는 뭐냐 N-2개의 블록을 첫번째 블록에 다 옮기고 세번째 블록에 제일 밑의 블록을 옮겨야할것이다.
 * 이 과정의 반복인데
 * 일단 너무 장황하게 써서 정리할 필요가 있어 보인다.
 * 쉽게 말해 N-1블록을 두번째에 옮겨 세번째에 가장 무거운 블록 옮기면 그 블록은 없다고 생각하고
 * 두번째에 있는 블록을 아까 시작부분 N개 블록을 옮긴것 처럼 첫번째 핀을 통해 N-1개의 블록을 옮긴다고 생각하면 된다.
 *
 * Hanoi(int N, int start, int mid, int to)
 * 1. N-1개 블록은 start에서 to로 mid를 통해 옮긴다.   Hanoi(N,start,to,mid)
 * 2. 하나 남은 블록을 to블록으로 옮긴다.
 * 3. N-1개 블록은 mid에서 to로 start를 통해 옮긴다.   Hanoi(N,mid,start,to)
 *
 * 솔직히 어떻게 옮겨지는 것 따위는 알면 좋겠지만 문제의 정의를 해놓으면 우리가 알 바가 아니다.
 * 하지만 분명한건 나중에 콜스택을 통해서 재귀가 어떻게 동작하는지 정확히 알 필요는 있다.
 *
 * 일단 몇번 움직이는지에 대한 출력은 일반식이 있어서 그냥 만들어주면된다.
 * 2^n-1 번 옮겨진다.
 * 20번 이하는 과정까지 출력하고 그 초과하는 값은 몇번 옮겨지는지에 대한 값만 출력하면 되는데 여기서
 * 틀려버렸다. 이게 제곱을 이용하다 보니 입력값이 100까지 된다면 Integer로는 값을 다 출력하지 못하는 문제가 발생한다.
 * 따라서 Integer가 아닌 BigIntger를 사용해야한다는 점을 이번에 알았다.
 *
 * 재귀에 대한 연습이 많이 필요한것같다.... 어렵다...
 *
 * from = start / to = to / using = mid
 * 1. Move n-1 Discs from A to B using C
 * 2. Move a Disc from A to C
 * 3. Move n-1 Discs from B to C using A
 */
