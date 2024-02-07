import java.io.*;

public class Pt1_2588_KJH {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();

        int a1 = Integer.parseInt(a);
        int b1 = Integer.parseInt(b);
        int sum = 0;

        char[] array = b.toCharArray();

        for (int i = array.length - 1; i >= 0; i--) {
            int result = a1 * (array[i] - '0');
            System.out.println(result);
            sum += result;
        }

        System.out.println(a1*b1);


        br.close();
        bw.close();
    }
}
