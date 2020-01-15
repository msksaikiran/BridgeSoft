package com.bss.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Collection {

	public static void main(String[] args) {
		ArrayList<Integer> a1=new ArrayList<>(Arrays.asList(10,40,20));
		a1.add(10);
		a1.add(30);
		a1.add(20);
		a1.add(10);
		//a1.add("sai");
		System.out.println("emelents from arraylist:"+a1);
		//set does not allows duplicate elements
		//LinkedHashSet s1=new LinkedHashSet<>(a1);//heterogenious elements,insertion order
		//HashSet s1=new HashSet(a1);//heteogenious,random order
		TreeSet<Integer> s1=new TreeSet<>(a1);//homogenious,sorted order
		System.out.println("elements after deleting:"+s1);
	}
}
