package Module2.Interfaces.BankAccountInterface;

/**
   Describes any class whose objects can be measured.
*/
public interface Measurable
{
   /**
      Computes the measure of the object.
      Even though we do not have access modifiers here, the method is 
      public by default in an interface.
      @return the measure
   */
   double getMeasure();
}
