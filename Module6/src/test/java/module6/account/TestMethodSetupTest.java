package module6.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMethodSetupTest {
    private Account account;

    @BeforeEach
    void createMethodEnvironment() {
        account = new Account();
        System.out.println("Set Up Method Environment");
    }

    @AfterEach
    void clearMethodEnvironment() {
        account = null;
        System.out.println("Cleared Method Environment");
    }

    @Test
    void testTransact_updatesBalanceWithinEachTestSetup() {
        assertEquals(5, account.transact(5).getBalanceAmount(), "Test Failed Message");
    }

    @Test
    void testTransact_returnsSameAccountInstanceForChaining() {
        Account accountOne = new Account();
        Account result = accountOne.transact(1000).transact(-1000);

        assertSame(accountOne, result, "Transact should support chaining");
        assertEquals(1000, result.getBalanceAmount(), "Negative amounts should be ignored");
    }
}
