package edu.handong.csee.java.Lab09;
import java.util.Scanner;


/**
 * 
 * @author miin
 * You can input many salesman and their sales.
 * It lets you know average sales and  highest sales.
 * It will print name and sales of highest sales.
 */
public class SalesReporter {//class name.

	private String mName;//private String variable "mName"
	private double sales;//private double variable "sales"
	private double averageSales;//"private double variable "averageSales"
	private double highestSales;//"private double variable "highestSales"
	private Salesman[] team;//private array Salesman "team". you can't instantiate here cause you don't know the size. 
	private int numOfSalesman;//private int variable "numOfSalesman"


	public SalesReporter( ) {//this method is put number of salesman.
		System.out.println("Enter number of salesman: ");//prints this line.
		Scanner keyboard = new Scanner(System.in);//instantiation of Scanner 

		numOfSalesman = keyboard.nextInt();//puts input integer to "numOfSalesman" 
		Salesman[] team = new Salesman[numOfSalesman]; // instantiation of salesman[] to team
	}

	public static void main(String[] args) {//main method.
		SalesReporter myReporter = new SalesReporter(); //instantiating class.
		myReporter.getData();//method calling
		myReporter.calculateAverageSales();//method calling
		myReporter.calculateHighestSales();//method calling
		myReporter.printOutMyResult();//method calling
	}


	public void getData() {//this is core method of this program.

		team = new Salesman[numOfSalesman]; //instantiation of team.

		for(int i=0; i < numOfSalesman; i++) {//loop

			Scanner keyboard = new Scanner(System.in);//instantiation of Scanner. 

			Salesman mySalesman = new Salesman();//instantiation of Salesman.


			System.out.println("Enter data for associate number " + (i+1));//prints this line.
			System.out.print("Enter name of sales : ");//prints this.
			String mName = keyboard.nextLine();//puts input line to "mName" 


			System.out.print("Enter sales: $ ");//prints this line.
			double sales = keyboard.nextDouble();//puts input line to "sales"
			System.out.println();//to next line.


			mySalesman.setmName(mName);//sets mysalesman.mName by "mName"
			mySalesman.setSales(sales);//sets mysalesman.sales by "sales"


			team[i] = mySalesman;//put mySalesman to "team".
		}
	}
	public void calculateAverageSales() {//this method calculate average sales.

		double sum = 0; //initialization of "sum" to calculate average.  

		for(int i=0; i < team.length; i++) {//loop. team.length == numOfSalesman.

			sales = team[i].getSales(); //puts value of team[i] into "sales"
			sum = sum + sales; //"sum" is sum of all "sales".
		}

		averageSales = sum/team.length; //average sales.

	}
	public void calculateHighestSales() {//this method calculate highest sales.


		for(int i=0; i < team.length-1; i++) {//loop. team.length == numOfSalesman. if there is n sales, it is enough to loop n-1.

			if(team[i].getSales() < team[i+1].getSales()) // if a "sales" is bigger than other "sales", 
				highestSales = team[i+1].getSales(); //i+1 salesman's sales will be "highestSales".

		}
	}


	public void printOutMyResult(){//print method

		System.out.println("Average: " + averageSales);//prints this line.
		System.out.println("Highest sales: " + highestSales);//prints this line.

		System.out.println("The Highest Sales guy");//prints this line.

		for(int i=0; i < team.length; i++) {//loop.
			if(team[i].getSales() == highestSales) {//if i salesman's sales is equal to highestSales,
				System.out.println("Name: " + team[i].getmName());//prints this line.
				System.out.println("Sales: " + team[i].getSales());//prints this line.
				if(team[i].getSales() > averageSales) // if i salesman's sales is bigger than average of salesmen's sales,
				{
					System.out.println(team[i].getSales()-averageSales + " above the average."); // prints how many above the average.
				}
				else if(team[i].getSales() == averageSales) // if i salesman's sales is same as average of salesmen's sales,
				{
					System.out.println(averageSales  + " same the average"); // prints this line.
				}
				else // if i salesman's sales is less than average of salesmen's sales,
				{
					System.out.println(team[i].getSales() - averageSales + " below the average"); //prints how many below the average.
				}
			}
		}

		System.out.println("The rest performed as follows: "); //prints this line.
		for (int i=0; i < team.length; i++) //loop.
		{

			if(team[i].getSales() != highestSales) // if i salesman's sales isn't equal to hightestSales,
			{
				System.out.println("Name: " + team[i].getmName()); // prints i salesman's name.
				System.out.println("Sales: "+ team[i].getSales());// prints i salesman's sales.

				if(team[i].getSales() > averageSales)// if i salesman's sales is bigger than average of salesmen's sales,
				{
					System.out.println(averageSales - team[i].getSales() + " above the average.");// prints how many above the average.
				}
				else if(team[i].getSales() == averageSales)// if i salesman's sales is same as average of salesmen's sales,
				{
					System.out.println(averageSales  + " same the average"); // prints this line.
				}
				else // if i salesman's sales is less than average of salesmen's sales,
				{
					System.out.println(averageSales - team[i].getSales() + " below the average"); //prints how many below the average.
				}
			}
		}
	}
}
