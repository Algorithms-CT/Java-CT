package Part4.BOJ2748;

import java.io.*;

public class B2748_jjeonghak {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		long l = 0, r = 1;
		for (int i = 2; i <= n; i++) {
			if (i % 2 == 0) {
				l = l + r;
			} else {
				r = l + r;
			}
		}
		sb.append(n % 2 == 0 ? l : r);

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
