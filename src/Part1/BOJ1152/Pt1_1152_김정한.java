package Part1.BOJ1152;

import java.io.*;

public class Pt1_1152_김정한 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String input = br.readLine().trim();
		int ans = input.isBlank() ? 0 : input.split(" ").length;

		sb.append(ans);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
