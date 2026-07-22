class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens){
            if(!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")){
                stack.push(Integer.parseInt(token));
            }
            else{
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num2 + num1);
                        break;
                    case "-":
                        stack.push(num2 - num1);
                        break;
                    case "*":
                        stack.push(num2 * num1);
                        break;
                    default:
                        stack.push(num2 / num1);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
