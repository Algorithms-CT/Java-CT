package Part2.BOJ2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B2504_99hyeon {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strTmp = br.readLine();
        Stack<Character> stack = new Stack<>();

        int result = 0;
        int weight = 1;

        for (int i = 0; i < strTmp.length(); ++i) {

            char c = strTmp.charAt(i);

            if (isOpenCharacter(c)) { // 여는 괄호일 경우

                stack.add(c); // 스택에 넣고
                weight *= getWeight(c); // 가중치를 곱해준다. ( 분배법칙 적용 )

            } else {

                if (!stack.isEmpty() && isMatch(stack.peek(), c)) { // 괄호열의 쌍이 맞다면, 식을 계산한다.

                    if (c == ')') {

                        if (strTmp.charAt(i - 1) == '(') // 바로 직전이 여는 괄호열이였다면, 바로 숫자로 처리하여 계산
                            result += weight;
                        stack.pop();
                        weight /= 2; // 분배법칙이 함께 적용될 괄호가 종료되었음.

                    } else {

                        if (strTmp.charAt(i - 1) == '[') // 바로 직전이 여는 괄호열이였다면, 바로 숫자로 처리하여 계산
                            result += weight;
                        stack.pop();
                        weight /= 3; // 분배법칙이 함께 적용될 괄호가 종료되었음.

                    }

                } else { // 쌍이 안 맞는 경우 처리
                    result = 0;
                    break;
                }
            }
        }

        if (!stack.isEmpty()) // 괄호열이 남았다. 올바르지 못한 괄호열이다.
            result = 0;

        System.out.println(result);
    }

    private static int getWeight(char c) {
        return c == '(' ? 2 : 3;
    }

    private static boolean isMatch(Character peek, char c) {

        if (peek == '(' && c == ')')
            return true;
        if (peek == '[' && c == ']')
            return true;

        return false;
    }

    private static boolean isOpenCharacter(char c) {
        if(c == '(' || c == '['){
            return true;
        }else
            return false;
    }
}

/**
 * 입력 데이터의 처음부터 읽어서 여는 괄호('(', '[')일 경우 stack에 넣고
 * 닫는 괄호(')', ']')일 경우 peek함수를 통해 이전 괄호가 어떤 괄호인지 판단하며 계산한다.
 *
 * 참고 : https://velog.io/@hyeokkr/%EB%B0%B1%EC%A4%802504-%EA%B4%84%ED%98%B8%EC%9D%98-%EA%B0%92-with-Java
 */
