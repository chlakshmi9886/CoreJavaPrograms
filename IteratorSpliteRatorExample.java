package com.java8.stream;

import java.util.*;
import java.util.stream.Stream;
public class IteratorSpliteRatorExample {

	public static void main(String[] args) {
		System.out.println("spliterator object example");
		ArrayList<Integer> list = new ArrayList<>();
		list.add(100);
		list.add(200);
		list.add(500);
		list.add(800);
		list.add(300);
		list.add(400);
		list.add(150);
		
		//create a stream on the list.
		Stream<Integer> st = list.stream();
		//get spliterator object on the stream
		Spliterator<Integer> spltr = st.spliterator();
		//get size of the list encountered by forEachRemaining method
		System.out.println("Estimate size :: " + spltr.estimateSize());
		
		//get exact size if known
		System.out.println("Exact size :: " + spltr.getExactSizeIfKnown());
		System.out.println("boolean status "+ spltr.hasCharacteristics(spltr.characteristics()));
		//print elements using for each remaining method.
		spltr.forEachRemaining(n->System.out.println(n));
		System.out.println("boolean status "+ spltr.getExactSizeIfKnown());
		if(spltr.getExactSizeIfKnown()>0){
			Spliterator<Integer> spltr3 =spltr.trySplit();
			spltr3.forEachRemaining(n->System.out.println(n));
		}
		
		Stream<Integer> str = list.stream();
		spltr = str.spliterator();
		Spliterator<Integer> spltr2 = spltr.trySplit();
		
		System.out.println("spliterator 2:: " );
		spltr2.forEachRemaining( n->System.out.println(n));
		System.out.println("spliterator :: " );
		spltr.forEachRemaining( n->System.out.println(n));
		
		System.out.println("parallel stream :: " );
		
		Stream<Integer> str1 = list.parallelStream();
		Spliterator<Integer> splter = str1.spliterator();
		splter.forEachRemaining(n->System.out.println(n));
		
		List<String> strlist = Arrays.asList("Hello","G","E","E","k");
		strlist.parallelStream().forEach(System.out::print);
		System.out.println();
		System.out.println("normal stream ....");
		List<String> strlist1 = Arrays.asList("Hello","G","E","E","k");
		strlist1.stream().forEach(System.out::print);;
		
	}
	
}
