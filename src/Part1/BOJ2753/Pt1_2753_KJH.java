import java.io.*;

public class Pt1_2753_KJH {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());

        if(a % 400 == 0)
            System.out.println(1);
        else if (a % 4 ==0 && a % 100 !=0)
            System.out.println(1);
        else
            System.out.println(0);
    }

}
