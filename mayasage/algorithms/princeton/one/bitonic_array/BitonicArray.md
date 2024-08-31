# Question: Search in Bitonic Array

An array is bitonic if it is comprised of an increasing sequence of integers
followed immediately by a decreasing sequence of integers. Write a program that,
given a bitonic array of n distinct integer values, determines whether a given
integer is in the array.

- Standard version: Use ∼3lgn compares in the worst case.

- Signing bonus: Use ∼2lgn compares in the worst case (and prove that no
  algorithm can guarantee to perform fewer than ∼2lgn compares in the worst
  case).

## Solution

### Standard version (3 lg(N))

A bitonic array is divided into increasing order, and then decreasing order.
So we can do:

- binary (ascending) search in the increasing part, and
- binary (decreasing) search in the decreasing part.

So, to find the element, we do:

- binary search to find peak (~lg(N))
- binary search to the left of peak (~lg(N))
- binary search to the right of peak (~lg(N))

Total Time Complexity = ~ 3 lg(N)

### 2 lg(N)

Try to skip as much as possible.  

What can you skip ?

1. You are m.
2. If you are in ascending order (a[m] > a[m - 1]), and (t > a[m]), you can 
   skip left.
3. If you are in descending order (a[m] > a[m + 1]), and (t > a[m]), you can 
   skip right.
4. Otherwise, search both left and right.

Why 2 lg(N) ?

- We're not searching every number.
- If I'm in ascending then I'll skip all values below target.
- If I'm in descending then I'll skip all values below target.
- We're always cutting the array in half, and searching the mid.
- There are only 2 places where we're searching in the entire algorithm, 
  exit condition & mid.
- It is guaranteed that we'll skip values eventually because we're 
  continually recursing by cutting list in half.
