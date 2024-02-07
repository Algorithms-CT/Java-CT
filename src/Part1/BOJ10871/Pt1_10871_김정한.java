package Part1.BOJ10871;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Pt1_10871_김정한 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		int x = Integer.parseInt(input[1]);

		List<Integer> arr = Arrays.stream(br.readLine().split(" "))
				.map(Integer::parseInt)
				.filter(i -> i < x)
				.collect(Collectors.toList());

		arr.forEach(i -> sb.append(i).append(" "));

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}

