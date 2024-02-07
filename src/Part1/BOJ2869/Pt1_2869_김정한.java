package Part1.BOJ2869;

import java.io.*;

public class Pt1_2869_김정한 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");

		int g = Integer.parseInt(input[2]) - Integer.parseInt(input[1]);
		int diff = Integer.parseInt(input[0]) - Integer.parseInt(input[1]);

		sb.append(g % diff == 0 ? g / diff : (g / diff) + 1);

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
