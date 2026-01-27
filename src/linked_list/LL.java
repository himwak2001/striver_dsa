public class LL {

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

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 2, 5, 6 };
        Node ans = convertArray2LL(arr);
        Node head = segregateEvenOdd(ans);
        traverseLL(head);
        // System.out.println(llLength(ans));
    }
}