
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 
public class ReorderList {
    public void reorderList(ListNode head) {
     if(head == null || head.next == null) return;
     else{
    	 ListNode slow = head, fast = head.next;
    	 while(fast != null && fast.next != null){
    		 slow = slow.next;
    		 fast = fast.next.next;
    	}
    	 //reverse
    	 slow.next = reverse(slow.next);
    	 //merge
    	 ListNode first = head, second = slow.next;
    	 //System.out.println(second.val);
    	 while(second != null){
    		 ListNode temp = second.next;
    		 second.next = first.next;
    		 first.next = second;
    		 first = second.next;
    		 if(temp == null && first != slow) second.next = null;
    		 second = temp;
    	 }
    	 if(first == slow) first.next = null;
     }
    }
    public ListNode reverse(ListNode head){
    	if(head == null) return null;
    	else if(head.next == null) return head;
    	else{
    		ListNode fisrt = head, second = head.next;
   	 		while(second != null){
   	 			ListNode temp = second.next;
   	 			second.next = fisrt;
   	 			fisrt = second;
   	 			second = temp;
   	 		}
   	 	head.next = null;
   	 	return fisrt;
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(4);
		head.next = l1;
		l1.next = l2;
		l2.next = l3;
		new ReorderList().reorderList(head);
		//ListNode first = new ReorderList().reverse(l2);
		//l1.next = first;
		
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
//		while(first != null){
//			System.out.println(first.val);
//			first = first.next;
//		}
	}

}
