public class MyLinkedListTest {
	public static void main(String[] args) {
		// Test case 1: Creating a linked list with an initial element
		MyLinkedList<Integer> list = new MyLinkedList<>(10);
		System.out.println("Initial element: " + list.get(0)); // Expected: 10

		// Test case 2: Adding elements to the list
		list.addLast(20);
		list.addLast(30);
		list.addFirst(5);
		list.add(2, 15); // List: 5, 10, 15, 20, 30

		System.out.println("\nList after adding elements:");
		list.printList(); // Expected: 5, 10, 15, 20, 30

		// Test case 3: Removing elements by index
		list.remove(2); // Removes 15
		System.out.println("\nList after removing element at index 2:");
		list.printList(); // Expected: 5, 10, 20, 30

		// Test case 4: Removing element by value
		boolean removed = list.remove(Integer.valueOf(20));
		System.out.println("\nRemoved 20: " + removed); // Expected: true
		list.printList(); // Expected: 5, 10, 30

		// Test case 5: Get element by index
		int value = list.get(1);
		System.out.println("\nElement at index 1: " + value); // Expected: 10

		// Test case 6: Check size of the list
		int size = list.size();
		System.out.println("\nSize of the list: " + size); // Expected: 3

		// Test case 7: Check if list contains certain elements
		boolean contains10 = list.contains(10);
		boolean contains50 = list.contains(50);
		System.out.println("\nList contains 10: " + contains10); // Expected: true
		System.out.println("List contains 50: " + contains50); // Expected: false

		// Test case 8: Check index of an element
		int indexOf30 = list.indexOf(30);
		int indexOf50 = list.indexOf(50);
		System.out.println("\nIndex of 30: " + indexOf30); // Expected: 2
		System.out.println("Index of 50: " + indexOf50); // Expected: -1
	}
}
