# Object-Oriented Design & Programming — Code Examples

Code examples and in-class demos for **Object-Oriented Design & Programming**,
Section 2325.004, Fall 2026 — Texas State University.

Material is added here as the semester progresses, so pull regularly to stay current.

## Getting the code

```bash
# First time — clone the repo:
git clone https://github.com/N33MO/CS3354_004.git
cd CS3354_004

# Afterwards — get the latest updates:
git pull
```

Use `git fetch` if you want to download new commits *without* merging them into
your working copy; `git pull` downloads and merges in one step.

## Compiling and running an example

Each file declares a package matching its folder path, so compile and run from
the **repository root** — not from inside the example's folder:

```bash
# Compile — pass the path to the .java file:
javac Module1/JavaProgramExample/FirstExample.java

# Run — use the full class name with dots, and no .java extension:
java Module1.JavaProgramExample.FirstExample
```

To keep the generated `.class` files out of the source folders, send them to a
build directory instead:

```bash
javac -d out Module1/JavaProgramExample/FirstExample.java
java -cp out Module1.JavaProgramExample.FirstExample
```

> If you `cd` into the example's folder first, `java` will fail with
> *"Could not find or load main class"* — the package name has to match the
> directory you run it from, which is the repository root.

Examples that use their own `src/` layout include a README with specific build
instructions.

## Contents

| Folder | Topic |
|---|---|
| `Module0/` | Git practice — rebasing, hotfix releases, and undoing unwanted commits |
| `Module1/` | Java basics — classes, constructors, methods, arrays, console and file I/O |

Additional modules are published here throughout the semester.

## License

This repository is for educational/class use. All rights reserved.
