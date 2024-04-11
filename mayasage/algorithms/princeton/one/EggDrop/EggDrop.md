# Question 3: Egg drop.

Suppose that you have an n-story building (with floors 1 through n) and plenty
of eggs. An egg breaks if it is dropped from floor T or higher and does not
break otherwise. Your goal is to devise a strategy to determine the value of
T given the following limitations on the number of eggs and tosses:

|   Eggs    |     Tosses     |  FileNames   |
|:---------:|:--------------:|:------------:|
|     1     |      <= T      |  EggDropOne  |
| ~ 1 lg(n) |   ~ 1 lg(n)    |  EggDropTwo  |
|  ~ lg(t)  |   ~ 2 lg(t)    | EggDropThree |
|     2     |  ~ 2 sqrt(n)   | EggDropFour  |
|     2     | <= c * sqrt(t) | EggDropFive  |

## Solution

Understand that our aim is to simulate and estimate time taken by our algorithm.
So, we'll provide both N & T, and see how long the algorithm takes.
Check EggDrop class (abstract) for Function Signature.
