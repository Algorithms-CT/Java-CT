package Part1.BOJ10872;

import java.io.*;

public class Pt1_10872_김정한 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		long ans = 1;

		while (n != 0) {
			ans *= n--;
		}

		sb.append(ans);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
