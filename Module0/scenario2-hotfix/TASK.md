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

## The fix

This exercise is about the Git workflow, not about hunting the bug down — so
here is the fix. In `src/algotoolkit/BinarySearch.java`, inside `search()`:

```java
// before — stops before checking the final candidate
while (low < high) {

// after
while (low <= high) {
```

Why it matters: once `low` and `high` converge on a single remaining index,
`low < high` is already false, so that last element is never compared. Searching
for `91` — the largest value in the demo array — returns `-1` instead of `10`.

## Workflow

```bash
# 0. get your bearings
git log --all --oneline --graph

# 1. branch the hotfix off the RELEASED code, not off dev
git checkout prod
git checkout -b hotfix/binary-search-bounds

# 2. apply the one-line fix above, then prove it works
javac -d out $(find src -name "*.java") && java -cp out algotoolkit.Main
#    expect:  Searching for 91 -> index 10      (it was -1 before)

# 3. commit it
git commit -am "Fix binary search missing last remaining candidate"

# 4. ship it to prod as v0.4.1
git checkout prod
git merge --no-ff hotfix/binary-search-bounds
git tag v0.4.1

# 5. backport to dev so v0.5 doesn't ship the bug all over again
git branch dev origin/dev        # first time only — see Setup below
git checkout dev
git merge hotfix/binary-search-bounds
#    -> CONFLICT in BinarySearch.java
```

### Resolving the conflict in step 5

Git will show your fixed line against Robin's `TODO`-commented version:

```java
<<<<<<< HEAD
        while (low < high) { // TODO: revisit once interpolation search lands
=======
        while (low <= high) {
>>>>>>> hotfix/binary-search-bounds
```

Keep the fix and drop the stale `TODO` — it has now been dealt with. Delete all
three marker lines, then mark it resolved and finish the merge:

```bash
git add src/algotoolkit/BinarySearch.java
git commit
```

Before you commit, check that Robin's `interpolationSearch` method and debug
logging are still in the file. Resolving a conflict by deleting the other
person's work is the classic way to silently undo a teammate's changes.

## Why this workflow

- **Branch from `prod`, not `dev`.** Branching off `dev` would drag unreleased
  `v0.5` work into a production release.
- **A hotfix has to land in two places.** Fix only `prod` and the bug quietly
  returns the moment `v0.5` ships from `dev`.
- **Tag what you shipped.** `v0.4.1` marks the patch release, so later you can
  run `git diff v0.4 v0.4.1` and see exactly what changed in production.

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
