package assignment;

import java.util.*;

public class LinkedListPriorityQueueAccount {

	public static void main(String[] args) {
		
        Queue<account> q = new PriorityQueue<>();

        q.offer(new account("Shiv", 1776, 2190));
        q.offer(new account("Madhur", 7110, 2500));
        q.offer(new account("Nitish", 3321, 5001));
        q.offer(new account("Krish", 1889, 3228));

        System.out.println("peek:"+q.peek());
        System.out.println(q.size());

        System.out.println("poll:"+q.poll());
        System.out.println(q.size());

        System.out.println(q);

        
/************************************ Linked list implementation *********************/
        Queue<account> q1 = new LinkedList<>();

        q1.offer(new account("Spider-Man", 1445, 6000));
        q1.offer(new account("Wanda Maximoff", 1997, 2000));
        q1.offer(new account("Black Widow", 9917, 3000));
        q1.offer(new account("Steve Rogers", 7781, 4000));

        System.out.println("peek:"+q.peek());
        System.out.println(q.size());

        System.out.println("poll:"+q.poll());
        System.out.println(q.size());

        System.out.println(q1);

	}

}
