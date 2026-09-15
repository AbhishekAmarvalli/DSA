class Solution {
    class CharStack {
        private char[] arr;
        private int top;
        public CharStack(int capacity) {
            arr = new char[capacity];
            top = -1;
        }
        public void push(char x) {
            if (isFull()) {
                throw new RuntimeException("Stack is full");
            }
            arr[++top] = x;
        }
        public char pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return arr[top--];
        }
        public char peek() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return arr[top];
        }
        public boolean isEmpty() {
            return top == -1;
        }
        public boolean isFull() {
            return top == arr.length - 1;
        }
    }
    public String removeDuplicates(String s) {
        int len = s.length();
        CharStack stack = new CharStack(len);
        for (int i = 0; i < len; i++) {
            char current = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == current) {
                stack.pop();
            } else {
                stack.push(current);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= stack.top; i++) {
            result.append(stack.arr[i]);
        }
        return result.toString();
    }
}