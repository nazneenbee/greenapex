package com.greenapex;

import java.util.*;

public class CollectionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*ArrayList<Integer> l=new ArrayList<Integer>();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);
        
		//l.forEach(l1->System.out.println(l1));
		
		/*for(int l1:l)
		{
			System.out.println(l1);
		}*/
		
		/*for(int i=0; i<l.size(); i++)
		{
			System.out.println(l.get(i));
		}*/
		
		/*Iterator<Integer> l1=l.iterator();
		while(l1.hasNext())
		{
			System.out.println(l1.next());
		}
		System.out.println(l);*/
		
		
		/*List<Integer> l=new LinkedList<Integer>();
		l.add(10);
		l.add(20);
		l.add(10);
		l.add(40);
		l.add(50);	
		for(int l1:l)
		{
			System.out.println(l1);
		}*/
		
		/*Set<Integer> l=new HashSet<Integer>();
		l.add(10);
		l.add(20);
		l.add(10);
		l.add(40);
		l.add(50);	
		for(int l1:l)
		{
			System.out.println(l1);
		}*/
		
		/*Set<Integer> l=new LinkedHashSet<Integer>();
		l.add(10);
		l.add(20);
		l.add(10);
		l.add(40);
		l.add(50);	
		for(int l1:l)
		{
			System.out.println(l1);
		}*/
		
		/*Set<Integer> l=new TreeSet<Integer>();
		Set<Integer> l2=new TreeSet<Integer>();
		l.add(10);
		l.add(20);
		l.add(10);
		l.add(40);
		l.add(50);	
		//l.clear();
		l2.add(10);
		l2.add(40);
		l2.add(100);
		l2.add(70);
		l2.add(80);
		//l.removeAll(l2);
		l.retainAll(l2);
		for(int l1:l)
		{
			System.out.println(l1);
		}*/
		
		Map<Integer, String> m=new HashMap<Integer, String>();
		m.put(1, "Naaz");
		m.put(2, "utkarsha");
		m.put(3, "aparna");
		m.put(1, "amrita");
		m.put(2, "ravi");
		
		for(Map.Entry<Integer, String> m1:m.entrySet())
		{
			System.out.println(m1.getKey());
			System.out.println(m1.getValue());
		}
	}

}
