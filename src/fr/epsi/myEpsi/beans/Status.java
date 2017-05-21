package fr.epsi.myEpsi.beans;

import java.util.ArrayList;

public enum Status {

	PUBLIC, PRIVATE, ARCHIVED;
	
	   private static Status[] allValues = values();
	   public static Status fromOrdinal(int n) {return allValues[n];}
	   public static ArrayList<Status> getList() { 
		   ArrayList arr = new ArrayList();
		   arr.add(PRIVATE);
		   arr.add(PUBLIC);
		   arr.add(ARCHIVED);
		   return arr;
	   }
}
