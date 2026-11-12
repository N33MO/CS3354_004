package Module5.solid.isp;

public class Demo1 {
    
}

/**
 * IMachine bundles print, scan, and fax into one interface. HomePrinter
 * only prints — yet it is forced to implement all three methods.
 */

// BEFORE
interface IMachine {
  void print(Document doc);
  void scan(Document doc);
  void fax(Document doc);
}

class OfficePrinter implements IMachine {
  public void print(Document doc) { ... }
  public void scan(Document doc)  { ... }
  public void fax(Document doc)   { ... }
}

// HomePrinter only prints — forced to
// implement scan() and fax() anyway
class HomePrinter implements IMachine {
  public void print(Document doc) { ... }
  public void scan(Document doc) {
    throw new UnsupportedOperationException();
  }
  public void fax(Document doc) {
    throw new UnsupportedOperationException();
  }
}


// AFTER
interface IPrinter { void print(Document doc); }
interface IScanner { void scan(Document doc); }
interface IFax     { void fax(Document doc); }

class OfficePrinter implements IPrinter, IScanner, IFax {
  public void print(Document doc) { ... }
  public void scan(Document doc)  { ... }
  public void fax(Document doc)   { ... }
}

// HomePrinter only implements
// what it genuinely supports
class HomePrinter implements IPrinter {
  public void print(Document doc) { ... }
  // scan() and fax() do not exist here
}