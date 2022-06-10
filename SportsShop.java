

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * @author ALI ABDULJALIL
 */

public class SportsShop {
	/**
	 * this is a program for design a small software application for sports store in java.
	 */
	private static Scanner x;
	private static String CurrentId = "", Currentname1 = "", Currentstock = "", Currentprice = "";
    static{
        System.out.println("\t\t\t\t\t...........................................\t\t\t\t\t");
        System.out.println("\t\t\t\t\t.                                          .\t\t\t\t\t");
        System.out.println("\t\t\t\t\t. Welcome To SDUT Sports Management System .\t\t\t\t\t");
        System.out.println("\t\t\t\t\t.                                          .\t\t\t\t\t");
        System.out.println("\t\t\t\t\t............................................\t\t\t\t\t");
        System.out.println("\n");
    }
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/**
		 * @param args
		 * This is the main method
		 * which is very important for java
		 */
		MainSportsShop();
		
	}
	
	public static void readRecord(String search, String filepath)
	{
		/** @param search is the purchase code number to be searched
		 * @param filepath is the file name
		 * This method will read the employee details 
		 * If any employee login this method will Welcome the employee with his/her Name
		 */
		boolean found = false;
		String Id = "", name1 = "";
		
		try {
			x = new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");
			
			while (x.hasNext() && !found)
			{
				Id = x.next();
				name1 = x.next();
				
				if(Id.equals(search))
				{
					found = true;
				}
			}
			
			if (found)
			{
				System.out.println("Welcome "+ name1);
			}
			else 
			{
				System.out.println("Record not found");
			}
		}
		catch(Exception e) {
			System.out.println("Error");
		}
	}
	
	
	public static void readSalesRecord(String search, String filepath)
	{
		/**
		 * This method will read Stock file 
		 * It will print the stock details
		 */
		boolean found = false;
		String Id = "", name1 = "", stock = "";
		String price = "";
		
		try {
			x = new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");
			
			while (x.hasNext() && !found)
			{
				Id = x.next();
				name1 = x.next();
				stock = x.next();
				price = x.next();
				
				
				if(Id.equals(search))
				{
					found = true;
				}
			}
			
			if (found)
			{
				CurrentId = Id;
				Currentname1 = name1;
				Currentstock = stock; 
				Currentprice = price;
				
				
				System.out.println("Name: "+name1+"\nCurrent Stock: "+ stock + "\nPrice: " + price);
				
		}
		}
		catch(Exception e) {
			System.out.println("Error");
		}
	
	}
	
	
	public static void MainSportsShop()
	{
		/**
		 * This is the main method for the system
		 * 
		 */
		Scanner scan = new Scanner(System.in);
		int sum = 0, tax= 0, finalprice = 0;
		Stock s = new Stock();
	    String choice, choice1, choice2 = "", choice3 = " ";
        System.out.println("\n" + "Log I)n		Log O)ut	P)urchase	R)eturn\r\n");
        choice = scan.nextLine();
        String Id, Pcode,Pnum;
        while(choice.equals("I")){
        		System.out.print("Enter Your Employee Id : ");
        		Id = scan.next();
        		readRecord(Id, "employee_details.csv");

        Scanner scan1 = new Scanner(System.in);
        System.out.println("\n" + "Log I)n		Log O)ut	P)urchase	R)eturn\r\n");
        choice1 = scan1.nextLine();
        if (choice1.equals("P"))
        { 
        	while(choice1.equals("P") && !choice1.equals("O")) {
        			System.out.print("Enter Purchase Code : ");
        			Scanner scan2 = new Scanner(System.in);
        			Pcode = scan2.nextLine();
        			readSalesRecord(Pcode, "stock.csv");
        			String price = Currentprice;
        			System.out.print("How many would you like to purchase?");
        			Pnum = scan2.nextLine();
        			int pnum = Integer.valueOf(Pnum);
        			int currentprice = Integer.parseInt(Currentprice.trim());
        			int totalprice;
        			totalprice = pnum * currentprice;
        			sum = sum + totalprice;
        			tax = (sum*10)/100;
        			finalprice = sum + tax;
        			String Totalprice = String.valueOf(totalprice);
        			saveRecord(Currentname1, Pnum, Totalprice);
        			editstock(Pcode, Pnum);
        			
        			System.out.print("These items have been added");
        			System.out.print("\n\nP)urchase 	C)omplete Transaction");
        			choice2 = scan2.nextLine();
        			if(choice2.equals("C")) {
        				printdetails(sum,tax,finalprice);
        				System.out.println("Are you sure you want to purchase? C)ontinue S)top ");
        				choice3 = scan2.nextLine();
        				if(choice3.equals("C"))
        				{
        					System.out.println("Thank you for your purchase. Your receipt has been printed.");
        					MainSportsShop();
        				}
        				else if(choice3.equals("S")) {
        					MainSportsShop();
        				}
        			}
        			
        		}
        	}

	}
      if(choice.equals("R"))
        {
    	  MainSportsShop();
        } 
      else if(choice.equals("O"))
      {
      	System.exit(0);
      } 
        
	}
	
	

	public static void saveRecord(String name, String number, String price)
	/**
	 * This method will save the products record into Sales.csv file
	 */
	{
		try {
			FileWriter fw = new FileWriter("Sales.csv", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println(name + "," + number  +  "," + price);
			pw.flush();
			pw.close();
		}catch(Exception e)
		{
			System.out.println("Record not Saved");
		}
	}
	
	public static void printdetails(int total, int tax, int finalprice)
	{
		/**
		 * this method will print the transaction details
		 */
		BufferedReader reader = null;
		String line = "";
		
		try {
			reader = new BufferedReader(new FileReader("Sales.csv"));
			while((line = reader.readLine()) != null)
			{
				String[] row = line.split(",");
				for(String index : row)
				{
					System.out.printf("%-10s", index);
				}
				System.out.println();
			}
			System.out.println("Sub-Total " + total);
			System.out.println("Tax(10%) " + tax);
			System.out.println("Total Price " + finalprice);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try
			{
				reader.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	 public static void editstock(String Id, String stock)
	   {
		 /**
		  * this method will edit the stock.csv file
		  */
		 if(CurrentId.equals(Id))
		 {
		 try {
				FileWriter fw = new FileWriter("stock.csv", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);
				int s1 = Integer.parseInt(Currentstock);
				int s2 = Integer.parseInt(stock);
				int n = s1 - s2;
				pw.println(CurrentId + "," + Currentname1 + "," + n  +  "," + Currentprice);
				pw.flush();
				pw.close();
			}catch(Exception e) 
			{
				System.out.println("Record not Saved");
			}
	   }
	   }
}
