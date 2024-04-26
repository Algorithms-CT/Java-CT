package Part2.BOJ13334;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class B13334_99hyeon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int num = Integer.parseInt(br.readLine());
        Line line[] = new Line[num];

        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());

            line[i] = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int distance = Integer.parseInt(br.readLine());
        br.close();

        Arrays.sort(line);  //right를 기준으로 오름차순 정렬

        int maxSize = 0;
        for(int i = 0; i < num; i++){
            priorityQueue.add(line[i].left);    // left를 내림차순 정렬하는 우선순위 큐에 삽입

            /**
             * 큐가 비었거나
             * 철로선상에 집과 회사가 다 안들어올 경우 큐에서 삭제
             */
            while(!priorityQueue.isEmpty() && priorityQueue.peek() < line[i].right - distance){
                priorityQueue.poll();
            }
            maxSize = max(maxSize, priorityQueue.size());
        }

        System.out.println(maxSize);

    }

    static class Line implements Comparable<Line>{
        int left;
        int right;
        public Line(int left, int right){
            this.left = min(left, right);
            this.right = max(left, right);
        }

        @Override
        public int compareTo(Line lineRight){
            return Integer.compare(right, lineRight.right);
        }
    }
}

/**
 * for 반복문이 이 알고리즘의 핵심이다.
 * right변수를 기준으로 오름차순 정렬된 line을 이용한다.
 * right 변수를 철로의 끝 점의 기준으로 삼고 그 안에 몇 명의 사람들이 속하는지 비교한다.
 *
 * 참고 : https://blog.naver.com/occidere/221085858307
 */