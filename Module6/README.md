# Module 6

This module now follows a more production-like Java project layout:

```text
Module6/
├── lib/
├── src/
│   ├── main/java/
│   │   └── module6/...
│   └── test/java/
│       └── module6/...
└── .vscode/settings.json
```

## Why This Structure Is Closer to Industry

- `src/main/java` contains production code
- `src/test/java` contains test code
- packages use short, lowercase names
- test classes mirror the package path of the code they verify

This is the standard layout used by most Maven and Gradle Java projects, even though this demo still uses a standalone JUnit jar for simplicity.

## Package Layout

- `module6.assertions` - assertion examples
- `module6.annotations` - annotation and test lifecycle examples
- `module6.myclass` - basic class testing example
- `module6.math` - parameterized test example
- `module6.account` - test lifecycle and setup examples
- `module6.bank` - bank account testing example
- `module6.grade` - grade calculation testing example

## Student Notes

For guided notes on reading the JUnit demo examples, see `JUnit6StudentNotes.md`.

## VS Code Setup

Open `Module6` as the project root in VS Code.

The committed `.vscode/settings.json` file points VS Code at the new source folders and the bundled JUnit jar.

If test icons do not appear after the refactor, run:

```text
Java: Clean Java Language Server Workspace
```

Then reload VS Code when prompted.

## How to Compile and Run Tests

Compile everything into `bin`:

```text
javac -cp "lib/junit-platform-console-standalone-6.0.3.jar" -d bin $(find src -name "*.java")
```

Run the full test suite:

```text
java -jar lib/junit-platform-console-standalone-6.0.3.jar execute --class-path bin --scan-class-path
```

You can also run individual tests directly from VS Code using the gutter icons.
