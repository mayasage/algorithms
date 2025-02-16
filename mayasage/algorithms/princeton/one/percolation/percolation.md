# Percolation

## What's Percolation?

I am dropping water on the top row of a 3x3 grid.

        X       X       X
        X       X       X
        X       X       X

If water reaches the bottom row, the system is said to "percolate."  
"Open" cells, and check "isOpen" in O(1).  
A cell "isFull" if it's filled with water.

## Requirements

| Operation  | Time Complexity |
|:----------:|:---------------:|
| percolates |      O(1)       |
|   isFull   |      O(1)       |
|    open    |      O(1)       |
|   isOpen   |      O(1)       |

## Solution

### Connecting cells

There are a bunch of cells.  
Connecting cells and finding out if they're connected is O(1).

        0       1       2       3       4       5
        X       X       X       X       X       X

Connecting two cells is as simple as changing a pointer.

Initially, every node is connected to itself.

        0       1       2       3       4       5
        0       1       2       3       4       5

Connecting 0 to 1.

        0       1
        1       1

This creates a hidden tree-like structure, and causes "isConnected" to become O(N).  
Every tree is represented by a unique root.

1. Do not create large trees.

        - 3 → 4
        - connect 8
        - 3 → 4 → 8 ❌ 
        - 3 → 4 ← 8 ✅
        - connect smaller tree into the larger

2. Convert indirect connections to direct connections lazily.

        - 1 → 2 → 3 → 4
        - 2 is not root, then make 1 → 3
        - 3 is not root, so make 2 → 4
        - result = 1 → 3 → 4 ← 2

This is WeightedUnionFind.

### isFull(x, y)

When (x, y) is connected to any cell in the top row.

                T
        X       X       X
        X       X       X
        X       X       X

- T is the water source
- Any open cell in the first row is connected to T
- If (x, y) is connected to T, it's full.

### percolates

                T
        X       X       X
        X       X       X
        X       X       X
                B

- Every cell in the bottom row is connected to B
- If T is connected to B, it's full.

### Finale

isFull will fail if B exists and the system percolates.

        - Imagine (2, 3) is connected to B, but not to T. 
        - isFull(2, 3) will wrongly return true
        - This is called the backwater problem. 

The solution is to create two duplicate WeightedUnionFinds.  
One will contain both T and B, and it'll check if the system percolates.  
The other one will contain only the node T, and it'll check if the cell is full. 
