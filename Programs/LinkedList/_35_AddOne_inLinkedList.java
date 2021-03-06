package LinkedList;

import java.util.List;
import java.util.Stack;

// add recursive and iterrative approach both

/*

Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.
You may assume the integer do not contain any leading zero, except the number 0 itself.
The digits are stored such that the most significant digit is at the head of the list.

Example:

Input: 1->2->3
Output: 1->2->4

Input 9 ---> 9 ---> 9 ---> 9
output:- 1 ---> 0 ---> 0 ---> 0 ---> 0
 */
public class _35_AddOne_inLinkedList {

	static int addWithCarry(Node head)
	{
		if(head==null)
			return 1;
		
		int res=head.val+addWithCarry(head.next);
		
		head.val=res%10;
		return res/10;
	}
	
	static Node addOne(Node head)
	{
		int carry= addWithCarry(head);
		
		if(carry>0)
		{
			Node newNode= new Node(carry);
			newNode.next=head;
			head=newNode;
		}
		return head;
	}
	
	public static Node plusOne(Node head) {
		
		if(head==null)
			return null;
					
        Stack<Node> stack = new Stack<Node>();
        Node node = head;
        while(node != null) {
            stack.push(node);
            node = node.next;
        }      
        int carry = 0;       
        Node finalNode=null;
        
        // if last node value is not 9 then add one in last node and return head
        if(stack.peek().val != 9) {
            stack.peek().val++;
            return head;
        } else {
        	// if it will come here means last node value is 9. 
        	stack.pop().val = 0;
            carry = 1;
            while(!stack.isEmpty()) {
                if(stack.peek().val != 9) {
                    stack.peek().val++;
                    return head;
                } else {
                    stack.pop().val = 0;
                }
            }          
        }        
        finalNode= new Node(carry);
        finalNode.next=head;
        return finalNode;
    }
	
	public static void main(String [] args)
	{
	  Node n1= new Node(9);
	  Node n2= new Node(9);
	  n1.next=n2;
	  Node n3= new Node(9);
	  n2.next=n3;
	  Node n4= new Node(9);
	  n3.next=n4;
	  
		_1_LinkedList list= new _1_LinkedList();
		list.printLinkedList(n1);
		
		Node addOne = addOne(n1);
		list.printLinkedList(addOne);
		
		Node finalNode=plusOne(addOne);
		list.printLinkedList(finalNode);
	 
	}
	
}
