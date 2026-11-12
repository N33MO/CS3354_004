package Module5.solid.isp;

public class Demo3 {
    
}

/**
 * IUserService bundles read, write, notification, and export 
 * operations. GuestService only needs to read users — yet it is exposed
 * to delete and export operations it should never call.
 */


// BEFORE
interface IUserService {
  User getUser(int id);
  void createUser(User user);
  void deleteUser(int id);
  void sendEmail(User user);
  void exportToCSV();
}

class AdminService implements IUserService {
  // implements all — fine
}

// GuestService only reads users,
// but is forced to implement everything
class GuestService implements IUserService {
  public User getUser(int id) { ... }
  public void createUser(User user) {
    throw new UnsupportedOperationException();
  }
  public void deleteUser(int id) {
    throw new UnsupportedOperationException();
  }
  public void sendEmail(User user) {
    throw new UnsupportedOperationException();
  }
  public void exportToCSV() {
    throw new UnsupportedOperationException();
  }
}


// AFTER
interface IUserReader {
  User getUser(int id);
}
interface IUserWriter {
  void createUser(User user);
  void deleteUser(int id);
}
interface IUserNotifier {
  void sendEmail(User user);
}
interface IUserExporter {
  void exportToCSV();
}

class AdminService implements IUserReader,
    IUserWriter, IUserNotifier, IUserExporter {
  // implements all
}

// GuestService only gets what it needs
class GuestService implements IUserReader {
  public User getUser(int id) { ... }
  // deleteUser() does not exist here
}
