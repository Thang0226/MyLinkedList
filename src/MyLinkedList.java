public class MyLinkedList<E> {
	private Node head;
	private int numNodes = 0;

	public class Node {
		private Node next;
		private Object data;

		public Node(Object data) {
			this.data = data;
		}

		public Object getData() {
			return data;
		}
	}

	public MyLinkedList() {}

	public MyLinkedList(Object data) {
		head = new Node(data);
		numNodes++;
	}

	public void add(int index, E element) {
		checkIndex(index);
		if (index == 0 || numNodes == 1) {
			addFirst(element);
		} else {
			Node current = head;
			for (int i = 1; i < index; i++) {
				current = current.next;
			}
			Node temp = current.next;
			current.next = new Node(element);
			current.next.next = temp;
		}
		numNodes++;
	}

	private void checkIndex(int index) {
		if (index < 0 || index > numNodes - 1) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNodes);
		}
	}

	public void addFirst(E element) {
		if (numNodes == 0) {
			head = new Node(element);
		} else {
			Node temp = head;
			head = new Node(element);
			head.next = temp;
		}
		numNodes++;
	}

	public void addLast(E element) {
		if (numNodes == 0) {
			head = new Node(element);
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(element);
		}
		numNodes++;
	}

	public E remove(int index) {
		checkIndex(index);
		if (numNodes == 1) {
			Node current = head;
			head = null;
			numNodes--;
			return (E) current.getData();
		}
		Node temp;
		Node current = head;
		if (index == 0) {
			temp = head;
			head = head.next;
		} else if (index == numNodes - 1) {
			while (current.next.next != null) {
				current = current.next;
			}
			temp = current.next;
			current.next = null;
		} else {
			for (int i = 1; i < index; i++) {
				current = current.next;
			}
			temp = current.next;
			current.next = temp.next;
		}
		numNodes--;
		return (E) temp.getData();
	}

	public boolean remove(E element) {
		if (numNodes == 0) {
			return false;
		}
		Node current = head;
		int index = 0;
		do {
			if (current.data.equals(element)) {
				remove(index);
				return true;
			}
			current = current.next;
			index++;
		} while (current != null);
		return false;
	}

	public E get(int index) {
		checkIndex(index);
		if (numNodes == 1) {
			return (E) head.data;
		}
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return (E) current.data;
	}

	public int size() {
		return numNodes;
	}

	public void printList() {
		Node current = head;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

	public boolean contains(E element) {
		if (numNodes == 0) {
			return false;
		}
		Node current = head;
		do {
			if (current.data.equals(element)) {
				return true;
			}
			current = current.next;
		} while (current != null);
		return false;
	}

	public int indexOf(E element) {
		int index = 0;
		if (numNodes == 0) {
			return -1;
		}
		Node current = head;
		do {
			if (current.data.equals(element)) {
				return index;
			}
			current = current.next;
			index++;
		} while (current != null);
		return -1;
	}
}
