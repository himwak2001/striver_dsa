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
    public static Node removeHead(Node head){
        if(head == null) return head;
        head = head.next;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 4, 8 };
        Node ans = convertArray2LL(arr);
        Node rmHead = removeHead(ans);
        traverseLL(rmHead);
        // System.out.println(llLength(ans));
    }
}