package study.queue;

public class MyLinkedList {
    private Node start;

    private static class Node {
        private int data;
        private Node link;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node link) {
            this.data = data;
            this.link = link;
        }
    }

    // add: 제일 뒤에 data 추가
    public void add(int data) {
        // 1. start == null (LinkedList가 비어있을 때 이다)
        if(start == null) start = new Node(data);
        // 2. 비어있지 않으면, link가 null인 노드가 나올때까지
        //                (뒤에 다른 노드가 없는 노드를 찾을 때 까지)
        else {
            Node head = start;
            while (head.link != null) {
                head = head.link;
            }

            // while이 끝났을 때 , head.link == null이다. (마지막 노드)
            // (뒤에 다른 노드가 없는 노드를 찾았을 때)
            // 새로운 노드를 할당 해주면 된다.
            head.link = new Node(data);
        }
    }

    // remove: idx번째 데이터를 회수 및 노드 제거
    public int remove(int idx) {
        // 맨 앞노드를 삭제할 때
        if(idx == 0) {
            int value = start.data;
            start = start.link;
            return value;
        }

        int i = 0;
        Node head = start;
        Node prev = start;

        while(i < idx) {
            prev = head;
            head = head.link;
            i++;
        }
        // <삭제할 노드>의 <앞쪽 노드>와 <뒤쪽 노드>를 연결시켜주는 작업.
        prev.link =  head.link;
        return head.data;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node head = start;
        while(head != null) {
            builder.append(head.data);
            // .link != null : 마지막 노드가 아니라면
            if(head.link !=  null) {
                builder.append(", ");
            }
            head = head.link;
        }
        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList);

        System.out.println(linkedList.remove(0)); // 기대값: 1
        System.out.println(linkedList.remove(1)); // 기대값: 3
        System.out.println(linkedList.remove(0)); // 기대값: 2
    }
}
