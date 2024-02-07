package Part1.BOJ2588;

import java.io.*;

public class Pt1_2588_김정한 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());

		int iter = b;
		while (iter != 0) {
			sb.append(a * (iter % 10)).append("\n");
			iter /= 10;
		}
		sb.append(a * b).append("\n");

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
