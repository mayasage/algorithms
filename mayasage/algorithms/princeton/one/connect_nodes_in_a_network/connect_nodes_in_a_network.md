# Connect Nodes In a Network

## The Problem

There are many nodes in a network, find if they are connected.  

Example:

A B C  
D E F  
G H I

Are A and I connected?

Connected means:

- Reflexive: Every node is connected to itself.
- Symmetric: If A is connected to B, then B is also connected to A.
- Transitive: If A is connected to B, and B is connected to C, then A is also connected to C.

## Solution

Start at A, touch every node till you find I.  
There are N nodes in the system, so time complexity will be O(N^2).  
If you have billions of nodes in the system, this calculation is impossible.  
The problem is unsolvable at this point of time.

To find a solution, model the problem first.

### Problem Model

The number of nodes in the network and their relevant positions is all that matters.

Solution-the methods to be implemented

```java
public interface Solution {
        void connectTwoNodes(int node1Position, int node2Position);

        boolean areTwoNodesConnected(int node1Position, int node2Position);
}
```

## Solution 1

A B C  
D E F  
G H I

**Part 1: Save the connection.**

- Two connect 2 Nodes, create a new connection, and assign an ID to it.
- The easiest ID would be the position of the Node itself.
- Every Node is connected to itself, so initial ID = position.
- When two Nodes (A and B) get connected, the second Node (B) and its connections switch to be in A's connection.

Notice connectTwoNodes is O(N)? That's O(N^2) for N calls.

**Part 2: Are they connected?**

- If the connection ID of the two Nodes is the same, they're connected.

It's O(1).

## Solution 2

The O(N^2) time complexity exists because B has more than half the Nodes in its connections, and A has the remaining.  
Always moving the smaller network into larger can reduce the movement operation to O(N/2) in the worst case 
(an equal-sized networks, nearly half nodes on both the networks).  
While this helps practically, it's still O(N^2) for N operations.  

What if it's done lazily?  
Don't do it right away, instead, point the root of the smaller network to the root of the larger.  
But then the areTwoNodesConnected operation will become O(N).  

A root means a Node that has the same connectionID as its position since position is the connectionID.

Well, first, the implementation:
- connectTwoNodes now only changes the connection ID of the root the smaller network to match the larger one's root.
- areTwoNodesConnected will now traverse through the connection ID of the two Nodes passed as arguments till root.
- The two Nodes are connected if their root matches. This is O(N) or O(N^2) for N operations.

Notice how the O(N^2) shifted from connectTwoNodes to areTwoNodesConnected because of laziness?  
But this doesn't change anything in the grand scheme, one of the two operations is still O(N^2) for N operations.

This can be amortized O(1) by updating connection IDs of the Nodes while traversing up to find the root.  
How?  

(Node in argument) A -> B -> C -> D (Root)

- Started at A, its connection ID is the B's position, and B's not a root (its connection ID != its position).
- So, change A's connection ID to B's connection ID, which is C's position.
- Similarly, change B's connection ID to D's position (C's connection ID).

This is amortized O(1) because in the end, every Node will point to a Root directly.  
That's O(1) to find roots of the two Nodes in arguments and thus O(1) areTwoNodesConnected.  
But it will take some O(N)s to do it.

What's the benefit of not updating the connection IDs in every connectTwoNodes call?  
Well, why update some Nodes' connection IDs to B when in the end, they have to become As.  
Get it? It saves intermediary updates (don't C → B because at the end of N operations, C → A).  

Implementation of areTwoNodesConnected:
- Find the root of both Nodes and do path compression while traversing.
- Are they equal?
