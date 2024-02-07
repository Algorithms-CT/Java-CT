package Part1.BOJ1152;

import java.io.*;

public class Pt1_1152_YB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = 0;

        String voca = br.readLine();

        String[] res = voca.split(" ");

        for (String arr : res) {
            if(arr == ""){
                count = 0;
            }else {
                count++;
            }
        }

        bw.write(count + "");

        bw.flush();
    }
}

// TODO: 2024-01-29
/**
 * 먼저 디버그 기능을 활용해보려고 사용해봤는데
 * 이건 뭐 천국이 따로 없는 기능이다. 꼭 활용하며 문제를 풀면 도움이 많이 될것같다.
 *
 * 먼저 voca로 한 줄 받아오고
 * 그 문자열을 split을 통해, 공백을 통해 잘라주면 되는데
 * 여기서 주의할건 앞에 시작할때 공백으로 시작할 수 있다는 점이다.
 * 그러면 iter을 통해 arr이 ""이면 count = 0;으로 설정 즉, 처음 공백일때만 걸러주는 용도로 사용한 후
 * 다음단어들은 자연스럽 count를 올려주면 된다.
 *
 * 처음에는 arr == " " 라고 했는데 "" 붙여줘야한다고 디버거에서 알려줬다.
 * 이게 무슨 차이일까??
 * */
