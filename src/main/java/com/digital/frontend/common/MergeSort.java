package com.digital.frontend.common;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeSort {
    public MergeSort(int[] A)
    {
    	System.out.println(minSlice(A));
    }
 
    public int minSlice(int[] A)
    {
    	ArrayList<Integer> sliceList = new ArrayList<>();
        for(int p = 0 ; p < A.length ; p++){
            int tmpResult = A[p];
            for(int q = p + 1 ; q < A.length ; q++){
            	tmpResult += A[q];
            	System.out.println("slice: " + Math.abs(tmpResult));
            	sliceList.add(Math.abs(tmpResult));
            }    
        }    
        
        return mergeSort(sliceList).get(0);
    }
 
    public ArrayList<Integer> mergeSort(ArrayList<Integer> whole){
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        int center;
 
        if(whole.size() == 1)    
            return whole;
        else
        {
            center = whole.size() / 2;
            // copy the left half of whole into the left.
            for(int i=0; i<center; i++) {
                    left.add(whole.get(i));
            }
 
            //copy the right half of whole into the new arraylist.
            for(int i=center; i<whole.size(); i++)
            {
                    right.add(whole.get(i));
            }
 
            // Sort the left and right halves of the arraylist.
            left  = mergeSort(left);
            right = mergeSort(right);
 
 
            // Merge the results back together.
            merge(left,right,whole);
 
        }
        return whole;
    }
 
    private void merge(ArrayList<Integer> left, ArrayList<Integer> right, 
            ArrayList<Integer> whole) {
 
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()){
            if ((left.get(leftIndex).compareTo(right.get(rightIndex)))<0)  {
                whole.set(wholeIndex,left.get(leftIndex));
                leftIndex++;
            } else{
                whole.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeIndex++;
        }
 
        ArrayList<Integer> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            // The left arraylist has been use up...
            rest = right;
            restIndex = rightIndex;
        }else {
            // The right arraylist has been used up...
            rest = left;
            restIndex = leftIndex;
        }
 
        // Copy the rest of whichever arraylist (left or right) was
        // not used up.
        for (int i=restIndex; i<rest.size(); i++) {
            whole.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
    }
 
    public static void main(String[] args) {
       
    	int[] A = {2,-4,6,-3,9};
        
        System.out.println("************************");
        MergeSort test = new MergeSort(A);
    }
}
