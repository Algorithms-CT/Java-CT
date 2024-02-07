import java.io.*;
import java.util.StringTokenizer;

public class Pt1_8958_KJH {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());

        int total = 0;
        int count;

        for(int i=0; i<a; i++){
            String str = br.readLine();
            total = 0;

            char[] array = new char[str.length()];

            for(int j=0; j<str.length(); j++){
                array[j] = str.charAt(j);
            }

            count = 0;

            for(int k=0; k<array.length; k++){
                if(array[k] =='X'){
                    count = 0;
                    continue;
                }
                count++;
                total += count;
            }
            bw.write(total+"\n");
        }

        bw.flush();
    }
}
