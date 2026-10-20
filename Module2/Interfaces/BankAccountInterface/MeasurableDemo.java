package Module2.Interfaces.BankAccountInterface;

/**
   This program demonstrates the measurable BankAccount and Country classes.
*/
public class MeasurableDemo
{
   public static void main(String[] args)
   {
      Measurable[] accounts = new Measurable[3];
      accounts[0] = new BankAccount(0);
      accounts[1] = new BankAccount(10000);
      accounts[2] = new BankAccount(2000);

      System.out.println("Average balance: " 
         + Data.average(accounts));

      Measurable[] countries = new Measurable[3];
      countries[0] = new Country("Uruguay", 176220);
      countries[1] = new Country("Thailand", 514000);
      countries[2] = new Country("Belgium", 30510);

      System.out.println("Average area: " 
         + Data.average(countries));
   }

}
