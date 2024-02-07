package Part1.BOJ8958;

import java.io.*;

public class Pt1_8958_SH {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++){
            String answer = br.readLine();
            char[] tmpAnswer = answer.toCharArray();

            int count = 0;
            int score = 0;
            for(int j = 0; j < tmpAnswer.length; j++){
                if(tmpAnswer[j] == 'O'){
                    count++;
                    score += count;
                }
                else{
                    count = 0;
                }
            }
            bw.write(score + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}

/**
 * OX답안을 그냥 String으로 받아서 배열로 바꾸고 하나하나 비교하는 방식으로 했다
 * 음...
 * 연속으로 맞으면 더하는 수가 1씩 커지니까
 * 맞춘갯수(count)를 계속 점수(score)에 누적해서 더하는 방식으로 풀었다
 * ...그렇다
 * 오늘의 코멘트는 여기서 끝
 */
