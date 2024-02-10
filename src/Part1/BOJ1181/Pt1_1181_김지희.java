import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.*;

public class Pt1_1181_김지희 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        ArrayList<String> check = new ArrayList<>();

        boolean cc = false;


        for(int i=0; i<n; i++){ // 일단 배열에 넣어준다
            String s = br.readLine();
            arr[i] = s;
        }

        // 이 부분이 제일 중요하다

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2){
                if(s1.length() == s2.length())
                    return s1.compareTo(s2);
                else
                    return s1.length() - s2.length();
            }
        });


        ArrayList<String> ac = new ArrayList<>();

        for(int i=0; i<n; i++){
            cc = true;
            for(int j=i+1; j<n; j++) {
                if (arr[i].equals(arr[j])) {
                    cc = false;
                    break;
                }
            }
            if(cc)
                ac.add(arr[i]);
        }
        for(String d : ac){
            System.out.println(d);
        }
    }
}

/*

 자바의 compare 메서드를 잘 활용하다. return 은 int 형이며
 람다 형식으로 선언할 수 있다.
 또한 compareTo 메서드를 활용하면 알파벳 순으로 정렬을 해주게 된다.
 참고 :  https://infodon.tistory.com/51
 */
