package study.stack;

public class MyStack {
    // 스택에 실제 데이터가 저장되는 곳
    private final int[] arr = new int[16];
    // 현재 스택의 최고점을 파악하기 위한 top
    private int top = -1;

    public MyStack() {
    }

    // push(): 데이터를 Stack의 제일 위에 넣는 메소드
    public void push(int data) {
        // 0. arr가 가득 찼는지를 판단한다.
        if(arr.length - 1 == top) {
            throw new RuntimeException("stack is full");
        }
        // 1. top를 하나 증가시킨다.
        top++;
        // 2. arr[top]에 data를 할당한다.
        arr[top] = data;
    }

    // pop(): 데이터를 스택의 제일 위에서 회수하는 메소드
    public int pop() {
        // 0. arr가 비어있는지 판단한다.
        if(empty()) {
            throw new RuntimeException("stack is empty");
        }
        // 1. arr[top]의 값을 임시 저장한다.
        int temp = arr[top];
        // 2. top을 하나 감소시킨다.
        top--;
        // 3. 임시저장된 값을 반환한다.
        return temp;
    }

    // peek(): 스택의 값을 제거하지 않고 제일 위의 값을 반환한다.
    public int peek() {
        // 0. arr가 비었는지 판단한다.
        if(empty()) {
            throw new RuntimeException("stack is empty");
        }
        // 1. arr[top]의 값을 반환한다.
        return arr[top];
    }

    // empty(): 스택이 비어있는지 확인하는 메소드
    public boolean empty() {
        return top == -1 ? true : false;
    }

    public static void main(String[] args) {
        MyStack intStack = new MyStack();
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);

        System.out.println(intStack.pop());
        System.out.println(intStack.pop());
        System.out.println(intStack.empty());
        System.out.println(intStack.peek());
    }

}
