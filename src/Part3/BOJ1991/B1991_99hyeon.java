package Part3.BOJ1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1991_99hyeon {
    static int N;
    static Node root = new Node('A', null, null);   //트리는 항상 A부터 시작하므로
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char val = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            setNode(root, val, left, right);
        }
        br.close();

        preOrder(root);
        sb.append("\n");
        inOrder(root);
        sb.append("\n");
        postOrder(root);
        System.out.println(sb);

    }

    //전위 순회 이므로 맨 처음에 루트 노드를 기록
    public static void preOrder(Node n) {
        if (n == null)
            return;
        sb.append(n.val);
        preOrder(n.left);
        preOrder(n.right);
    }

    //중위 순회이므로 중간에 루트노드 기록
    public static void inOrder(Node n) {
        if (n == null)
            return;
        inOrder(n.left);
        sb.append(n.val);
        inOrder(n.right);
    }

    //후위 순회이므로 마지막에 루트노드 기록
    public static void postOrder(Node n) {
        if (n == null)
            return;
        postOrder(n.left);
        postOrder(n.right);
        sb.append(n.val);
    }

    //노드 세팅
    public static void setNode(Node par, char root, char left, char right) {

        //par 노드가 루트 노드일 경우
        if (par.val == root) {
            par.left = left == '.' ? null : new Node(left, null, null);
            par.right = right == '.' ? null : new Node(right, null, null);
        } else { //루트 노드가 아닐 경우
            if (par.left != null)
                setNode(par.left, root, left, right);
            if (par.right != null)
                setNode(par.right, root, left, right);
        }
    }
}

class Node {
    char val;
    Node left, right;

    Node(char val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

