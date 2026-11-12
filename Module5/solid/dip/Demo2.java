package Module5.solid.dip;

public class Demo2 {
    
}

/**
 * UserRepository creates a MySQLDatabase directly — coupling the data 
 * access layer to one specific database engine and making it impossible
 * to swap or test in isolation.
 */

// BEFORE
class MySQLDatabase {
  public void save(String data) {
    System.out.println("MySQL save: " + data);
  }
  public String load(int id) { return "MySQL data: " + id; }
}

// UserRepository is permanently tied to MySQL
class UserRepository {
  private MySQLDatabase database = new MySQLDatabase(); // hardcoded

  public void saveUser(String data) {
    database.save(data);
  }
  public String loadUser(int id) {
    return database.load(id);
  }
}

// AFTER
interface IDatabase {
  void save(String data);
  String load(int id);
}

class MySQLDatabase implements IDatabase {
  public void save(String data) { ... }
  public String load(int id) { return ...; }
}

class PostgreSQLDatabase implements IDatabase {
  public void save(String data) { ... }
  public String load(int id) { return ...; }
}

// No real DB needed in tests
class InMemoryDatabase implements IDatabase {
  public void save(String data) { ... }
  public String load(int id) { return ...; }
}

class UserRepository {
  private IDatabase database;
  public UserRepository(IDatabase database) {
    this.database = database;
  }
  public void saveUser(String data) {
    database.save(data);
  }
  public String loadUser(int id) {
    return database.load(id);
  }
}