import java.io.*;
import java.util.*;

//방향 배열?을 처음써본 문제였다. 처음엔 왜 쓰는지 몰라서 그냥 안썼는데 써보니깐 압도적인 편안함을 느꼈다.
public class B2178_samgashyeong {
    static int[][] arr; 
    static int[] dy = {0,0,-1,1};
    static int[] dx = {-1,1,0,0};
    static boolean[][] chk;
    static int n;
    static int m;
    static ArrayList<Integer> results = new ArrayList<>();
    static Queue<A> que = new LinkedList<>();
    static class A{
        int x;
        int y;
        int cnt;

        public A(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static void bfs(int curX, int curY){
        chk[curX][curY] = true;
        //System.out.println(curX + " " + curY);
        que.add(new A(curX, curY, 1));
        
        while(!que.isEmpty()){
            A curA = que.poll();

            if(curA.x == m &&  curA.y == n){
                results.add(curA.cnt);
            }
            for(int i=0;i<4;i++){
                int nxtX = curA.x+dx[i];
                int nxtY = curA.y+dy[i];
                
                //System.out.println(nxtX + " " + nxtY + " " + chk[nxtY][nxtX] + " " + arr[nxtY][nxtX] +  " ");
                if(1<=nxtX && nxtX<=m && 1<=nxtY && nxtY<=n){
                    //System.out.println("함수 작동");
                    if(!chk[nxtY][nxtX] && arr[nxtY][nxtX] == 1){
                        chk[nxtY][nxtX] = true;
                        que.add(new A(nxtX, nxtY, curA.cnt+1));
                    }
                }
            }
            //System.out.println(que);
        }
    } 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+2][m+2];
        chk = new boolean[n+2][m+2];


    
        for(int i=1;i<=n;i++){
            String in = br.readLine();
            
            for(int j=1;j<=in.length();j++){
                arr[i][j] = Integer.parseInt(String.valueOf(in.charAt(j-1)));
                chk[i][j] = false;
            }
        }

        bfs(1,1);

        System.out.println(results.get(0));
    }
}