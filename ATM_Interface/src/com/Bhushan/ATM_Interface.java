package com.Bhushan;


import java.time.LocalDate;            
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ATM_Interface {

	//Execution Starts from here...
	public static void main(String[] args)   
	{
		int accountNo = 338307505;
		String accountHolder="Bhushan Chaudhari";
		int pin = 1234;
		int balance = 0;
		boolean flag = true;
		int receipt = 0;
		int attempt = 3;
		int currattempt = 0;
		
		LocalDate lDate = LocalDate.now();  
		String dateStr = lDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
		
		LocalTime dt = LocalTime.now();    
		String timeStr = dt.format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
		
		//declaration of array list
		ArrayList<String> trans = new ArrayList<String>(); 
		
		//taking input from user
		Scanner sc = new Scanner(System.in);            
		
		//checking wrong pin attempts
		while(currattempt<attempt)               
		{
			System.out.println("Enter your pin");
			int pass = sc.nextInt();
			//check pin
			if(pass==pin)               
			{
				System.out.println("Do you want receipt");   
				System.out.println("1. Yes");
				System.out.println("2. No");
				receipt = sc.nextInt();
				break;
			}
			else
				System.out.println("You have entered wrong pin");
			currattempt = currattempt + 1;
		}
		
		//If user enter correct password less than 3 times
		if(currattempt<3)  
		{
			while(flag==true)
			{
				//Options for banking
				System.out.println("######################################");
				System.out.println("1. Transaction History");
				System.out.println("2. Withdraw");
				System.out.println("3. Deposit");
				System.out.println("4. Transfer");
				System.out.println("5. Change Password");
				System.out.println("6. Quit");
				
				System.out.println("Select any option");
				int option = sc.nextInt();
				
				switch(option)
				{
					//Transaction History
					case 1:        
					{	
						System.out.println("Your Transaction History");
						for(String q: trans)
						{
							System.out.println(q);
						}
						break;
					}
					
					
					//Withdraw Money
					case 2:    
					{
						while(true)
						{
							System.out.println("Enter the withdrawl amount");
							int withdraw = sc.nextInt();
							if((withdraw % 10) ==0)
							{
								//check if balance is sufficient for withdraw
								if(withdraw <= balance)
								{
									
										balance = balance - withdraw;
										String s1 = String.format("You have successfully withdrawl Rs %d",withdraw);
										String s2 = String.format("Your balance is Rs %d", balance);
										System.out.println(s1);
										System.out.println(s2);
										
										String wt = String.format("Withdrawl - Rs %d", withdraw);
										trans.add(wt);
										break;
									
								}
								else
								{
									System.out.println("Insufficient balance pls Deposit amount");
								}
							}
							else
								System.out.println("Enter the withdraw amount in multiples of 100");
						}
						
						
						break;
					}
					
					
					//Deposit money
					case 3:          
					{
						while(true)
						{
							System.out.println("Enter the deposit amount");
							int deposit = sc.nextInt();
							if((deposit%10)==0)
							{
								balance = balance + deposit;
								String s1 = String.format("You have successfully deposited Rs %d", deposit);
								String s2 = String.format("Your balance is Rs %d", balance);
								System.out.println(s1);
								System.out.println(s2);
								
								String dp = String.format("Deposit - Rs %d", deposit);
								trans.add(dp);
								
								break;
							}
							else
							{
								System.out.println("Enter the amount in multiples of 100");
							}
						}
						
						break;
					}
					
					
					//Transfer money
					case 4:      
					{
						while(true)
						{
							System.out.println("Enter the accout number of the beneficiary");
							int accno = sc.nextInt();
							System.out.println("Enter the IFSC code of the bank of the beneficiary");
							String ifsc = sc.next();
							System.out.println(accno);
							System.out.println("Please confirm the account number of the beneficiary");
							System.out.println("1. Correct");
							System.out.println("2. Incorrect");
							int conf = sc.nextInt();
							if(conf==1)
							{
								System.out.println("Enter the amount you want to transfer");
								int transfamount = sc.nextInt();
								if((transfamount % 10) ==0)
								{
									if(transfamount <= balance)
									{
										if((balance - transfamount) <1000)
										{
											System.out.println("Minimum balance has to Rs 1000");
										}
										else
										{
											balance = balance - transfamount;
											String s1 = String.format("You have successfully transfered Rs %d to %d",transfamount,accno);
											String s2 = String.format("Your balance is Rs %d", balance);
											System.out.println(s1);
											System.out.println(s2);
											
											String tf = String.format("Transfer - Rs %d", transfamount);
											trans.add(tf);
											break;
										}
										
									}
									else
									{
										System.out.println("Insufficient balance");
									}
								}
								else
									System.out.println("Enter the amount in multiple of 100");
							}
							else
								System.out.println("You entered incorrect account number");
						}
						
						break;
					}
					
					
					//changing pin
					case 5:          
					{
						System.out.println("Enter your old pin");
						int oldpin = sc.nextInt();
						if(oldpin==pin)
						{
							System.out.println("Enter your new pin");
							int newpin = sc.nextInt();
							pin = newpin;
							System.out.println("Do not share your pin with anyone");
							System.out.println("You have successfully changed your password");
							trans.add("Changed Password");
						}else
						{
							System.out.println("Enter valid old pin");
						}
						
					}
					//Exit
					case 6:         
					{
						System.out.println("Thank you for banking with us");
						flag = false;
						break;
					}
					
					
					default:
						System.out.println("Please select an appropriate option");
						break;
				}
				
				System.out.println("Would you like to do another transaction");
				System.out.println("1. Yes");
				System.out.println("2. No");
				int df = sc.nextInt();
				if(df==1)
					flag = true;
				else
					flag = false;
						
			}
			if(receipt==1)
			{
				// Printing the receipt
				String s1 = String.format("Date: %s", dateStr);       
				String s2 = String.format("Time: %s", timeStr);
				String s3 = String.format("Account Number: %d", accountNo);
				String s4 = String.format("Account Holder is: %d", accountHolder);
				String s5 = String.format("Your account balance is Rs %d", balance);
				System.out.println(s1);
				System.out.println(s2);
				System.out.println(s3);
				System.out.println(s4);
				System.out.println(s5);
				
			}
			System.out.println("Thank you for banking with us");
		}
		else
		{
			System.out.println("You have entered wrong pin multiple times");
		}

	}

}
