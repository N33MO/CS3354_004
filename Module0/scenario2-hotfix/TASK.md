# Incident ALG-089: last element missing from binary search results

**Assigned to:** you
**Repo:** `algotoolkit/`
**Starting branch:** `prod` (currently at `v0.4`)

## Context

QA reports that `BinarySearch.search()` sometimes fails to find a value that
**is** in the array — specifically when the target turns out to be the last
remaining candidate the search narrows down to (e.g. searching for the
maximum value in the array). This regressed in `v0.3` ("optimize loop
bounds") and is still present in the current prod release, `v0.4`.

Meanwhile, `dev` has diverged and is working toward `v0.5`. It branched off
after the bug was introduced, so it also contains the bug, plus unrelated
new work (`interpolationSearch`, plus some debug logging in `search()`).

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
