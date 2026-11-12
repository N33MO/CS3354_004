package Module5.solid.isp;

public class Demo2 {
    
}

/**
 * IWorker groups work, eat, and sleep into one interface. RobotWorker 
 * only works — but is forced to implement biological behaviors that 
 * make no sense for a machine.
 */

// BEFORE
interface IWorker {
  void work();
  void eat();
  void sleep();
}

class HumanWorker implements IWorker {
  public void work()  { System.out.println("Working..."); }
  public void eat()   { System.out.println("Eating..."); }
  public void sleep() { System.out.println("Sleeping..."); }
}

// Robots work — but don't eat or sleep
class RobotWorker implements IWorker {
  public void work()  { System.out.println("Working..."); }
  public void eat() {
    throw new UnsupportedOperationException();
  }
  public void sleep() {
    throw new UnsupportedOperationException();
  }
}

// AFTER
interface IWorkable  { void work(); }
interface IFeedable  { void eat(); }
interface ISleepable { void sleep(); }

class HumanWorker
    implements IWorkable, IFeedable, ISleepable {
  public void work()  { System.out.println("Working..."); }
  public void eat()   { System.out.println("Eating..."); }
  public void sleep() { System.out.println("Sleeping..."); }
}

// RobotWorker only implements
// what it genuinely does
class RobotWorker implements IWorkable {
  public void work() { System.out.println("Working..."); }
  // eat() and sleep() do not exist here
}

