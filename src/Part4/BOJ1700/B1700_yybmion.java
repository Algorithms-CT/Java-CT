package Part4.BOJ1700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B1700_yybmion {
    static ArrayList<Integer> arr;
    static Set<Integer> put;
    static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stt = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stt.nextToken());
        int K = Integer.parseInt(stt.nextToken());
        int p = 0;
        int count = 0;
        arr = new ArrayList<>();
        put = new HashSet<>();
        set = new HashSet<>();

        stt = new StringTokenizer(br.readLine());

        while(stt.hasMoreElements()){
            arr.add(Integer.parseInt(stt.nextToken()));
        }

        while(!(put.size()==N)) {
            if(p==K) {
                System.out.println(count);
                return;
            }
            put.add(arr.get(p++));
        }


        for(int i=p;i<K;i++){
            if(put.contains(arr.get(i))) continue;

            for(int j=i+1;j<K;j++){
                if(put.contains(arr.get(j))){
                    set.add(arr.get(j));
                }
                if(set.size()==N-1) break;
            }

            set.add(arr.get(i));
            put.clear();
            put.addAll(set);
            count++;
            set.clear();
        }

        System.out.println(count);
        br.close();
    }

}
