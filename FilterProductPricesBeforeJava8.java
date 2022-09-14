package com.java8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Product{
	int id;
	String name;
	float price;
	public Product(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}

public class FilterProductPricesBeforeJava8 {

	public static void main(String[] args) {
		
		Stream.iterate(1,element->element+1).filter(element->element%5==0).limit(5).forEach(System.out::println);
		ArrayList<Product> prodList = new ArrayList<Product>();
		prodList.add(new Product(100,"Hp",50000.0f));
		prodList.add(new Product(200,"Lenevo",30000.0f));
		prodList.add(new Product(300,"Sony",70000.0f));
		prodList.add(new Product(400,"Dell",25000.0f));
		prodList.add(new Product(500,"Compacq",20000.0f));
		
		List<Float> pricelist = new ArrayList<Float>();
		
		for(Product prod: prodList){
			if(prod.price<30000.0f){
				pricelist.add(prod.price);
			}
		}
		System.out.println(pricelist);
		
		//to collect specific attribute list from product objects
		List<Float> price = prodList.stream().filter(pr->pr.price<30000.0f)
						.map(pr->pr.price).collect(Collectors.toList());
		System.out.println(price);
		
		// to collect all products names
		List<String> prodnames = prodList.stream().map(p->p.getName()).collect(Collectors.toList());
		System.out.println(prodnames);
		
		//to collect product object list
		List<Product> pricep = prodList.stream().filter(pr->pr.price<30000.0f).collect(Collectors.toList());
		System.out.println("products:: "+pricep);
		
		prodList.stream().filter(prod->prod.price==30000.0f).forEach(product->System.out.println(product.name));
		
		//total the price amount for all the products.
		Float totalPrice = prodList.stream().map(prod->prod.price).reduce(0.0f, (sum,pri)->sum+pri);
		System.out.println(totalPrice);
		
		//total the price amount for all the products whose price is above 30k.
				Float totalPrice1 = prodList.stream().filter(prod->prod.price>30000.0f).map(prod->prod.price).reduce(0.0f, (sum,pri)->sum+pri);
				System.out.println(totalPrice1);
				//total the price amount for all the products. more precise code
				Optional<Float> totalprice2 = prodList.stream().map(prod->prod.price).reduce(Float::sum);
				if(totalprice2.isPresent()){
					System.out.println(totalprice2.get());
				}
				
				//using collectors sum method
				Double totalprice3 = prodList.stream().collect(Collectors.summingDouble(prod->prod.price));
				System.out.println(totalprice3);
				
				//find max product price.
				Product maxprice = prodList.stream().max((prod1,prod2)->prod1.price>prod2.price?1:-1).get();
				System.out.println(maxprice.price);
				
				//find min price product
				Product minprice = prodList.stream().min((prod1,prod2)->prod1.price>prod2.price?1:-1).get();
						System.out.println(minprice.price);
						
						//total products count
						long count = prodList.stream().count();
						System.out.println(count);
						long count1 = prodList.stream().filter(prod->prod.price>45000.0f).count();
						System.out.println(count1);
						//converting product list into set
						Set<Float> priceset = prodList.stream().filter(prod->prod.price>30000.0f).map(prod->prod.price).collect(Collectors.toSet());
						System.out.println(priceset);
						
						Stream<Product> pricesets = prodList.stream().filter(prod->prod.price>30000.0f).distinct();
						System.out.println( pricesets.findFirst().get().getName());
						
						//convert list into map
						Map<Integer,String> prodmap = prodList.stream().collect(Collectors.toMap(p->p.id,p->p.name));
						System.out.println(prodmap);
						
						//product price list using method reference
						prodList.stream().filter(prod->prod.price>30000.0f).map(Product::getPrice).forEach(System.out::println);
	}

}
