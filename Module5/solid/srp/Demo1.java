package Module5.solid.srp;

public class Demo1 {
  
}


/**
* UserManager handles both database persistence and email delivery — 
* two responsibilities that change for entirely different reasons.
*/

// BEFORE
class UserManager {
  public void saveUser(User user) {
    db.save(user);
  }
  public void sendWelcomeEmail(User user) {
    emailClient.send(
      user.getEmail(), "Welcome!"
    );
  }
}

// AFTER
class UserRepository {
  public void saveUser(User user) {
    db.save(user);
  }
}

class EmailService {
  public void sendWelcomeEmail(User user) {
    emailClient.send(
      user.getEmail(), "Welcome!"
    );
  }
}


