package assignment;

public class ExpressionEvaluator implements ExpressionEvaluatorInterface {
	
	public static int precedence(char operator) {
		if (operator == '+' || operator == '-') {
			return 1;
		}else {
			return 2;
		}
	}

	@Override
	public String infixToPostfix(String infix) {
		// TODO Auto-generated method stub
		Stack<Character> operators = new Stack<>();
		StringBuilder output = new StringBuilder();
		
		for(int i = 0; i < infix.length(); i++) {
			char current = infix.charAt(i);
			if(Character.isWhitespace(current)) {
				continue;
			}
			if(Character.isDigit(current)) {
				output.append(current).append(" ");
			}
			if(current == '(') {
				operators.push(current);
			}
			if(current == ')') {
				while(operators.peek() != '(') {
					output.append(operators.pop()).append(" ");
				}
				operators.pop();
			}
			if(current == '+' || current == '-' || current == '*' || current == '/') {
				while(!operators.isEmpty() && operators.peek() != '(') {
					if(precedence(operators.peek()) >= precedence(current)) {
						output.append(operators.pop()).append(" ");
					}else {
						break;
					}
				}
				
				operators.push(current);
			}
		}
		while (!operators.isEmpty()) {
			output.append(operators.pop()).append(" ");
		}
		
		return output.toString();
	}

	@Override
	public int evaluatePostfix(String postfix) {
		// TODO Auto-generated method stub
		Stack<Integer> numbers = new Stack<>();
		
		for (char current : postfix.toCharArray()) {
			if(Character.isWhitespace(current)) {
				continue;
			}
			if(Character.isDigit(current)) {
				numbers.push(current - '0');
			}else {
				int op2 = numbers.pop();
				int op1 = numbers.pop();
				if(current == '+') {
					numbers.push(op1 + op2);
				}
				else if(current == '-') {
					numbers.push(op1 - op2);
				}
				else if(current == '*') {
					numbers.push(op1 * op2);
				}
				else if(current == '/') {
					numbers.push(op1 / op2);
				}
			}
		}
		return numbers.pop();
	}
}
