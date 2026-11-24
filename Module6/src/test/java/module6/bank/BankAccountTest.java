package module6.bank;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit 6 tests for BankAccount.
 *
 * This class is useful for demonstrating:
 * - @BeforeEach
 * - state changes
 * - exception testing with assertThrows()
 */
class BankAccountTest {
    private static final double DELTA = 0.0001;

    private BankAccount account;

    @BeforeEach
    void setUp() {
        // Create a fresh account before every test.
        // This keeps tests independent from one another.
        account = new BankAccount("Jordan", 100.0);
    }

    @Test
    void constructor_shouldCreateAccountWithOwnerAndInitialBalance() {
        // Arrange and Act
        BankAccount newAccount = new BankAccount("Alex", 250.0);

        // Assert
        assertAll(
            () -> assertNotNull(newAccount),
            () -> assertEquals("Alex", newAccount.getOwner()),
            () -> assertEquals(250.0, newAccount.getBalance(), DELTA)
        );
    }

    @Test
    void constructor_shouldThrowExceptionWhenOwnerIsNull() {
        // Arrange, Act, Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new BankAccount(null, 100.0)
        );

        assertEquals("Owner name cannot be null or blank.", exception.getMessage());
    }

    @Test
    void constructor_shouldThrowExceptionWhenOwnerIsBlank() {
        // Arrange, Act, Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new BankAccount("   ", 100.0)
        );

        assertEquals("Owner name cannot be null or blank.", exception.getMessage());
    }

    @Test
    void constructor_shouldThrowExceptionWhenInitialBalanceIsNegative() {
        // Arrange, Act, Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new BankAccount("Jordan", -10.0)
        );

        assertEquals("Initial balance cannot be negative.", exception.getMessage());
    }

    @Test
    void getBalance_shouldReturnCurrentBalance() {
        // Arrange
        // The account starts at 100.0 because of @BeforeEach.

        // Act
        double balance = account.getBalance();

        // Assert
        assertEquals(100.0, balance, DELTA);
    }

    @Test
    void deposit_shouldIncreaseBalance() {
        // Arrange
        double depositAmount = 50.0;

        // Act
        account.deposit(depositAmount);

        // Assert
        assertEquals(150.0, account.getBalance(), DELTA);
    }

    @Test
    void deposit_shouldThrowExceptionWhenAmountIsZero() {
        // Arrange, Act, Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> account.deposit(0.0)
        );

        assertEquals("Deposit amount must be greater than 0.", exception.getMessage());
    }

    @Test
    void deposit_shouldThrowExceptionWhenAmountIsNegative() {
        // Arrange, Act, Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> account.deposit(-25.0)
        );

        assertEquals("Deposit amount must be greater than 0.", exception.getMessage());
    }

    @Test
    void withdraw_shouldDecreaseBalance() {
        // Arrange
        double withdrawAmount = 40.0;

        // Act
        account.withdraw(withdrawAmount);

        // Assert
        assertEquals(60.0, account.getBalance(), DELTA);
    }

    @Test
    void withdraw_shouldThrowExceptionWhenAmountIsZero() {
        // Arrange, Act, Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> account.withdraw(0.0)
        );

        assertEquals("Withdrawal amount must be greater than 0.", exception.getMessage());
    }

    @Test
    void withdraw_shouldThrowExceptionWhenAmountIsNegative() {
        // Arrange, Act, Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> account.withdraw(-5.0)
        );

        assertEquals("Withdrawal amount must be greater than 0.", exception.getMessage());
    }

    @Test
    void withdraw_shouldThrowExceptionWhenInsufficientFunds() {
        // Arrange, Act, Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> account.withdraw(150.0)
        );

        assertEquals("Cannot withdraw more than the current balance.", exception.getMessage());
    }
}
