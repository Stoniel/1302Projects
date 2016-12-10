/**Author: Stone Daniel
 * Submission Date: 10/6/16
 * This is the abstract class Order which declares the methods to be inherited by the child class CustomerOrder.
 * I declared the int counter variable as static in order to prevent the loss of information when I create a 
 * new object.  */
public abstract class Order implements PizzaStore
{
static protected int counter = 0;
public abstract void displayMenu();
public abstract void printHeading();
public abstract void wipeVars();
public abstract void output();
public abstract void displaySession();
public void setCounter()
{
	counter++;
}
public int getCounter()
{
	return counter;
}


}
