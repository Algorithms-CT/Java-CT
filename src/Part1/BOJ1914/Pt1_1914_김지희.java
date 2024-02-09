import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Haru_11729 {

    static int count = 0;

   static  StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int a = Integer.parseInt(br.readLine());


        func(1,3,a);
        System.out.println(count);
        System.out.println(sb.toString());

    }

    public static void func(int a, int b, int n ){

        if(n==1){ // 1개 남았을 때를 의미한다
            sb.append(a+" "+b+"\n");
            count++;
            return;
        }

        func(a,6-a-b, n-1); // n-1 개의 원판을 기둥 6-a-b 로 옮긴다
        sb.append(a+" "+b+"\n");
        count++;
        func(6-a-b,b,n-1); // n-1 개의 원판을 기둥 6-a-b 에서 기둥 b로 옮긴다
    }
}
