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
     * Segregates a linked list containing nodes with values 0, 1, and 2 into three groups.
     * Rearranges the list so that all nodes with value 0 come first, followed by nodes with value 1,
     * and finally nodes with value 2, while maintaining the relative order within each group.
     *
     * @param head the head node of the linked list to be segregated
     * @return the head node of the segregated linked list
     *
     * Time Complexity: O(n) where n is the number of nodes in the linked list
     * Space Complexity: O(1) excluding the input list
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

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 2, 1, 2, 0, 2, 2 };
        // int[] arr2 = { 4, 5, 9, 9 };
        Node head1 = convertArray2LL(arr1);
        // Node head2 = convertArray2LL(arr2);
        Node ans = segregate(head1);
        // Node head = segregateEvenOdd(ans);

        traverseLL(ans);
        // System.out.println(llLength(ans));
    }
}