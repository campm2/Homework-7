import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Stock{
	private String Name_;
	private String Symbol_;
	private double Price_;
	
	
	//not arguement constructor
	/**
	 *this is the no arguement constructor that is called when user enters certain values
	 */
	public Stock() {
		Name_="Microsoft";
		Symbol_="MSFT";
		Price_=46.87;
		
	}//end of the constructor that has not arguements
	public Stock(String Name,String Symbol, double Price) {
		Name_=Name;
		Symbol_=Symbol;
		Price_=Price;
	}//end of the constructor that has arguements
	// setter for name
		/**
		 * @param Name
		 */
	public void setName(String Name) {
		Name_=Name;
	}//end bracket for setName
	//setter for symbol
	/**
	 * @param Symbol
	*/
	public void setSymbol(String Symbol) {
		Symbol_=Symbol;
	}//end bracket for setSymbol
	//setter for currentPrice
	/**
	* @param currentPrice
	*/
	public void setPrice(double Price ) {
		if(Price>0) {
			Price_=Price;
		}
		else {
			Price=0;
		}
	}//end bracket for setPrice
	//getter for name
	/**
	 * @return name_
	 */
	public String getName() {
		return Name_;
	}//end of bracket for name
		
	//getter for symbol
	/**
	 * @return Symbol_
	 */
	public String getSymbol() {
		return Symbol_;
	}//end of bracket for getSymbol
	//getter for Price
	/**
	* @return Price_
	*/
	public double getPrice() {
		return Price_;
	}//end bracket for Price
	public double sum(Stock[] stock) {
		double sum=0;
		for(int i=0;i<stock.length;i++) {
			sum+=stock[i].getPrice();
		}//end of for loop
		return sum;
	}
	public double average(Stock[]stock) {
		double sum=0;
		double average=0;
		for(int i=0;i<stock.length;i++) {
			sum+=stock[i].getPrice();
			average=sum/stock.length;
		}//end of for loop
		return average;
	}
	public String Highest(Stock[]stock) {
		double max=stock[0].getPrice();
		String highestName=stock[0].getName();
		for(int i=0;i<stock.length;i++) {
			double current=stock[i].getPrice();
			
			if(current>max) {
				max=stock[i].getPrice();
				highestName=stock[i].getName();	
			}//end of if
			
		}//end of for loop
		return highestName;
	}
	public String Lowest(Stock[] stock) {
		double min=stock[0].getPrice();
		String lowestName=stock[0].getName();
		for(int i=0;i<stock.length;i++) {
			double current=stock[i].getPrice();
			
			if(current<min) {
				min=stock[i].getPrice();
				lowestName=stock[i].getName();	
			}//end of if
		}//end of for loop
		return lowestName;
	}
	public int Count(String count,String filename) throws IOException {
		int file_Length=0;
		File file=new File(filename);
		Scanner inputFile=new Scanner(file);
		// to see how many lines there is in the file
		while(inputFile.hasNext()) {
			count=inputFile.nextLine();
			if(!(count.isEmpty())) {
				file_Length++;
			}//end of if
		}//end of while statement
		inputFile.close();
		return file_Length;
	}
	
}