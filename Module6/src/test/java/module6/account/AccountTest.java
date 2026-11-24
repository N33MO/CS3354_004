package module6.account;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account();
    }

    @Test
    void testTransact_addsPositiveAmountToBalance() {
        assertEquals(5, account.transact(5).getBalanceAmount());
    }

    @Test
    void testTransact_ignoresNegativeAmount() {
        assertEquals(0, account.transact(-5).getBalanceAmount());
    }

    @Test
    void testTransact_supportsChainedTransactions() {
        assertEquals(15, account.transact(5).transact(10).getBalanceAmount());
    }
}
