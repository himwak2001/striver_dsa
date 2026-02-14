public class DLL {
    static class Node {
        public int data;
        public Node next;
        public Node prev;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Converts an array of integers into a doubly linked list (DLL).
     * 
     * @param arr the array of integers to be converted into a doubly linked list
     * @return the head node of the newly created doubly linked list
     */
    public static Node convertArray2Dll(int[] arr) {
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    /**
     * Traverses a doubly linked list starting from the given head node and prints
     * the data of each node.
     *
     * @param head The head node of the doubly linked list to traverse.
     */
    public static void traverseDLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    /**
     * Deletes the head node of a doubly linked list.
     *
     * @param head The head node of the doubly linked list.
     * @return The new head node after deletion. Returns {@code null} if the list is
     *         empty or has only one node.
     */
    public static Node deleteHead(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node prev = head;
        head = head.next;

        head.prev = null;
        prev.next = null;

        return head;
    }

    /**
     * Deletes the tail (last) node from a doubly linked list.
     *
     * @param head the head node of the doubly linked list
     * @return the head of the modified list, or null if the list becomes empty
     *
     *         <p>
     *         Time Complexity: O(n) where n is the number of nodes in the list
     *         <p>
     *         Space Complexity: O(1)
     */
    public static Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        Node prevNode = tail.prev;
        prevNode.next = null;

        return head;
    }

    /**
     * Deletes the kth node from a doubly linked list.
     *
     * @param head the head of the doubly linked list
     * @param k    the position of the node to delete (1-indexed)
     * @return the head of the modified doubly linked list, or null if the list
     *         becomes empty
     *
     *         <p>
     *         Time Complexity: O(k) - where k is the position of the node to delete
     *         <p>
     *         Space Complexity: O(1) - constant extra space used
     */
    public static Node deleteKthNode(Node head, int k) {
        if (head == null) {
            return null;
        }
        int cnt = 0;
        Node kNode = head;
        while (kNode != null) {
            cnt += 1;
            if (cnt == k) {
                break;
            }
            kNode = kNode.next;
        }

        Node prevNode = kNode.prev;
        Node nextNode = kNode.next;

        if (prevNode == null && nextNode == null) {
            return null;
        } else if (prevNode == null) {
            return deleteHead(head);
        } else if (nextNode == null) {
            return deleteTail(head);
        }

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        return head;
    }

    /**
     * Deletes a node from a doubly linked list by updating the pointers of its
     * neighbors.
     * 
     * This method removes the given node from the linked list by:
     * - Linking the previous node to the next node
     * - Linking the next node back to the previous node
     * 
     * @param temp the node to be deleted from the doubly linked list
     */
    public static void deleteNode(Node temp) {
        Node prevNode = temp.prev;
        Node nextNode = temp.next;

        if (nextNode == null) {
            prevNode.next = null;
            return;
        }

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    /**
     * Inserts a new node with the given value before the current head of the doubly
     * linked list.
     * 
     * @param head the current head node of the doubly linked list
     * @param val  the value to be inserted in the new node
     * @return the new head node of the doubly linked list after insertion
     */
    public static Node insertBeforeHead(Node head, int val) {
        Node newHead = new Node(val, head, null);
        head.prev = newHead;
        return newHead;
    }

    /**
     * Inserts a new node with the given value immediately before the tail node
     * in a doubly linked list.
     *
     * @param head the head node of the doubly linked list
     * @param val  the value to be inserted
     * @return the head node of the doubly linked list (unchanged)
     */
    public static Node insertBeforeTail(Node head, int val) {
        if (head.next == null) {
            return insertBeforeHead(head, val);
        }

        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        Node prevNode = tail.prev;
        Node newNode = new Node(val, tail, prevNode);
        prevNode.next = newNode;
        tail.prev = newNode;

        return head;
    }

    /**
     * Inserts a new node with the given value before the kth node in a doubly
     * linked list.
     *
     * @param head the head node of the doubly linked list
     * @param val  the value to be inserted in the new node
     * @param k    the position before which the new node should be inserted
     *             (1-indexed)
     * @return the head node of the modified doubly linked list
     */
    public static Node insertBeforeKthNode(Node head, int val, int k) {
        if (head.next == null)
            return insertBeforeHead(head, val);

        int cnt = 0;
        Node temp = head;

        while (temp != null) {
            cnt += 1;
            if (cnt == k)
                break;
            temp = temp.next;
        }

        Node prevNode = temp.prev;
        Node newNode = new Node(val, temp, prevNode);
        prevNode.next = newNode;
        temp.prev = newNode;

        return head;
    }

    /**
     * Inserts a new node with the specified value immediately before the given node
     * in a doubly linked list.
     * 
     * @param temp the reference node before which the new node will be inserted
     * @param val  the value to be stored in the new node
     */
    public static void insertBeforeNode(Node temp, int val) {
        Node prevNode = temp.prev;
        Node newNode = new Node(val, temp, prevNode);
        prevNode.next = newNode;
        temp.prev = newNode;
    }

    /**
     * Reverses a doubly linked list by swapping the previous and next pointers of
     * each node.
     * 
     * @param head the head node of the doubly linked list to be reversed
     * @return the new head node of the reversed doubly linked list, or null if the
     *         input list is empty
     * 
     * @throws NullPointerException if head is null (handled gracefully by returning
     *                              null)
     * 
     * @implNote This method reverses the list in-place by iterating through each
     *           node and swapping
     *           its prev and next pointers. The time complexity is O(n) where n is
     *           the number of nodes,
     *           and the space complexity is O(1) as only a constant amount of extra
     *           space is used.
     */
    public static Node reverseDll(Node head) {
        if (head == null || head.next == null)
            return head;
        Node last = null, current = head;
        while (current != null) {
            last = current.prev;
            current.prev = current.next;
            current.next = last;
            current = current.prev;
        }
        head = last.prev;
        return head;
    }

    /**
     * Deletes all occurrences of a specified value from a doubly linked list.
     * 
     * @param head the head node of the doubly linked list
     * @param k the value to be deleted from the list
     * @return the head node of the modified doubly linked list after deletion,
     *         or null if the list becomes empty
     */
    public static Node deleteAllOccurrences(Node head, int k) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                if (temp == head) {
                    head = head.next;
                }
                Node prevNode = temp.prev;
                Node nextNode = temp.next;

                if (prevNode != null)
                    prevNode.next = nextNode;
                if (nextNode != null)
                    nextNode.prev = prevNode;

                temp = nextNode;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 3, 4 };
        DLL.Node head = DLL.convertArray2Dll(arr);
        DLL.traverseDLL(head);
        System.out.println();
        // head = deleteHead(head);
        // head = deleteTail(head);
        // head = deleteKthNode(head, 4);
        // deleteNode(head.next.next);
        // head = insertBeforeHead(head, 10);
        // head = insertBeforeTail(head, 5);
        // head = insertBeforeKthNode(head, 9, 3);
        // insertBeforeNode(head.next, 10);
        head = DLL.reverseDll(head);
        DLL.traverseDLL(head);
    }
}