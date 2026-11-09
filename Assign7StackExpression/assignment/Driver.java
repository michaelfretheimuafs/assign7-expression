package assignment;

public class Driver {
    public static void main(String[] args) {
    	
    	ExpressionEvaluator test = new ExpressionEvaluator();
    	
    	String infix = "(3 + 5) * 2";
    	System.out.println(infix);
    	
    	String postfix = test.infixToPostfix(infix);
    	System.out.println(postfix);
    	
    	int result = test.evaluatePostfix(postfix);
    	System.out.println(result);


    }
}

