# Ticket ALG-142: Add quick sort to AlgoToolkit

**Assigned to:** you
**Repo:** `algotoolkit/`
**Starting branch:** `feature/quick-sort`

## Context

While you were working on quick sort on your own branch, Robin merged merge
sort into `dev`. `dev` and `feature/quick-sort` have diverged — you both
edited `SortAlgorithms.java` and `Main.java`.

## Your task

1. Bring `feature/quick-sort` up to date with the latest `dev` using a
   **rebase**, not a merge commit.
2. Resolve the conflicts you hit in both files — keep both algorithms.
3. Once your branch is rebased and conflict-free, integrate it into `dev`.

## Acceptance criteria

- `dev` contains `bubbleSort`, `mergeSort`, and `quickSort`.
- `Main.java` demonstrates all three sorts.
- `dev`'s history has no unnecessary merge commit from the catch-up step —
  landing your branch should be a clean fast-forward.
- `javac -d out $(find src -name "*.java") && java -cp out algotoolkit.Main`
  runs without errors and prints all three sorted results correctly.

## Setup

After cloning, `dev` is only available as `origin/dev` (you're on
`feature/quick-sort`). Give yourself a local copy of it:

```
git branch dev origin/dev
```
