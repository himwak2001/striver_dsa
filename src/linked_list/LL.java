public class LL {

    static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * method to convert array into LinkedList
     * TC - O(n)
     * SC - O(1)
     */
    public static Node convertArray2LL(int[] arr) {
        Node head = new Node(arr[0], null);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    /**
     * method to traverse the LinkedList
     * TC - O(n)
     * SC - O(1)
     */
    public static void traverseLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    /**
     * method to find the length of LinkedList
     * TC - O(n)
     * SC - O(1)
     */
    public static int llLength(Node head) {
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }

    /**
     * method to delete the head of the LinkedList
     * 
     */
    public static Node removeHead(Node head) {
        if (head == null)
            return head;
        head = head.next;
        return head;
    }

    /**
     * method to arrange linkedlist in odd & even
     * TC - O(n)
     * SC - O(1)
     */
    public static Node segregateEvenOdd(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node odd = head, even = head.next, evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = even.next;

            even.next = odd.next;
            even = odd.next;
        }
        odd.next = evenHead;
        return head;
    }

    /**
     * Adds two numbers represented as linked lists and returns their sum as a
     * linked list.
     * 
     * Each node in the input linked lists contains a single digit, and the digits
     * are stored
     * in reverse order. For example, the number 342 is represented as 2 -> 4 -> 3.
     * 
     * @param l1 the first linked list representing a number in reverse order
     * @param l2 the second linked list representing a number in reverse order
     * @return a new linked list representing the sum of the two input numbers in
     *         reverse order
     * 
     * @time O(max(m, n)) , where m and n are the lengths of l1 and l2 respectively
     * @space O(max(m, n)) for the result linked list
     */
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node dummyNode = new Node(-1);
        Node curr = dummyNode;
        Node temp1 = l1, temp2 = l2;
        int carry = 0;
        while (temp1 != null || temp2 != null) {
            int val1 = temp1 == null ? 0 : temp1.data;
            int val2 = temp2 == null ? 0 : temp2.data;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            Node newNode = new Node(sum % 10);
            curr.next = newNode;
            curr = curr.next;

            if (temp1 != null)
                temp1 = temp1.next;
            if (temp2 != null)
                temp2 = temp2.next;
        }
        if (carry > 0) {
            curr.next = new Node(carry);
        }
        return dummyNode.next;
    }

    /**
     * Segregates a linked list containing nodes with values 0, 1, and 2 into three
     * groups.
     * Rearranges the list so that all nodes with value 0 come first, followed by
     * nodes with value 1,
     * and finally nodes with value 2, while maintaining the relative order within
     * each group.
     *
     * @param head the head node of the linked list to be segregated
     * @return the head node of the segregated linked list
     *
     *         Time Complexity: O(n) where n is the number of nodes in the linked
     *         list
     *         Space Complexity: O(1) excluding the input list
     */
    public static Node segregate(Node head) {
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);
        Node temp = head, zero = zeroHead, one = oneHead, two = twoHead;
        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        zero.next = oneHead.next == null ? twoHead.next : oneHead.next;
        one.next = twoHead.next;
        two.next = null;
        return zeroHead.next;
    }

    /**
     * Removes the nth node from the end of a linked list and returns the head of
     * the modified list.
     * 
     * This method uses the two-pointer (fast and slow) approach to efficiently find
     * and remove
     * the target node in a single pass through the list.
     * 
     * @param head the head node of the linked list
     * @param n    the position from the end of the list (1-indexed) of the node to
     *             be removed
     * @return the head node of the linked list after removing the nth node from the
     *         end.
     *         If the head node itself is removed, returns the next node; otherwise
     *         returns the original head.
     * 
     *         Time Complexity: O(L) where L is the length of the linked list
     *         Space Complexity: O(1) - only using pointers, no extra space
     */
    public static Node removeNthFromEnd(Node head, int n) {
        Node slow = head, fast = head, prev = null;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null)
            return head.next;

        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = slow.next;
        return head;
    }

    /**
     * Reverses a linked list in-place.
     * 
     * This method reverses the direction of all links in the linked list,
     * making the last node the new head and the original head the new tail.
     * The reversal is performed iteratively using three pointers to track
     * the current, previous, and next nodes.
     * 
     * @param head the head node of the linked list to be reversed
     * @return the new head of the reversed linked list, or null if the input is
     *         null
     * 
     * @time Complexity: O(n), where n is the number of nodes in the linked list
     * @space Complexity: O(1), only uses a constant amount of extra space
     */
    public static Node reverseList(Node head) {
        if (head == null || head.next == null)
            return head;
        Node curr = head, prev = null, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * Checks whether a linked list is a palindrome.
     * 
     * This method uses the two-pointer (tortoise and hare) approach to find the
     * middle
     * of the linked list, reverses the second half, and then compares both halves
     * to
     * determine if the list reads the same forwards and backwards.
     * 
     * Time Complexity: O(n) where n is the number of nodes in the linked list
     * Space Complexity: O(1) as only pointers are used (excluding recursion stack
     * if any)
     * 
     * @param head the head node of the linked list to check
     * @return true if the linked list is a palindrome, false otherwise
     * @note The linked list is restored to its original state after the check
     */
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null)
            return true;

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node newHead = reverseList(slow);
        Node temp1 = head, temp2 = newHead;
        while (temp2 != null) {
            if (temp1.data != temp2.data) {
                reverseList(newHead);
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        reverseList(newHead);
        return true;
    }

    /**
     * Helper method to increment a number represented as a linked list by 1.
     * This method recursively traverses to the end of the linked list, then adds
     * the carry
     * value back through each node while incrementing the data.
     *
     * @param temp the current node being processed in the linked list
     * @return the carry value to be added to the previous node (0 or 1)
     */
    private static int helper(Node temp) {
        if (temp == null) {
            return 1;
        }

        int carry = helper(temp.next);
        int sum = temp.data + carry;
        temp.data = sum % 10;
        return sum / 10;
    }

    /**
     * Adds one to the number represented by the linked list.
     * 
     * @param head the head node of the linked list representing a number
     * @return the head node of the modified linked list with one added to it.
     *         If a carry is generated at the most significant digit, a new node
     *         is created and prepended to the list.
     */
    public static Node addOne(Node head) {
        int carry = helper(head);
        if (carry > 0) {
            Node newNode = new Node(carry);
            newNode.next = head;
            return newNode;
        }
        return head;
    }

    /**
     * Finds the intersection point of two linked lists.
     * 
     * This method uses the two-pointer technique to find the node where two linked lists
     * intersect. It works by traversing both lists alternately - when a pointer reaches the
     * end of one list, it starts from the beginning of the other list. If the lists intersect,
     * both pointers will eventually meet at the intersection node. If they don't intersect,
     * both pointers will reach null simultaneously.
     * 
     * Time Complexity: O(m + n) where m and n are the lengths of the two lists
     * Space Complexity: O(1) - only uses two pointers
     * 
     * @param head1 the head node of the first linked list
     * @param head2 the head node of the second linked list
     * @return the intersection node if the lists intersect, null otherwise
     */
    public static Node intersectPoint(Node head1, Node head2) {
        if (head1 == null || head2 == null)
            return null;

        Node t1 = head1;
        Node t2 = head2;

        while (t1 != t2) {
            t1 = (t1 == null) ? head2 : t1.next;
            t2 = (t2 == null) ? head1 : t2.next;
        }

        return t1;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 1, 8, 5 };
        int[] arr2 = { 5, 6, 1, 8, 5 };
        Node head = convertArray2LL(arr);
        Node head2 = convertArray2LL(arr2);
        // Node ans = segregate(head1);
        // Node head = segregateEvenOdd(ans);
        // Node ans = removeNthFromEnd(head, 2);
        // Node result = reverseList(head);
        // Node result = addOne(head);
        // traverseLL(result);
        System.out.println(intersectPoint(head, head2).data);
        // System.out.println(llLength(ans));
        // System.out.println(isPalindrome(head));
    }
}