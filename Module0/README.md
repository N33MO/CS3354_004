# Module 0: Git Practice — Joining a Team Mid-Project

Three small, independent Java 21 repos, each dropping you into a different
real-world Git situation as if you were a new member of the "AlgoToolkit"
team. Each one is self-contained (its own branches, commits, and history) —
picking one up doesn't affect the others.

| Scenario | Folder | Skill practiced | Starting branch |
|---|---|---|---|
| 1. Catching up before merging | `scenario1-rebase/` | `rebase` + conflict resolution | `feature/quick-sort` |
| 2. Shipping a hotfix | `scenario2-hotfix/` | branching from a release tag, backporting a fix | `prod` |
| 3. Scrapping bad work | `scenario3-reset/` | `reset` on an unshared branch | `feature/anagram-check` |

## Getting started

Each scenario folder contains:

- `TASK.md` — your assignment brief (read this first).
- `algotoolkit.bundle` — the repo itself, packaged as a single file.

Clone your own working copy from the bundle (this behaves exactly like
cloning from a real remote — you'll land on the branch you're meant to
start on, with the other branches available as `origin/<name>`):

```
git clone Module0/scenario1-rebase/algotoolkit.bundle algotoolkit
cd algotoolkit
```

(swap in whichever scenario folder you were assigned). Do your work inside
that clone — it's a real, independent Git repo, so nothing you do here
touches the bundle file itself or the other scenarios.

All three projects build and run the same way:

```
javac -d out $(find src -name "*.java")
java -cp out algotoolkit.Main
```
