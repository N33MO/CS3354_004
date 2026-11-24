# Module 6 JUnit 6 Notes

Unit tests are small programs that check whether production code behaves correctly.

When reading a test, think of it as a question:

```text
If this method receives this input, should it return this value, change this object, or throw this exception?
```

## Start Here

Read the files in this order:

1. `src/main/java/module6/math/MathUtils.java`
2. `src/test/java/module6/math/MathUtilsTest.java`
3. `src/main/java/module6/grade/StudentGrade.java`
4. `src/test/java/module6/grade/StudentGradeTest.java`
5. `src/main/java/module6/bank/BankAccount.java`
6. `src/test/java/module6/bank/BankAccountTest.java`

Start with `MathUtils` because it has one small method and the tests clearly show Arrange, Act, Assert.

Then move to `StudentGrade` because its methods mostly return values. That makes the expected result easy to see.

Then move to `BankAccount` because it introduces object state. After calling `deposit()` or `withdraw()`, the test must check whether the balance changed correctly.

## Read Tests as Arrange, Act, Assert

Most tests in this module follow this pattern:

- `Arrange`
  Create the object and prepare the input.
- `Act`
  Call the method being tested.
- `Assert`
  Check whether the actual result matches the expected result.

Example: `deposit_shouldIncreaseBalance()`

- Arrange: start with a bank account that has `100.0`
- Act: deposit `50.0`
- Assert: check that the balance is now `150.0`

In `MathUtilsTest`, this pattern is very direct:

- Arrange: choose a number
- Act: call `MathUtils.isEven(number)`
- Assert: check whether the result is `true` or `false`

## Main JUnit Tools

- `@Test`
  Marks a method as a test method.

- `@ParameterizedTest`
  Runs the same test method multiple times with different input values.
  In `getLetterGrade_shouldReturnExpectedLetterForScore(...)`, each row gives one score and one expected letter grade.

- `@BeforeEach`
  Runs before every test method.
  In `BankAccountTest`, it creates a fresh account before each test so one test does not accidentally affect another test.

- `assertEquals(expected, actual)`
  Use this when the exact expected value is known.
  Examples: checking a balance or a letter grade.

- `assertTrue(...)` and `assertFalse(...)`
  Use these for yes/no conditions.

- `assertThrows(...)`
  Use this when invalid input should cause an exception.

- `assertNull(...)` and `assertNotNull(...)`
  Use these to check whether an object reference exists.

- `assertAll(...)`
  Use this when several related checks belong together.
  In `constructor_shouldCreateAccountWithOwnerAndInitialBalance()`, the test checks that the account exists, stores the owner, and stores the starting balance.
  In `constructor_shouldStoreStudentNameScoreAndLetterGrade()`, the test checks that one student object stores all of its important information correctly.

## Three Kinds of Test Cases

### Normal Cases

Normal cases test the behavior that should happen during regular use.

Examples:

- `testIsEven_returnsTrueForEvenNumbers`
- `deposit_shouldIncreaseBalance`
- `withdraw_shouldDecreaseBalance`
- `getLetterGrade_shouldReturnExpectedLetterForScore`
- `isPassing_shouldReturnTrueForScoreAtOrAbove60`

### Boundary Cases

Boundary cases test values right on the edge of a rule.

Examples:

- `90.0` should return `A`
- `89.99` should return `B`
- `60.0` should return `D`
- `59.99` should return `F`

Boundary tests matter because many bugs happen at cutoff values.

### Exception Cases

Exception cases test inputs that should be rejected.

Examples:

- depositing `0`
- withdrawing more money than the account has
- asking for a grade with a score below `0`
- asking for a grade with a score above `100`

For these cases, the program should throw an `IllegalArgumentException`.

## What to Notice in `module6.math`

Focus on this method:

- `isEven(int number)`

Notice that `MathUtilsTest` uses `@ParameterizedTest` with `@ValueSource`. The same test method runs once for each number in the list.

This is a good first unit test example because the production method is small, the input is simple, and the expected result is easy to predict.

## What to Notice in `module6.grade`

Focus on these methods:

- `getName()`
- `getScore()`
- `getLetterGrade()`
- `getLetterGrade(double score)`
- `isPassing()`

Notice how `StudentGradeTest` checks return values directly. For example, when the score is `90.0`, the expected result is `"A"`.

Also notice the boundary values. A score of `89.99` is close to an `A`, but it should still return `"B"`.

The `getLetterGrade_shouldReturnExpectedLetterForScore(...)` test is parameterized. Read each `@CsvSource` row as one mini test case: first the score, then the expected letter grade.

The `isPassing()` method is a boolean method. That makes it a natural place to use `assertTrue()` and `assertFalse()`.

## What to Notice in `module6.bank`

Focus on these methods:

- `getOwner()`
- `getBalance()`
- `deposit(double amount)`
- `withdraw(double amount)`

Notice that `deposit()` and `withdraw()` do not return a value. The test calls the method first, then checks the account balance afterward.

Also notice why `@BeforeEach` helps. Each test starts with a new `BankAccount("Jordan", 100.0)`, so the tests stay independent.

## Questions to Ask While Reading

- What method is being tested?
- What input is given?
- What result is expected?
- Should this test return a value, change object state, or throw an exception?
- Is this a normal case, boundary case, or exception case?
- Which assertion is the best fit?

## Practice

Try adding one new test:

- `withdraw_shouldAllowWithdrawingEntireBalance`
- `getLetterGrade_shouldReturnFForZero`
- `getLetterGrade_shouldReturnAForPerfectScore`

Before writing the test, predict:

- what input will be used?
- what result should happen?
- which assertion should check the result?
