package com.greenapex;

import java.util.ArrayList;
import java.util.List;

public class ForEachLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();  
		list.add("Football");  
		list.add("Cricket");  
		list.add("Chess");  
		list.add("Hocky");  
        System.out.println("------------Iterating by passing method reference---------------");  
        list.forEach(gameList->System.out.println(gameList));  

	}

}
