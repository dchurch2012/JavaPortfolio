import javax.swing.*;
import static java.lang.Math.pow;
import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.Object;

import java.awt.BorderLayout;

class AmortizationProgram {
		public static Scanner input = null;
		protected static Vector<AmortizationSchedule> amortList = new Vector<AmortizationSchedule>();
		protected AmortizationSchedule amortSchedule = null;
		
		public static void main(String[] args) {
			input = new Scanner(System.in);

			// Enter APR
			System.out.print("Enter APR : " );
			double APR = input.nextDouble(); 

			// Enter  Total Auto Cost
			System.out.print("Enter Total Auto Cost : " );
			double ItemCost = input.nextDouble(); 

			// Enter Period of loan in years
			System.out.print("Enter Period of loan in years : " );
			int PeriodOfLoan = input.nextInt(); 

			amortList = calculateAmortizationTable(APR, ItemCost,PeriodOfLoan);
			
			PrintTable(amortList);
			
			DisplayTable(amortList);
		}


		public static void PrintTable(Vector<AmortizationSchedule> amortList)
		{
			System.out.println ();
			
			for(int index = 0; index < amortList.size(); index++)
			{
				System.out.printf("%4d",index+1 );
				System.out.printf("%6s","  ");
		
				System.out.print("Item Cost : ");
				System.out.printf("%12.2f", amortList.get(index).ItemCost );
				System.out.printf("%6s","  ");
				
				System.out.print("Loan Period : ");
				System.out.printf("%6d", amortList.get(index).PeriodOfLoan );
				System.out.printf("%6s","  ");
				
				System.out.printf("%12s","Loan Cost : ");
				System.out.printf("%6.2f", amortList.get(index).CostOfLoan );
				System.out.printf("%12s","  ");
	
				System.out.printf("%12s","Monthly Payment : ");
				System.out.printf("%6.2f", amortList.get(index).CostPerMonth );
				System.out.printf("%6s","  ");

				System.out.printf("%6s","Balance : ");
				System.out.printf("%12.2f", amortList.get(index).Balance );
				System.out.printf("%6s","  ");

				System.out.printf("%15s","Total Item Cost : ");
				System.out.printf("%12.2f", amortList.get(index).TotalItemCost );
				System.out.printf("%6s","  ");
				
				System.out.printf("%10s","Ending Balance : ");
				System.out.printf("%12.2f", amortList.get(index).endingBalance );
				System.out.printf("%10s","  ");
			
				System.out.printf("%15s","Interest Paid : ");
				System.out.printf("%12.2f", amortList.get(index).interestPaid );
				System.out.printf("%6s","  ");
				
				System.out.printf("%16s","Principle Paid : ");
				System.out.printf("%12.2f", amortList.get(index).principlePaid );
				System.out.printf("%6s","  ");
				
				System.out.printf("%6s","EAI : ");
				System.out.printf("%6.2f", amortList.get(index).EAI );
				
				System.out.println();
			}
		}
	
		public static double calculateMonthlyPayment(double Principle, double rate, double n)
		{
			double monthly_payment = Principle * rate * (Math.pow((1 + rate), n)) / (pow((1 + rate), n) - 1);
			return monthly_payment;
		}

		public static void calculateAmortizationTable()
		{
			double APR = 0;
			double ItemCost = 0;
			double PeriodOfLoan = 0;
			double CostOfLoan = 0;
			double CostPerMonth = 0;
			double Balance = 0;
			double TotalItemCost = 0;
			double endingBalance = 0;
			double interestPaid = 0;
			double periodInterestRate = 0;
			double principlePaid = 0;

			DecimalFormat df = new DecimalFormat("###.##");
			
			// Enter APR
			System.out.print("Enter APR : " );
			APR = input.nextDouble(); 

			// Enter  Total Auto Cost
			System.out.print("Enter Total Auto Cost : " );
			ItemCost = input.nextDouble(); 

			// Enter Period of loan in years
			System.out.print("Enter Period of loan in years : " );
			PeriodOfLoan = input.nextDouble(); 

			System.out.println();

			System.out.println("APR                                 : "  + APR );
			System.out.println("Loan Amount                   : "  + ItemCost );
			System.out.println("Loan Period (years)        : "  + PeriodOfLoan );

			System.out.println();
	
			periodInterestRate = APR / 1200;

			PeriodOfLoan = PeriodOfLoan * 12;

			CostPerMonth = calculateMonthlyPayment(ItemCost, periodInterestRate, PeriodOfLoan);
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			TotalItemCost = CostPerMonth * PeriodOfLoan;
			CostOfLoan = TotalItemCost - ItemCost;
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			Balance = ItemCost;

			System.out.println();
			System.out.println();
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			System.out.println( "Montlhy Payment for "  + PeriodOfLoan  + " Months : " + "$"  + df.format(CostPerMonth) );
			System.out.println( "Total Cost of Item and Loan             : " +  "$"  + df.format(TotalItemCost) );

			System.out.println();
			System.out.println();

			endingBalance = TotalItemCost;

			for (int month = 0; month < PeriodOfLoan; month++)
			{
				// Calculate interest by multiplying rate against balance
				interestPaid = Balance * (periodInterestRate);
				principlePaid = CostPerMonth - interestPaid;

				Balance -= principlePaid;
				endingBalance -= CostPerMonth;
			
				// Lets show the table, loan, interest, and payment made towards principle
				System.out.print(String.format ("Month %03d", month + 1)); 
				System.out.print("   Payment : $"  +  df.format(CostPerMonth));
				
				System.out.printf("%18s"," Interest   : $");
				System.out.printf("%6.2f", interestPaid);
				System.out.printf("%18s"," Principle  : $");
				System.out.printf("%12.2f", principlePaid);
				System.out.printf("%25s"," Loan Balance is  : $");
				System.out.printf("%-12.2f",Balance);
				System.out.printf("%26s"," Total Amount Owed is: $");
				System.out.printf("%12.2f",endingBalance);
				System.out.println();
			}

			System.out.println();
			System.out.println();

			//EAI = (1 + i/n) ^ n - 1
			double EAI = (pow((1 + periodInterestRate), 12) - 1) * 100;
			System.out.println("Effective Annual Interest Rate         : " + df.format(EAI) + "%" );

			System.out.println();
			System.out.println("Cost of Loan                                      : "  +  "$"  + df.format(CostOfLoan) );
			System.out.println("Loan as Percentage of Item Cost     : "  + df.format( (100 - ((ItemCost / TotalItemCost) * 100) )) + "%" );
		}
	
