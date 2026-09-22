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

## Your task

1. Remove the last 2 commits from `feature/anagram-check`.
2. Replace the recursive approach with the implementation below (a linear
   character-count approach), committed cleanly.
3. Merge your branch into `dev`.

## Alternative implementation to add

Replace the body of `isAnagram` in `StringUtils.java` with:

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
