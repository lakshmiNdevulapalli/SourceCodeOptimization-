
public interface Stack<T>{
	
	public void push(T item);
	public T pop() throws StackUnderflowException;
	public T peek() throws StackUnderflowException;
	public boolean isEmpty();
	public String toString();
	
}
