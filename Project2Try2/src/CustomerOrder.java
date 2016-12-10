/**Author: Stone Daniel
 * Submission Date: 10/6/16
 * This is the customer order class which inherits methods from PizzaStore and Order. It contains many variables,
 * most of them are protected and static. They are protected in order to prevent them from being manipulated by
 * anything other than the child classes, and static in order to prevent them from being reset by reinstantiating
 * the object order.
 */
public class CustomerOrder extends Order
{

	protected static double total = 0;
	protected static int numItems = 0;
	protected static int sessionDrinkOrders = 0;
	protected static int sessionPizzaOrders = 0;
	protected static int sessionAppOrders = 0;
	protected static String output;
	protected static int sVegPizzas = 0;
	protected static int mVegPizzas = 0;
	protected static int lVegPizzas = 0;
	protected static int sCheesePizzas = 0;
	protected static int mCheesePizzas = 0;
	protected static int lCheesePizzas = 0;
	protected static int sPepPizzas = 0;
	protected static int mPepPizzas = 0;
	protected static int lPepPizzas = 0;
	protected static int saladCount = 0;
	protected static int soupCount = 0;
	protected static int drinkCount = 0;
	
	@Override
	public void displayMenu()
	{
		System.out.println("Enter Choice(1-3) or hit any key to exit.");
		System.out.println("1) Pizza" + "\n" + "2) Appetizers" + "\n"+ "3) Soft Drink");	
	}
	@Override
	public double calculateTotal()
	{
		total = total + (total * TAX);
		return total;
	}
	
	@Override
	public void printInvoice() //This uses the output() method to create a final invoice for a customer.
	{
		System.out.println("Invoice " + counter);
		output();
		System.out.println();
		System.out.println("Total:\t\t\t\t " + total);
		System.out.println("Tax:\t\t\t\t " + (total * TAX));
		System.out.println("Final Total:\t\t\t " + calculateTotal());
	}

	/*@Override
	public void setTotal(double d) 
	{
		total = total + d;
	}
	@Override
	public double getTotal() 
	{
		return total;
	}*/
	@Override
	public void printHeading() 
	{

		System.out.println("Welcome to the Pizza Store");
		System.out.println("\tPizza: \n" + " \t\tSmall\tMedium\tLarge");
		System.out.println("Vegetarian \t" + S_VEGETARIAN_PRICE + "\t" + M_VEGETARIAN_PRICE + "\t"
				+ L_VEGETARIAN_PRICE);
		System.out.println("Cheese \t\t" + S_CHEESE_PRICE + "\t" + M_CHEESE_PRICE + "\t"
				+ L_CHEESE_PRICE);
		System.out.println("Pepperoni \t" + S_PEPPERONI_PRICE + "\t" + M_PEPPERONI_PRICE
				+ "\t" + L_PEPPERONI_PRICE);
		System.out.println("\n\tAppetizers:");
		System.out.println("Salad \t\t\t" + SALAD_PRICE );
		System.out.println("Soup \t\t\t" + SOUP_PRICE);
		System.out.println("Soft Drinks \t\t" + DRINK_PRICE);
	}
	public void wipeVars()
	{
		total = 0;
		//output = "";
		sVegPizzas = 0;
		mVegPizzas = 0;
		lVegPizzas = 0;
		sCheesePizzas = 0;
		mCheesePizzas = 0;
		lCheesePizzas = 0;
		sPepPizzas = 0;
		mPepPizzas = 0;
		lPepPizzas = 0;
		drinkCount = 0;
		saladCount = 0;
		soupCount = 0;
	}
	public void output()
	{
		output = "Order Summary \nItem \t\t\t\t Price \t Qty";
		if(drinkCount != 0)
			output += "\nDrinks \t\t\t\t " + DRINK_PRICE + "\t " + drinkCount;
		if(soupCount != 0)
			output += "\nSoup \t\t\t\t " + SOUP_PRICE + "\t " + soupCount;
		if(saladCount != 0)
			output += "\nSalad \t\t\t\t " + SALAD_PRICE + "\t " + saladCount;
		if(sVegPizzas != 0)
			output += "\nSmall Vegetarian Pizzas\t\t " + S_VEGETARIAN_PRICE + "\t " + sVegPizzas;
		if(mVegPizzas != 0)
			output += "\nMedium Vegetarian Pizzas\t " + M_VEGETARIAN_PRICE + "\t " + mVegPizzas;
		if(lVegPizzas != 0)
			output += "\nLarge Vegetarian Pizzas\t\t " + L_VEGETARIAN_PRICE + "\t " + lVegPizzas;
		if(sCheesePizzas != 0)
			output += "\nSmall Cheese Pizzas\t\t " + S_CHEESE_PRICE + "\t " + sCheesePizzas;
		if(mCheesePizzas != 0)
			output += "\nMedium Cheese Pizzas \t\t " + M_CHEESE_PRICE + "\t " + mCheesePizzas;
		if(lCheesePizzas != 0)
			output += "\nLarge Cheese Pizzas \t\t " + L_CHEESE_PRICE + "\t " + lCheesePizzas;
		if(sPepPizzas != 0)
			output += "\nSmall Pepperoni Pizzas\t\t " + S_PEPPERONI_PRICE + "\t " + sPepPizzas;
		if(mPepPizzas != 0)
			output += "\nMedium Pepperoni Pizzas\t\t " + M_PEPPERONI_PRICE + "\t " + mPepPizzas;
		if(lPepPizzas != 0)
			output += "\nLarge Pepperoni Pizzas\t\t " + L_PEPPERONI_PRICE + "\t " + lPepPizzas;

		System.out.println(output);
	}
	public void displaySession()
	{
		System.out.println("Number of Orders\t\t\t" + counter);
		System.out.println("Number of Pizzas Ordered\t\t" + sessionPizzaOrders);
		System.out.println("Number of Appetizers Ordered\t\t" + sessionAppOrders);
		System.out.println("Number of Drinks Ordered\t\t" + sessionDrinkOrders);
	}
	
}

