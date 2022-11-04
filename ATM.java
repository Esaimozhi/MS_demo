package com.atm.service.alpha_atm_service;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;


public class ATM 
{
	static Scanner in = new Scanner(System.in);	
	int  iNumDem, count=1;	
	static String sTransType;
	
	
   @SuppressWarnings({ "unchecked", "unused" })
public  void moreTrans(HashMap<Integer, Integer> atmMap)throws Exception { 
	   Integer [] d =  {20,10,5,1};
   	   int n=0 , m=0, TransType=0;
   	   boolean loopAgain = true,transAgain = true;    		
	   System.out.flush();
	   
	   try {	   		  		
			System.out.print("Would like to Deposit or Withdraw - D/W ?");    	    	
			sTransType = in.nextLine().toUpperCase(); 			
	        System.out.println();     
	       
	        do {
	        	HashMap<Integer, Integer> currMap = new HashMap<Integer, Integer>();
			    if (sTransType.contentEquals("D") || sTransType.contentEquals("W") ){ 
			    try {	
		  		  do {
			    		System.out.print("Denominators (20,10,5,1) :");	    		
			    		n= in.nextInt();
			    		
			    		List<Integer> list = Arrays.asList(d);
			    		 if(list.contains(n)){
			    		    	System.out.print("Number of Notes : ");
				                m= in.nextInt();	
				                currMap.put(n, m);
			    		    }	
			    		    else {
			    		    	System.out.println("Invalid Denominators");
					    		System.out.println();					    		
			    		    }
			    		    
				    	 	System.out.println("Would like to continue - Press 1 :");	  		    	
				    	 	Integer answer =in.nextInt();			    		
			            if(answer ==1) { loopAgain = true;}else {loopAgain = false;}		            
		  		 	 }while(loopAgain);
			    }catch(Exception e) {
			    	System.out.println("Invalid entry-try again");
			    	}			   	
			}else { throw new Exception("Invalid entry");}
			   
		    
	    HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();   
	    HashMap<Integer, Integer> sortedAccBalance = new HashMap<>();		
		
		int tVal =0, totalTransAmount=0; 
		
		System.out.println("***************** RESULT **************");
		
    	try { 
    		for (Integer i : currMap.values()) {
    			
    			 if (sTransType.contentEquals("D") && i ==0 ) { throw new Exception("Deposit Amount cannot be Zero");}
    			 if (sTransType.contentEquals("D") && i <0 ) { throw new Exception("Deposit Amount cannot be Negative");}
    	         else if(sTransType.contentEquals("D") && i < 0){throw new Exception("Incorrect Deposit Amount");}
    	         else if(sTransType.contentEquals("W") && i <=0) {throw new Exception("Incorrect or insufficient funds");}		    			
    			 } 
    	   		
    		atmMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
            .forEachOrdered(x -> sortedAccBalance.put(x.getKey(), x.getValue()));
    		
    		for (Map.Entry<Integer, Integer> map : atmMap.entrySet()) {
    			Integer key = map.getKey();
    			Integer balance = map.getValue();	    				    			
    	        for (Map.Entry<Integer, Integer> entry : currMap.entrySet()) {
    	        	Integer cKey = entry.getKey();
    	        	Integer current = entry.getValue();
				
    	        	if(cKey.compareTo(key)==0){		    	        		
    	        		 if (balance < current && sTransType.contentEquals("W")) {
    	        			 throw new Exception("Incorrect or insufficient funds");
    	        		 }
    	        		 else if(sTransType.contentEquals("W")){
    	            			hmap.put(key, balance-current);
    	            		}
    	        		 else if(sTransType.contentEquals("D")) {	    	            		
	    	            		hmap.put(key, balance+current);		    	            		
	    	            		}	    	        		
    	        	}     	        	
    	        }
    	        
    	        if(!hmap.containsKey(key)){ hmap.put(key, balance);}    	  
    	    }
    		    		
    			System.out.println(sTransType.contentEquals("D")? "Deposit "+count+" :"+currMap :"Withdraw :"+count+" :"+currMap);
    			System.out.println("\n");
    			    	    		
	    		if(!hmap.isEmpty()) {
	    			LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
	    		
		    		hmap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
	                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));   
	        		
		    		 Set<Entry<Integer, Integer>> set = sortedMap.entrySet();
		    		 Iterator<Entry<Integer, Integer>> iterator = set.iterator();		 
		    		 
		    		 System.out.print("Balance: ");
		    		 while(iterator.hasNext()) {
		    			 @SuppressWarnings("rawtypes")
		    			 Map.Entry mentry = (Map.Entry)iterator.next();		    			 
		    			 tVal =  (int)mentry.getKey() * (int) mentry.getValue();
		    			 System.out.print(mentry.getKey() + "s= "+mentry.getValue()+",");
		    			 totalTransAmount+= tVal;
		    		 }
	    		} 
	    		
    		}
    		catch(Exception e) {System.out.println(e.getMessage());}
    	
	    	System.out.println("Total = "+ totalTransAmount);     	
	    	System.out.println("\n");    	
	    	System.out.print("Proceed with another transaction of(D/W ) - Press - 9 ?");   	    	
		    TransType = in.nextInt();	   
		    if(TransType ==9) { transAgain = true;count+=1;
		    if(hmap.isEmpty()) { hmap =atmMap;}		  
		    else{
		    atmMap.clear();
			atmMap = (HashMap<Integer, Integer>) hmap.clone();}
		    }else {transAgain = false;  System.out.println("Thank you  - Welcome back !");}
	    }while (transAgain) ; 
	    	 		    	
	   }catch(Exception e) 	{System.out.println(e.getMessage());	}
	   
   }
         
   public static void main( String[] args ) throws Exception
    {
    	ATM app = new ATM();    	
    	HashMap<Integer, Integer> atmMap = new HashMap<Integer, Integer>();
    	
    	atmMap.put(20,0);
    	atmMap.put(10,0);
    	atmMap.put(5,0);
    	atmMap.put(1,0);  	
    	try 
    	{	    	
	    	app.moreTrans(atmMap);
    	}catch(Exception e){System.out.println(e.getMessage());}
    	
    }  
}
