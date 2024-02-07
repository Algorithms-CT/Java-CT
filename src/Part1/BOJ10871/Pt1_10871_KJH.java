import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pt1_10871_KJH {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] array = new int[a];

        for(int i=0; i<array.length; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<array.length; i++){
            if(array[i] < b)
                System.out.print(array[i]+" ");
        }
    }
}
