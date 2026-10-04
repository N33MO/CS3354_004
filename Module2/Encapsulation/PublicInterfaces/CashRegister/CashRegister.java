package Module2.Encapsulation.PublicInterfaces.CashRegister;
/**
   A simulated cash register that tracks the item count and
   the total amount due.
*/
public class CashRegister
{
   // private data--see Section 9.5

   /**
      Adds an item to this cash register.
      @param price the price of this item
   */
   public void addItem(double price)
   {
      // implementation--see Section 9.6
   }

   /**
      Gets the price of all items in the current sale.
      @return the total amount
   */
   public double getTotal()
   {
      // implementation--see Section 9.6
      return 0;
   }
   
   /**
      Gets the number of items in the current sale.
      @return the item count
   */
   public int getCount()
   {
      // implementation--see Section 9.6
      return 0;
   }

   /**
      Clears the item count and the total.
   */
   public void clear()
   {
      // implementation--see Section 9.6
   }
}