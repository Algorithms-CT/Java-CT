package Part3.BOJ3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3055_llocr {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static String[][] arr;
    static boolean[][] visitedWater;
    static boolean[][] visitedDochi;
    static int r, c, res = -1;
    static Queue<int[]> waterQueue = new LinkedList<>();
    static Queue<int[]> dochiQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new String[r][c];
        visitedWater = new boolean[r][c];
        visitedDochi = new boolean[r][c];
        int[] answer = new int[2];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = s.substring(j, j + 1);

                if (arr[i][j].equals("*")) {
                    waterQueue.add(new int[]{i, j});
                    visitedWater[i][j] = true;
                } else if (arr[i][j].equals("S")) {
                    dochiQueue.add(new int[]{i, j, 0});
                    visitedDochi[i][j] = true;
                }
            }
        }

        BFS();

        System.out.println(res == -1 ? "KAKTUS" : res);

    }

    private static void BFS() {
        while (true) {
            int size = waterQueue.size();

            for (int t = 0; t < size; t++) {
                int[] waterNow = waterQueue.poll();

                for (int i = 0; i < 4; i++) {
                    int x = waterNow[0] + dx[i];
                    int y = waterNow[1] + dy[i];

                    if (x < 0 || y < 0 || x > r - 1 || y > c - 1) continue;
                    if (visitedWater[x][y]) continue;

                    if (arr[x][y].equals(".")) {
                        visitedWater[x][y] = true;
                        waterQueue.add(new int[]{x, y});
                    }
                }
            }

            size = dochiQueue.size();
            if (size == 0) break;
            for (int t = 0; t < size; t++) {
                int[] dochiNow = dochiQueue.poll();
                int move = dochiNow[2];

                for (int i = 0; i < 4; i++) {
                    int x = dochiNow[0] + dx[i];
                    int y = dochiNow[1] + dy[i];

                    if (x < 0 || y < 0 || x > r - 1 || y > c - 1) continue;
                    if (visitedDochi[x][y]) continue;

                    if (arr[x][y].equals("D")) {
                        res = move + 1;
                        return;
                    }

                    if (arr[x][y].equals(".") && !visitedWater[x][y]) {
                        visitedDochi[x][y] = true;
                        dochiQueue.add(new int[]{x, y, move + 1});
                    }
                }
            }
        }
    }
}

/*
* 다른 테스트 코드는 다 잘 돌아가는데 "KAKTUS"가 나와야 할 부분에서 안 나와서,, 왜 이게 안 나올까,, 했더니
* 각 턴마다 size에 맞게 queue가 돌아야 하는데 그냥 마구잡이로 돌다보니,, 제대로 문제가 안 풀렸던 거였다!!
* 그걸 고쳐주니 아주 거짓말처럼 코드가 잘 돌아감!!
* BFS 쉽지만 어렵구나,, 정답비율 33%,, 쉽지 않구나,,!
* */
