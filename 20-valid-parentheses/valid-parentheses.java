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


    public boolean isValid(String s) {

        int len = s.length();

        CharStack stack = new CharStack(len);

        for (int i = 0; i < len; i++) {

            char current = s.charAt(i);

            // Opening bracket
            if (current == '(' || current == '[' || current == '{') {

                stack.push(current);

            }

            // Closing )
            else if (current == ')') {

                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }

                stack.pop();
            }

            // Closing }
            else if (current == '}') {

                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                }

                stack.pop();
            }

            // Closing ]
            else if (current == ']') {

                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}