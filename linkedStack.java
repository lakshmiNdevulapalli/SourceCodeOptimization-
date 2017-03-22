
public class LinkedStack<T> implements Stack<T> {
	private Node<T> top;
	
	public LinkedStack() {
		top = null;
	}
	
	@Override
	public void push(T item) {
		top = new Node<T>(item, top);
	}

	@Override
	public T pop() throws StackUnderflowException{
		if(top != null) {
			Node<T> oldTop = top;
			top = top.getNext();
			return oldTop.getValue();
		} else {
			throw new StackUnderflowException("trying to pop from an empty stack\n");
		}
	}
	

	@Override
	public T peek() throws StackUnderflowException {
		if(top != null) {
			return top.getValue();
		} else {
			throw new StackUnderflowException("trying to peek from an empty stackn");
		}
	}

	
	public boolean isEmpty() {
		return top == null;
	}
	//method to modified the output information
	
	public String toString(){
		String stackString =" "; 
		Node<T> node;
		node =top;
		while (node != null) {
			
			//stack should the order starting from the top
			stackString =node.getValue() +" "+stackString+" ";			
			node =node.getNext();
			
 
		}
		return stackString;
	}
			
		
		
	
	
	@SuppressWarnings("hiding")
	private class Node<T> {
		private T value;
		private Node<T> next;
		public T getValue() {
			return value;
		}
		@SuppressWarnings("unused")
		public void setValue(T value) {
			this.value = value;
		}
		public Node<T> getNext() {
			return next;
		}
		@SuppressWarnings("unused")
		public void setNext(Node<T> next) {
			this.next = next;
		}
		public Node(T value, Node<T> next) {
			super();
			this.value = value;
			this.next = next;
		}

	}
}
	
	
	
