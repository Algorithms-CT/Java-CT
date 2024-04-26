package Part2.BOJ9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class B9012_99hyeon {

    static Stack<Character> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++){
            String stringTmp = br.readLine();

            for(int j = 0; j < stringTmp.length(); j++){
                stack.push(stringTmp.charAt(j));
            }

            checkVPS();     //VPS 맞는지 체크
            stack.clear();
        }
        br.close();
        System.out.println(sb);
    }

    static void checkVPS(){

        int left = 0;   //'(' 갯수
        int right = 0;  //')' 갯수

        while(!stack.isEmpty()){
            char tmp = stack.pop();

            if(tmp == ')'){
                right++;
            }else {
                if(right > 0){
                    right--;
                }else{
                    sb.append("NO").append("\n");
                    return;
                }
            }
        }
        if(left == 0 && right == 0){
            sb.append("YES").append("\n");
            return;
        }else{
            sb.append("NO").append("\n");
            return;
        }
    }
}

/**
 * VPS가 되려면 ()이 형태로 되어있어야 한다. 순서적으로 따지면 '('이 먼저 나오고 후에 ')'이 나와야 한다는 것을 이용했다.
 * checkVPS 함수를 통해서 VPS를 판별했다.
 * 우선 입력받은 데이터들을 스택에 넣어보관했기 때문에 스택의 FILO 특징을 이용하면
 * ')'가 나오고 그 후에 '('가 나와야한다.
 * 그래서 stack에서 하나씩 뽑아오면서 '('가 먼저나오면 바로 VPS가 아닌 판별을 하고
 * ')'가 나오고 그 후에 '('가 나오면 ')'갯수를 1 감소 시키는 것으로 하였다.
 */