package Part3.BOJ5639;

import java.io.*;
import java.util.Objects;

public class B5639_jjeonghak {

	private static Node root;
	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while(true) {
			String input = br.readLine();
			if (Objects.isNull(input) || input.isBlank()) {
				break;
			} else if (Objects.isNull(root)) {
				root = new Node(Integer.parseInt(input));
			} else {
				dfs(root, Integer.parseInt(input));
			}
		}
		postorder(root);

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static void dfs(Node node, int index) {
		if (node.index < index) {
			if (Objects.isNull(node.right)) {
				node.right = new Node(index);
			} else {
				dfs(node.right, index);
			}
		} else {
			if (Objects.isNull(node.left)) {
				node.left = new Node(index);
			} else {
				dfs(node.left, index);
			}
		}
	}

	private static void postorder(Node node) {
		if (!Objects.isNull(node.left)) {
			postorder(node.left);
		}
		if (!Objects.isNull(node.right)) {
			postorder(node.right);
		}
		sb.append(node.index).append("\n");
	}

	private static class Node {
		int index;
		Node left;
		Node right;

		public Node(int index) {
			this.index = index;
		}
	}

}
