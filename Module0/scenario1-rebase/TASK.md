# Ticket ALG-142: Add quick sort to AlgoToolkit

**Assigned to:** you
**Repo:** `algotoolkit/`
**Starting branch:** `feature/quick-sort`

## Context

While you were working on quick sort on your own branch, Robin merged merge
sort into `dev`. `dev` and `feature/quick-sort` have diverged — you both
edited `SortAlgorithms.java` and `Main.java`.

Run `git log --all --oneline --graph` before you start to see the split.

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

---

# Solution

*Try the task yourself first — the whole point is getting stuck and working
through it. Use this when you want to check your approach or get unstuck.*

## Step by step

```bash
# 0. get your bearings
git log --all --oneline --graph

# 1. be on your own branch
git checkout feature/quick-sort

# 2. replay YOUR commits on top of the latest dev
git rebase dev
#    -> CONFLICT in Main.java and SortAlgorithms.java
```

Note the direction: `git rebase dev` is run **from** your feature branch, and
`dev` is what you're replaying onto. Running it from `dev` does the opposite of
what you want.

## Resolving the conflicts

Both files conflict, each in two places, because you and Robin added your
methods in the same spot. In `SortAlgorithms.java`:

```java
<<<<<<< HEAD
 * Available algorithms: bubble sort, merge sort.
=======
 * Available algorithms: bubble sort, quick sort.
>>>>>>> 5bd437a (Add quick sort (WIP))
```

`HEAD` here is `dev` — the side you're replaying **onto** — and the bottom half
is your own commit being replayed. That feels backwards during a rebase, and
it trips up almost everyone the first time.

Keep **both** algorithms everywhere — the comment should end up listing all
three, and both `mergeSort` and `quickSort` must survive in the file. Do the
same in `Main.java`, where both of you added a demo block.

Then stage the resolved files and continue:

```bash
git add src/algotoolkit/SortAlgorithms.java src/algotoolkit/Main.java
git rebase --continue
```

**`git add` is required.** Editing the file isn't enough — git can't tell
"finished resolving" from "still editing," so staging is how you say you're
done. If `--continue` refuses, run `git status`: anything still under
*Unmerged paths* needs `git add`. To bail out and start over at any point,
use `git rebase --abort`.

The editor will open with the old commit message, `Add quick sort (WIP)`.
Drop the `(WIP)` — it's about to land on a shared branch as finished work.

## Landing it on dev

```bash
# confirm it builds first
javac -d out $(find src -name "*.java") && java -cp out algotoolkit.Main
#    -> prints bubble, merge, AND quick sort results

git checkout dev
git merge feature/quick-sort
#    -> "Fast-forward"
```

## Why this workflow

- **"Fast-forward" is the proof the rebase worked.** Your commits now sit
  directly on top of dev's tip, so there's nothing to merge — dev's pointer
  just slides forward. If you get a merge commit instead, the rebase didn't
  take effect.
- **Rebase rewrites your commits**, which is why it's safe here: nobody else
  has pulled `feature/quick-sort`. Never rebase a branch others are using.
- **A rebase is a good moment to tidy commit messages**, since git is
  rewriting those commits anyway — you get the cleanup for free.
