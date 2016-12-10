/**Author: Stone Daniel
 * Submission Date: 10/6/16 
 * This is the interface class PizzaStore. In it, I declare many variables. These variables are final constants.
 * they are implicitly final,static, and public. I declared a two dimensional array which stores the different
 * prices for each pizza.*/
public interface PizzaStore
    {
	//These variables are final because they won't be changing in later classes.
        final double TAX = 0.07;
        final double S_VEGETARIAN_PRICE = 6.50;
        final double M_VEGETARIAN_PRICE = 10.50;
        final double L_VEGETARIAN_PRICE= 13.50;
        final double S_CHEESE_PRICE = 5.50;
        final double M_CHEESE_PRICE = 8.00;
        final double L_CHEESE_PRICE = 10.00;
        final double S_PEPPERONI_PRICE = 6.00;
        final double M_PEPPERONI_PRICE = 8.50;
        final double L_PEPPERONI_PRICE = 12.00;
        final double DRINK_PRICE = 2.00;
        final double SALAD_PRICE = 4.50;
        final double SOUP_PRICE = 5.00;
        final double[][] PIZZA_PRICES = new double[][]
        		{
        	{S_VEGETARIAN_PRICE,M_VEGETARIAN_PRICE,L_VEGETARIAN_PRICE},
        	{S_CHEESE_PRICE,M_CHEESE_PRICE,L_CHEESE_PRICE},
        	{S_PEPPERONI_PRICE,M_PEPPERONI_PRICE,L_PEPPERONI_PRICE},
        		};
        public double calculateTotal();
        public void printHeading();
        public void printInvoice();
        public void displayMenu();
      
    }



