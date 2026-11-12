# SOLID Principles — Reading Examples

These files are **reading material, not runnable programs.** Do not try to
compile them; `javac` will report errors, and that is expected.

Each file shows the same code twice:

```java
// BEFORE
class ShippingCalculator { ... }   // the design that violates the principle

// AFTER
class ShippingCalculator { ... }   // the same class, refactored
```

Java does not allow two classes with the same name in one file, so these
snippets cannot compile by design — keeping the name identical is what makes
the before-and-after comparison readable. Some bodies are also abbreviated with
`...`, and helper types such as `User` or `db` are implied rather than written
out.

## Layout

| Folder | Principle |
|---|---|
| `srp/` | Single Responsibility — a class should have one reason to change |
| `ocp/` | Open/Closed — open for extension, closed for modification |
| `lsp/` | Liskov Substitution — a subtype must honor its supertype's contract |
| `isp/` | Interface Segregation — no client forced to depend on methods it does not use |
| `dip/` | Dependency Inversion — depend on abstractions, not concretions |

Within each folder, `Demo1`–`Demo3` are worked examples, and `Demo4` is an
exercise: read the requirements in the comment, work out the refactoring
yourself, then compare with the `// AFTER` section. `lsp/` has two extra
examples, `Demo5` and `Demo6`.

For design-pattern code you *can* run, see `Module5/strategy/`.
