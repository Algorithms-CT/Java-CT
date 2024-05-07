import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;


//보자마자 배열을 생각하면서 풀었는데 베이스 케이스를 잘못 설정해서 조금 고생했던 문제
public class B5639_samgashyeong {

    static ArrayList<Integer> list = new ArrayList<>();

    static void f(int start, int end){
        if(start > end){
            return;
        }
        
        //System.out.println(end + " " + size);
        int startData = list.get(start);

        int startMax = start+1;
        for(int i=start+1;i<=end;i++){
            if(startData < list.get(i)){
                startMax = i;
                break;
            }
        }

        f(start+1, startMax-1);
        f(startMax, end);
        System.out.println(startData);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while (true){
            s=br.readLine();
            if(s==null||s.equals("")) break;
            list.add(Integer.parseInt(s));
        }

        f(0, list.size()-1);
        

        // for(int i=0;i<list.size();i++){
        //     System.out.println(list.get(i));
        // }
    }
}