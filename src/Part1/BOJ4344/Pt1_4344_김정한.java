package Part1.BOJ4344;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Pt1_4344_김정한 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			List<Integer> input = Arrays.stream(br.readLine().split(" "))
					.map(Integer::parseInt)
					.collect(Collectors.toList());

			int n = input.remove(0);
			double avg = (double) input.stream().reduce(0, Integer::sum) / n;
			double ans = input.stream().filter(s -> avg < s).count() * 100d / n;
			sb.append(String.format("%.3f%%\n", ans));
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
