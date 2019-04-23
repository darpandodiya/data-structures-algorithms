package leetcode;

import java.util.Stack;

public class ValidParantheses {

    public boolean isValid(String s) {
        if(s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for(int i=0, n = s.length(); i < n; i++) {
            if(s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                stack.add(s.charAt(i));
            }
            else {
                if (stack.size() == 0) {
                    return false;
                }
                char popped = stack.pop();
                if( (popped == '{' && s.charAt(i) != '}')
                    || (popped == '[' && s.charAt(i) != ']')
                    || (popped == '(' && s.charAt(i) != ')')) {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }

    public boolean isValid2(String s) {
        if(s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for(int i=0, n = s.length(); i < n; i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.add(')');
                    break;
                case '{':
                    stack.add('}');
                    break;
                case '[':
                    stack.add(']');
                    break;

                default:
                    if(stack.isEmpty() || stack.pop() != s.charAt(i)) {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }



    public static void main(String[] args) {
        System.out.println(new ValidParantheses().isValid("(]"));
    }
}
