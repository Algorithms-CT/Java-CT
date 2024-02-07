package Part1.BOJ8958;

import java.io.*;

public class Pt1_8958_YB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int num = 0;
        int ret = 0;

        for(int i =0; i<N ; i++){
            String res = br.readLine();
            for(int j=0 ; j<res.length() ; j++){
                if(res.charAt(j) == 'O') {
                    num++;
                    ret += num;
                }else{
                    num = 0;
                }
            }
            bw.write(ret + "\n");
            ret = 0;
            num = 0;
        }

        bw.flush();
    }
}

/**
 * num 변수는 'O'였을때 1점씩 점수를 늘리기 위한 변수이고
 * ret는 점수를 계속 더해서 총점수를 return 하기 위한 변수이다.
 *
 * 이중 for문을 사용하였다.
 * 먼저 첫번째 for문은 몇개의 ox줄을 받을지 정한 변수 N을 반복하기 위해서고
 * 두번째 for문은 한 줄 받은 문자열에 대해 본격적인 점수 계산을 위한 for문이다.
 * 따라서 두번째 for문에서는 res 변수에 'OXOXOO...' 이러한 변수가 담기고
 * 이 변수에 대해 charAt()을 통해 문자를 하나하나 가져와서 'O'와 비교해서 같으면 num을 하나씩 증가시키고
 * ret에 더해준다. 대신 X면 num을 초기화 시키고 그냥 넘긴다. 이 과정을 반복한다.
 *
 * 여기서 주의할건 ret과 num은 ret값을 write해주고 나서 0으로 초기화 시켜줘야한다.
 */
