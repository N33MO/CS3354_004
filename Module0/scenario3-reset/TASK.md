# Ticket ALG-201: anagram check — scrap the recursive approach

**Assigned to:** you
**Repo:** `algotoolkit/`
**Starting branch:** `feature/anagram-check`

## Context

You started implementing `StringUtils.isAnagram()` using a recursive,
permutation-generating approach: generate every permutation of the first
string and check whether the second string is among them. It works, but
it's O(n!) — unusably slow for anything but the shortest strings — and
leadership has decided not to ship it. Your last 2 commits on this branch
contain that approach.

Nobody else has pulled this branch, so there's no shared history to worry
about — you can drop those commits outright instead of adding new commits
on top to undo them.

Run `git log --oneline` before you start to see the commits you're about
to remove.

## Your task

1. Remove the last 2 commits from `feature/anagram-check`.
2. Replace the recursive approach with the implementation below (a linear
   character-count approach), committed cleanly.
3. Merge your branch into `dev`.

## Replacement implementation

This is the version leadership wants shipped. Replace `isAnagram` in
`StringUtils.java` with it:

```java
public static boolean isAnagram(String a, String b) {
    if (a == null || b == null || a.length() != b.length()) {
        return false;
    }

    int[] counts = new int[128];
    for (int i = 0; i < a.length(); i++) {
        counts[Character.toLowerCase(a.charAt(i))]++;
        counts[Character.toLowerCase(b.charAt(i))]--;
    }
    for (int count : counts) {
        if (count != 0) {
            return false;
        }
    }
    return true;
}
```

## Acceptance criteria

- `feature/anagram-check`'s history no longer contains the recursive
  permutation approach — check with `git log`.
- `dev` contains the character-count implementation after your merge.
- `javac -d out $(find src -name "*.java") && java -cp out algotoolkit.Main`
  runs and prints `true` for `isAnagram("listen", "silent")`.

## Setup

After cloning, `dev` is only available as `origin/dev` (you're on
`feature/anagram-check`). Give yourself a local copy of it:

```
git branch dev origin/dev
```

---

# Solution

*Try the task yourself first — the whole point is getting stuck and working
through it. Use this when you want to check your approach or get unstuck.*

## Step by step

```bash
# 0. see what you're about to remove — note the top 2 commits
git log --oneline

# 1. drop them, and the working-tree changes along with them
git reset --hard HEAD~2

# 2. confirm: isAnagram is back to its TODO stub, and git log is 2 shorter
git log --oneline
```

**Don't be alarmed if `git log --all` still shows the dropped commits.** Your
branch no longer points at them, but `origin/feature/anagram-check` — your
clone's record of what the remote had — still does. The remote hasn't been told
about your reset. Plain `git log` shows your branch, and that's what the
acceptance criteria check.

`HEAD~2` means "two commits before where I am now." `--hard` also resets your
working files to match — which is what you want here, since the recursive code
should disappear from the files too, not just from the history.

```bash
# 3. paste in the replacement implementation above, then verify
javac -d out $(find src -name "*.java") && java -cp out algotoolkit.Main
#    -> isAnagram("listen", "silent") = true

# 4. commit it
git commit -am "Implement isAnagram using character counts"

# 5. land it on dev
git checkout dev
git merge feature/anagram-check
#    -> "Fast-forward", no conflicts
```

## Why reset is safe here — and when it isn't

`git reset` **rewrites history**: those 2 commits are simply gone from the
branch, as if you'd never made them. That's exactly what you want for
throwaway work on your own branch, and it's why the result is clean — no
"revert" commits cluttering the log with an approach nobody shipped.

But it's only safe because **nobody else has this branch**. If you had pushed
it and a teammate had pulled it, deleting those commits would leave their
branch pointing at commits yours no longer has, and the next push would fight
with theirs. The rule of thumb:

- **Your own unshared branch** → `reset` is fine, and gives the cleaner history.
- **A shared branch like `dev` or `prod`** → never `reset`. Add a new commit
  that undoes the change instead, so everyone's history still agrees.

### If you delete the wrong thing

`git reset --hard` discards uncommitted work permanently, but the *commits*
themselves stick around for a couple of weeks. `git reflog` shows everywhere
`HEAD` has been, so you can recover:

```bash
git reflog                  # find the commit hash from before the reset
git reset --hard <hash>     # put the branch back
```
