import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


//dp는 역시나 어렵다... 계속 문제를 많이 풀면서 부딪혀 볼 수 밖에 없을거 같다.
class Item {
    int weight;
    int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class B12865_samgashyeong {
    static ArrayList<Item> items;
    static int[][] dp;
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        items = new ArrayList<>();
        dp = new int[n+1][k+1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            items.add(new Item(weight, value));
        }

        for (int i = 1; i <= n; i++) {
            Item item = items.get(i - 1);
            for (int w = 1; w <= k; w++) {
                if (item.weight <= w) {
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-item.weight] + item.value);
                } else {
                    dp[i][w] = dp[i-1][w];
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}