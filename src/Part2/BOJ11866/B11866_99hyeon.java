package Part2.BOJ11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11866_99hyeon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        br.close();

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= size; i++){
            queue.offer(i);
        }

        int i = 1;
        System.out.print("<");
        while(!queue.isEmpty()){    //큐에 원소가 없을 때까지 반복

            if(i < num){
                queue.offer(queue.element());
                queue.remove();
                i++;
            }else if(queue.size() == 1){
                System.out.print(queue.poll() +">");
            }else{
                System.out.print(queue.poll() +", ");
                i = 1;
            }
        }
    }
}

/**
 * 큐룰 돌면서 num에 저장된 숫자의 순서에 해당되는 원소부터 제거되야 하기 때문에
 * 계속해서 반복문을 돌렸다.
 * 본인이 제거될 순서가 아니면 큐의 제일뒤로 보내고
 * 순서에 해당되면 큐에서 제거하였다.
 */