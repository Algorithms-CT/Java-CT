package Part1.BOJ2753;

import java.io.*;

public class Pt1_2753_김정한 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		sb.append(check(Integer.parseInt(br.readLine())));

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static int check(int n) {
		return (n % 4 == 0 && n % 100 != 0) || (n % 400 == 0) ? 1 : 0;
	}

}