		public static Vector<AmortizationSchedule> calculateAmortizationTable(double APR, double ItemCost, int PeriodOfLoan)
		{
			Vector<AmortizationSchedule> amortList = new Vector<AmortizationSchedule>();
			AmortizationSchedule amort  = null;
		
			PeriodOfLoan *= 12;
				
			double periodInterestRate = APR / 1200;
			double CostPerMonth = calculateMonthlyPayment(ItemCost, periodInterestRate, PeriodOfLoan);
			double TotalItemCost = CostPerMonth * PeriodOfLoan;
			double Balance = ItemCost;
			double endingBalance = TotalItemCost ;	
			
			for (int month = 0; month < PeriodOfLoan; month++)
			{
				amort = new AmortizationSchedule();
		
				amort.APR = APR;
				amort.ItemCost = ItemCost;
				amort.PeriodOfLoan = PeriodOfLoan;
				
				amort.PeriodOfLoan = PeriodOfLoan;
				amort.CostPerMonth = CostPerMonth;
				/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				amort.TotalItemCost = TotalItemCost;
				amort.CostOfLoan = TotalItemCost - ItemCost;
		
				//EAI = (1 + i/n) ^ n - 1
				amort.EAI = (pow((1 + periodInterestRate), 12) - 1) * 100;
				
				// Calculate interest by multiplying rate against balance
				amort.interestPaid = Balance * (periodInterestRate);
				amort.principlePaid = CostPerMonth - amort.interestPaid;

				Balance -= amort.principlePaid;
		
				amort.Balance = Balance;
				endingBalance -= CostPerMonth;
				amort.endingBalance = endingBalance;
				
				amortList.add(amort);
			}
			return amortList;
	}

	public static void DisplayList(Vector<AmortizationSchedule> amortList) 
	{
		JFrame frame = new JFrame("Creating a JList Component");
		JPanel panel = new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DefaultListModel listModel;

		listModel = new DefaultListModel();
		listModel.addElement("item 1");
		listModel.addElement("item 2");

		JList list = new JList(listModel);
		
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		panel.add(list);
		frame.add(panel);
		frame.setSize(400,400);
		frame.setVisible(true);
	}
	
	public static void DisplayTable(Vector<AmortizationSchedule> amortList) 
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DecimalFormat df = new DecimalFormat("###.##");
		
		int length = amortList.size();
		String[][] row = new String[length][];
		
		for(int index = 0; index < length; index++)
		{
			row[index] = new String[12];
			
			row[index][0] =  String.valueOf((index+1));
			
			row[index][1] =  df.format(amortList.get(index).APR);
			row[index][2]  = df.format(amortList.get(index).ItemCost );
			row[index][3]  = df.format(amortList.get(index).PeriodOfLoan );
			row[index][4]  = df.format(amortList.get(index).CostOfLoan );
			row[index][5]  = df.format(amortList.get(index).CostPerMonth );
			row[index][6]  = df.format(amortList.get(index).Balance );
			row[index][7]  = df.format(amortList.get(index).TotalItemCost );
			row[index][8]  = df.format(amortList.get(index).endingBalance );
			row[index][9]  = df.format(amortList.get(index).interestPaid );
		    row[index][10]  = df.format(amortList.get(index).principlePaid );
		    row[index][11]  = df.format(amortList.get(index).EAI );
		}
		
		Object columnNames[] = { "Month #","APR", "ItemCost", "Period Of Loan","Cost of Loan","Cost Per Month","Loan Balance","Total Cost","Ending Balance","Interest Paid","Principle Paid","Effective Annual Interest Rate" };
		JTable table = new JTable(row, columnNames);

		JScrollPane scrollPane = new JScrollPane(table);
		frame.add(scrollPane, BorderLayout.CENTER);
		frame.setSize(300, 150);
		frame.setVisible(true);
  }
}

