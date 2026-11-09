package assignment;

public class Stack<T> implements StackInterface<T> {
	private Object[] elem;
	private int top;
	
	public Stack() {
		elem = new Object[10];
		top = 0;
	}

	@Override
	public void push(T item) {
		// TODO Auto-generated method stub
		if(top == elem.length) {
			Object[] newObj = new Object[elem.length *2];
			for(int i = 0; i < top; i++) {
				newObj[i] = elem[i];
			}
			elem = newObj;
		}
		elem[top] = item;
		top++;
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		if(top > 0) {
			top--;
			T item = (T) elem[top];
			elem[top] = null;
			return item;
		}else {
			return null;
		}
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		if(top != 0) {
			return (T) elem[top-1];
		}else {
			return null;
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return top;
	}

}
