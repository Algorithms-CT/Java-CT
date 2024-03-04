package Part2.BOJ16564;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B16564_limjunhyuk97 {

    public static int MAX_LEVEL = 2000000000;

    public static int N, K;

    public static int arr[];

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String inputs[];

    public static boolean isPromising(BigInteger mid) {
        BigInteger remainer = BigInteger.valueOf(K);
        for(int i=0; i<N; ++i) {
            if(mid.compareTo(BigInteger.valueOf(arr[i]))>=0) {
                remainer = remainer.subtract(mid.subtract(BigInteger.valueOf(arr[i])));
            }
            if(remainer.compareTo(BigInteger.ZERO) < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        K = Integer.parseInt(inputs[1]);

        arr = new int[N];
        for(int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        BigInteger l=BigInteger.ZERO, r=BigInteger.valueOf(MAX_LEVEL), m;

        while(l.compareTo(r) <= 0) {
            m=(l.add(r)).shiftRight(1);
            if(isPromising(m)) {
                l=m.add(BigInteger.ONE);
            }
            else {
                r=m.subtract(BigInteger.ONE);
            }
        }

        System.out.println(r);
    }

}
