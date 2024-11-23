package Part4.BOJ1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1541_yybmion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stt = new StringTokenizer(br.readLine(),"-");
        ArrayList<String> token = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder stb = new StringBuilder();
        int count = 0;              // 그때그때 마다의 값을 저장
        int ansVal = 0;

        while(stt.hasMoreElements()) {
            token.add(stt.nextToken());     // - 기준으로 분리 예를 들어 55-50+40 이면 55 와 50+40 으로 분리된다.
        }

        for(int i=0;i<token.size();i++){
            if(token.get(i).contains("+")){     // + 가 있으면
                for(int j=0;j<=token.get(i).length();j++){      // 하나씩 돌려서 append로 문자 더해주고
                    if(j<token.get(i).length() && token.get(i).charAt(j)>=48) {
                        stb.append(token.get(i).charAt(j));
                    }else {
                        count += Integer.parseInt(stb.toString());      // else는 숫자가 아닌 연산자 나왔을때 appen 문자 count에 더해준다.
                        stb = new StringBuilder();                      // append 초기화
                    }
                }
                ans.add(String.valueOf(count));
                count=0;
            }else {
                ans.add(token.get(i));          // + 포함 안할때는 그냥 바로 넣어준다.
            }
        }

        ansVal = Integer.parseInt(ans.get(0));      // 처음 값은 넣어주고
        for(int i=1;i<ans.size();i++){
            ansVal -= Integer.parseInt(ans.get(i));     // 이후 각각 더해진 값들을 뺄셈해준다.
        }

        System.out.println(ansVal);
    }
}


/**
 * 아래 풀이는 블로그에서 깔금하게 코딩해서 가져와봤다.
 * https://st-lab.tistory.com/148
 */
//import java.io.BufferedReader;
//        import java.io.InputStreamReader;
//        import java.io.IOException;
//        import java.util.StringTokenizer;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int sum = Integer.MAX_VALUE;	// 초기 상태 여부 확인을 위한 값으로 설정
//        StringTokenizer subtraction = new StringTokenizer(br.readLine(), "-");
//
//        while (subtraction.hasMoreTokens()) {
//            int temp = 0;
//
//            // 뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰들을 더한다.
//            StringTokenizer addition = new StringTokenizer(subtraction.nextToken(), "+");
//
//            // 덧셈으로 나뉜 토큰들을 모두 더한다.
//            while (addition.hasMoreTokens()) {
//                temp += Integer.parseInt(addition.nextToken());
//            }
//
//            // 첫 번째토큰인 경우 temp값이 첫 번째 수가 됨
//            if (sum == Integer.MAX_VALUE) {
//                sum = temp;
//            } else {
//                sum -= temp;
//            }
//        }
//        System.out.println(sum);
//    }
//
//}
