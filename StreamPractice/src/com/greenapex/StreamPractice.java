package com.greenapex;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a=new ArrayList<>();
		a.add(10);
		a.add(15);
		a.add(20);
		a.add(25);
        a.add(30);
		a.add(35);
		a.add(12);
		a.add(15);
		
//		List<Integer> s=a.stream().filter(i->i%2==0).collect(Collectors.toList());
//         s.forEach(j->System.out.println(j));
//		List<Integer> s=a.stream().filter(i->i%2!=0).collect(Collectors.toList());
//        s.forEach(j->System.out.println(j));
        
//        System.out.println( a.stream().findFirst());
		
//		List<Integer> s=a.stream().map(i->i+5).collect(Collectors.toList());
//		s.forEach(x->System.out.println(x));
       
//		long n=a.stream().filter(i->i>=20).count();
//		System.out.println(n);
		
//		List<Integer> s=a.stream().sorted().collect(Collectors.toList());
//		s.forEach(j->System.out.println(j));
		
//		List<Integer> s=a.stream().sorted((i1,i2)->((i1<i2)?1:(i2>i1)?-1:0)).collect(Collectors.toList());
//		s.forEach(j->System.out.println(j));
		
		List<Integer> s=a.stream().sorted((i1,i2)->i1.compareTo(i2)).collect(Collectors.toList());
		s.forEach(j->System.out.println(j));

	}

}
