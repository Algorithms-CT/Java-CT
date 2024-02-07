import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pt1_1152_김지희 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();

        StringTokenizer st = new StringTokenizer(a," ");
        int count = 0;


        while(st.hasMoreTokens()){
            String c = st.nextToken();
            count++;
        }

        System.out.println(count);
    }
}

/*
  token 이 얼마나 있는지 확인하려면 hasMoreTokens 메서드를 사용하면 된다 !!
 */
