package Part1.BOJ11654;

import java.io.*;

public class Pt1_11654_YB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char aci = br.readLine().charAt(0);

        int res = (int)aci;

        bw.write(res + "");

        bw.flush();
    }
}

/**
 * 먼저 br.readLine().charAt(0) 어짜피 하나이 문자만 받을거라 0번째를 받고
 * charAt 자체가 char형을 받는다(아스키코드)
 * 이를 int형으로 바꿔주면 끝인데 여기서 주의할 점은
 * bw.write가 int형을 그냥 적어주면 이상한 값을 뱉는다.
 * 사실 이상한 값은 아니고 예를 들어 65를 출력해보면 A가 나온다. 그렇다 아스키 코드의 값에 해당하는
 * 데이터를 반환하는 것이다. 그래서 int형을 출력하려면 뒤에 아무 빈 문자를 같이 출력해주면 자동으로 문자열로 인식하니
 * int형이 문자열로 뽑아진다.
 *
 * 처음에 왜 대체 안나오지 하면서 삽질했다...
 *
 * https://zz132456zz.tistory.com/17
 */
