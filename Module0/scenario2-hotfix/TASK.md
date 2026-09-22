# Incident ALG-089: last element missing from binary search results

**Assigned to:** you
**Repo:** `algotoolkit/`
**Starting branch:** `prod` (currently at `v0.4`)

## Context

**How this project releases:** `dev` is the integration branch where everyday
work happens. At each release, `dev` is merged into `prod` and tagged — that's
how `v0.4` got there. `prod` is what customers are running right now.

QA reports that `BinarySearch.search()` sometimes fails to find a value that
**is** in the array — specifically when the target turns out to be the last
remaining candidate the search narrows down to (e.g. searching for the
maximum value in the array). This regressed in `v0.3` ("optimize loop
bounds") and shipped again in `v0.4`, so it is live in production today.

Since that release, `dev` has moved on toward `v0.5`: Robin added
`interpolationSearch` and some debug logging. Note that `dev` still carries
the same bug — and someone left a `// TODO` on the exact line that's broken.

Run `git log --all --oneline --graph` before you start to see the shape of it.

## Your task

1. Branch a hotfix off `prod` (currently at `v0.4`).
2. Fix the bug in `BinarySearch.search()`.
3. Verify the fix: searching for the maximum value in the demo array in
   `Main.java` should now return its correct index instead of `-1`.
4. Ship the fix to `prod` as **`v0.4.1`** (tag it) as fast as possible.
5. Make sure the fix also lands on `dev`, so `v0.5` doesn't reintroduce the
   bug. Expect a small conflict here — `dev` already touched the same line.

## Acceptance criteria

- `prod` is tagged `v0.4.1` and contains the fix.
- `dev` contains the fix, `interpolationSearch`, and the debug logging —
  nothing was dropped or overwritten while resolving the conflict.
- `javac -d out $(find src -name "*.java") && java -cp out algotoolkit.Main`
  succeeds on both branches.

## Setup

After cloning, `dev` is only available as `origin/dev` (you're on `prod`).
Give yourself a local copy of it when you're ready for step 5:

```
git branch dev origin/dev
```
