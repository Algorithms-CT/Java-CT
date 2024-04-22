package Part3.BOJ5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5639_99hyeon {

    static StringBuilder sb = new StringBuilder();
    static class Node{
        Node left;
        Node right;
        int data;

        public Node(int data){
            this.data = data;
        }

        //트리에 노드 삽입
        void insert(int data){
            //삽입할 데이터가 그 기준 트리의 루트 노드보다 작을 경우
            if(data < this.data){
                if(this.left == null){  //루트 노드의 왼쪽 노드가 비어있을 경우
                    this.left =new Node(data);
                }else{  //루트 노드의 왼쪽 노드가 차있을 경우 다시 삽입과정 거침
                    this.left.insert(data);
                }

            }else{//삽입할 데이터가 그 기준 트리의 루트 노드보다 클 경우
                if(this.right == null){ //루트 노드의 오른쪽 노드가 비어있을 경우
                    this.right = new Node(data);
                }else{  //루트 노드의 오른쪽 노드가 차있을 경우 다시 삽입과정 거침
                    this.right.insert(data);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));

        while(true){
            String tmp = br.readLine();
            if(tmp == null || tmp.equals("")){
                break;
            }else{
                root.insert(Integer.parseInt(tmp));
            }
        }

        postOrder(root);
        System.out.println(sb);
    }

    //후위 순회 함수
    static void postOrder(Node node){
        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.data).append("\n");
    }
}
