package Part2.BOJ2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493_99hyeon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Stack<int[]> stack = new Stack<>();

        int num = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        br.close();

        for(int i = 0; i < num; i++){
            int tmpNum = Integer.parseInt(st.nextToken());

            if(stack.isEmpty()){    // 비교할 대상 없을 시
                sb.append("0").append(" ");
                stack.push(new int[] {tmpNum, i + 1});
            }else{
                int[] tmp = stack.peek();

                if(tmp[0] > tmpNum){    //바로 앞에 자기보다 높은 게 있을 시
                    sb.append(tmp[1]).append(" ");
                    stack.push(new int[] {tmpNum, i + 1});
                }else{
                    stack.pop();
                    while(!stack.isEmpty()){
                        tmp = stack.peek();

                        if(tmp[0] > tmpNum) {    //바로 앞에 자기보다 높은 게 있을 시
                            sb.append(tmp[1]).append(" ");
                            stack.push(new int[] {tmpNum, i + 1});
                            break;
                        }
                        stack.pop();
                    }
                    if(stack.isEmpty()) {    // 비교할 대상 없을 시
                        stack.push(new int[]{tmpNum, i + 1});
                        sb.append("0").append(" ");
                    }
                }
            }
        }

        System.out.println(sb);
    }
}


/**
 * 처음엔 값을 가지고 스택 인덱스를 알 수 있는 함수가 존재하길래 스택을 돌면서 값을 비교해 본인보다 높은 곳의 인덱스를 찾았다.
 * 하지만 시간초과가 났다. 그래서 찾아보니 pop을 이용하는 문제였다.
 * 어차피 앞에 자기보다 낮은 탑이 있다면 뒤에 오는 탑들은 다 본인한테 막혀 앞의 자기보다 낮은 탑에 쏘지 못할테니 pop을해도 상관없던 거였다.
 * 이게 이 문제의 핵심이었다.
 * 그리고 stack에 배열을 넣어서 할 수 있다는 것도 잘 활용하면 쉽게 풀 수 있는 문제였다.
 *
 * 참고 : https://loosie.tistory.com/266
 */
