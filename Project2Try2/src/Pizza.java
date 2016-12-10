import java.util.*;
/** This is the Pizza class. I declared it as final so no other class could extend from it. This class is used to take 
 * case of everything done while inside of a pizza order. The variables are private since no class should change
 * them besides this one.*/
public final class Pizza extends CustomerOrder
{
	
	private int rows = -1;
	private int cols = -1;
	private boolean b = true;
	private int quantity = 0;
	
	public enum PizzaType
	{
		Vegetarian, Cheese, Pepperoni
	}
	public enum SizeType
	{
		Small,Medium,Large
	}
	private PizzaType pizzaType;
	private SizeType sizeType;
	private String pizzaChoice;
	private String sizeChoice;
	public void displayMenu()/** The displayMenu method in the Pizza Class is called from the main and handles the entire pizza order. */
	{
		pizzaChoice = "";
		Pizza:
		while(b)
		{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter Pizza Choice(1-3) or type any key to exit.");
		System.out.println("1)"+ PizzaType.Vegetarian.name() + "\n" + "2)" + 
		PizzaType.Cheese.name() + "\n" + "3)" + PizzaType.Pepperoni.name());
		pizzaChoice = keyboard.nextLine();
		switch(pizzaChoice)//This switch statement instantiates the enum pizzaType to the correct enum.
		{
		case("1"):
			pizzaType = PizzaType.Vegetarian;
			rows = 0;
			break;
		case("2"):
			pizzaType = PizzaType.Cheese;
			rows = 1;
			break;
		case("3"):
			pizzaType = PizzaType.Pepperoni;
			rows = 2;
			break;
		default:
			//OrderSummary
			break Pizza;
		}//Switch Statement for Pizza Choice
		Size:
		while(b)
		{
			sizeChoice = "";
				System.out.println("Please enter size: 1)Small"
						+ " 2)Medium 3)Large or any other key to exit.");
				sizeChoice = keyboard.nextLine().trim();
					switch(sizeChoice)//This switch statement sets the enum sizeType to the correct value.
					{
					case("1"):
						sizeType = SizeType.Small;
						cols = 0;
						break;
					case("2"):
						sizeType = SizeType.Medium;
						cols = 1;
						break;
					case("3"):
						sizeType = SizeType.Large;
						cols = 2;
						break;
					default:
						//OrderSummary
						break Pizza;
					}
				while(b)//This while loop has exception handling to handle a TypeMismatchException
				{
					System.out.println("Please enter quantity or any key to exit.");
					try
					{
						quantity = keyboard.nextInt();
					}
					catch(Exception e)
					{
						break Pizza;
					}
					if(quantity < 0)
						System.out.println("Please enter a positive number.");
					else
					{
						total += ((PIZZA_PRICES[rows][cols] * quantity));
						break;
					}
				}
				sessionPizzaOrders += quantity;
				while(b)//This while loop increases the quantity for the counters of each possible order.
				{
					if(pizzaType == PizzaType.Vegetarian && sizeType == SizeType.Small)
					{
						sVegPizzas += quantity;
						continue Pizza;
					}
					if(pizzaType == PizzaType.Vegetarian && sizeType == SizeType.Medium)
					{
						mVegPizzas += quantity;
						continue Pizza;
					}
					if(pizzaType == PizzaType.Vegetarian && sizeType == SizeType.Large)
					{
						lVegPizzas += quantity;
						continue Pizza;
					}
					if(pizzaType == PizzaType.Cheese && sizeType == SizeType.Small)
					{
						sCheesePizzas += quantity;
						continue Pizza;
					}
					if(pizzaType == PizzaType.Cheese && sizeType == SizeType.Medium)
					{
						mCheesePizzas += quantity;
						continue Pizza;
					}
					if(pizzaType == PizzaType.Cheese && sizeType == SizeType.Large)
					{
						lCheesePizzas += quantity;
						continue Pizza;
					}
					if(pizzaType == PizzaType.Pepperoni && sizeType == SizeType.Small)
					{
						sPepPizzas += quantity;
						continue Pizza;
					}
					if(pizzaType == PizzaType.Pepperoni && sizeType == SizeType.Medium)
					{
						mPepPizzas += quantity;
						continue Pizza;
					}
					if(pizzaType == PizzaType.Pepperoni && sizeType == SizeType.Large)
					{
						lPepPizzas += quantity;
						continue Pizza;
					}
				}	
		}//While-Loop Size
		}//While-Loop Pizza
	}
}
