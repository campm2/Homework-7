import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
/* ========================================================================== */
/* PROGRAM: A List of Stock
    AUTHOR: Megan Camp, Tejash P.
    COURSE NUMBER: CIS 210
    COURSE SECTION NUMBER: 02
    INSTRUCTOR NAME: Dr.Tian
    PROJECT NUMBER: 7
    DUE DATE: 10/19/2017
SUMMARY



INPUT


OUTPUT


ASSUMPTIONS

/* MAIN FUNCTION */
public class StockList {
	public static void main(String [] args) throws IOException  {
		Stock object=new Stock();
		String highestStock="";
		String lowestStock="";
		final int MIN_NUMBER_OF_STOCKS=30;
		final int MAX_NUMBER_OF_STOCKS=50;
		double stocksAverage=0;
		double sum=0;
		String name="";
		String symbol="";
		double price=0;
		String count="";
		int file_Length=0;// counting to see how many lines in file
		int fileCount=0;
		Scanner keyboard= new Scanner(System.in);
		System.out.print("Enter the filename: ");
		String filename=keyboard.nextLine();
		File file=new File(filename);
		if (file.exists()) {
			Scanner inputFile=new Scanner(file);
			file_Length=object.Count(count,filename);
			
			if(file_Length>MAX_NUMBER_OF_STOCKS||file_Length<MIN_NUMBER_OF_STOCKS) {
				System.out.print("Error: Incorrect amount of stocks");
				inputFile.close();
			}//end of if
				Stock[] stock=new Stock[MAX_NUMBER_OF_STOCKS];
				while(inputFile.hasNext()) {
					String fileLine=inputFile.nextLine();
					if(!(fileLine.isEmpty()) ) {
						for(int i=0;i<MAX_NUMBER_OF_STOCKS;i++) {
							stock[i]=new Stock(name,symbol,price);
							String [] splitFile=fileLine.split(",");
						     stock[i].setName(splitFile[0]);
						     stock[i].setSymbol(splitFile[1]);
						     stock[i].setPrice(Double.parseDouble(splitFile[2]));
						
						}
						
					}//end of if 
				}//end of while loop
				sum=object.sum(stock);
				System.out.println(sum);
				stocksAverage=object.average(stock);
				System.out.println(stocksAverage);
				highestStock=object.Highest(stock);
				lowestStock=object.Lowest(stock);
				System.out.println(highestStock);
				System.out.println(lowestStock);
				
			}//end of inside else
		
		else {
			System.out.println("Error: File does not exist");
		}//end of outside else
		
	}
	
		
}