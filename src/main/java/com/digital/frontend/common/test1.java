package com.digital.frontend.common;

import java.util.ArrayList;

public class test1 {
	public static void main(String[] args) {
	       int n = 5;
	       cal(n);
    }
	
	private static void cal(int n){//1,2,3,4,5
		/*int k = 0;
		int count = 1;
		
		while(k < n){
			count++;
			k += count;
		}*/
		
		ArrayList<Double> list = new ArrayList<Double>();
		for(int p = 0 ; p < 15 ; p++){
			for(int q = 0 ; q < 15 ; q++){
				if(p + q < 100){
					list.add(Math.pow(2, p) * Math.pow(3, q));
				}
			}
		}
		
		if (list.size()>1){
			Double temp;
            for (int x=0; x<list.size(); x++){
                for (int i=0; i < list.size() - x - 1; i++) {
                    if (list.get(i).compareTo(list.get(i + 1)) > 0){
                        temp = list.get(i);
                        list.set(i, list.get(i+1) );
                        list.set(i+1, temp);
                    }
                }
            }
        }
		for(int z = 0 ; z < list.size() ; z++){			
			System.out.println("A[" + z + "]:" + list.get(z)); 
		}
	}
}
