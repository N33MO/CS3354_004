package Module2.Interfaces.BankAccountInterface;

public class Data {
    /**
         Computes the average of the measures of the given objects.
        @param objects an array of Measurable objects
        @return the average of the measures
    */
    public static double average(Measurable[] objects) {
        if (objects.length == 0) {
            return 0;
        }

        double sum = 0;
        for (Measurable obj : objects) {
            sum += obj.getMeasure();
        }

        return sum / objects.length;
    }
}
