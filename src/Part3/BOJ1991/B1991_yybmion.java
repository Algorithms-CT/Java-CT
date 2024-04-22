//package Part3.BOJ1991;
//
//import java.io.*;
//
//
//public class B1991_yybmion {
//    static int N;
//    static Node[] arr;
//    static StringBuilder sb = new StringBuilder();
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine()); //7
//        arr = new Node[N];
//        char start = 'A';
//
//        for(int i=0;i<N;i++){
//            arr[i] = new Node(start++);     // 어짜피 모든 노드는 루트가 될 수 있기에 일단 루트는 다 넣어둔다 배열에
//        }                                   // 그 이후에 left right 값있는지 없는지 확인하며 넣어줄거 넣어준다.
//
//        for(int i=0;i<N;i++){
//            char n,l,r;
//            String line = br.readLine();
//
//            n = line.charAt(0);         // 이미 Node에는 루트는 들어가 있다 그 왼쪽 오른쪽 값을 추가하냐 마냐이다.
//            l = line.charAt(2);
//            r = line.charAt(4);
//
//            if(l !='.'){                // 그걸 여기서 . 가 아니라면 왼쪽, 오른쪽 입력되었던 값을 넣어준다.
//                arr[n-'A'].left = arr[l-'A'];
//            }
//            if(r != '.'){
//                arr[n-'A'].right = arr[r-'A'];
//            }
//        }
//
//        preOrder(arr[0]);               // 어쩃든 여기까지 오면 데이터가 들어간 트리가 완성되었다. 이후에는 전위 후위 중위를 구현해주면 된다.
//        sb.append("\n");
//        inOrder(arr[0]);
//        sb.append("\n");
//        postOrder(arr[0]);
//        sb.append("\n");
//
//        System.out.println(sb.toString());
//
//    }
//
//    static void preOrder(Node node){
//        sb.append(node.data);
//        if(node.left != null) preOrder(node.left);
//        if(node.right != null) preOrder(node.right);
//    }
//
//    static void inOrder(Node node){
//        if(node.left != null) inOrder(node.left);
//        sb.append(node.data);
//        if(node.right != null) inOrder(node.right);
//    }
//
//    static void postOrder(Node node){
//        if(node.left != null) postOrder(node.left);
//        if(node.right != null) postOrder(node.right);
//        sb.append(node.data);
//    }
//}
//
////class Node{
////    char data;
////    Node left;
////    Node right;
////
////    public Node(char data) {        // 왼쪽 오른쪽에 어떤 값이 올지는 Node생성때는 알 수 없으므로 Node값만 넣어준다.
////        this.data = data;
////    }
////}
//
///**
// * 트리에서의 전위,중위,후위 구현 문제이다.
// * 제대로된 개념이 잡혀있지 않고 트리를 구현하려니 어려웠다.
// * 따라서 이번에 트리 개념을 정확히 알고 직접 구현하며 이해하기 위해
// * 답을 보며 구현해 보았다.
// *
// * https://dos-soles.tistory.com/15
// */
