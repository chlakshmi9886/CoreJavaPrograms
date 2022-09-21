package com.java8.stream;

public class InterviewBitQuestion {

	public static void main(String[] args) {
		int[][] numbers = {{3,2,3,6},{2,4},{9},{2,3,4,2}};
		int total=0;
		
		for(int i=0;i<numbers.length;i++){
			//sum calculates as below
			//2+3+6+2+9+2+3+4=31
			for (int j=0;j<numbers[i].length;j++){
				if(i==j)
					continue;
				total=total+numbers[i][j];
			}
		}
		System.out.println(total);

	}

}
