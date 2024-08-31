# Question 3: Egg drop.

Suppose that you have an n-story building (with floors 1 through n) and plenty
of eggs. An egg breaks if it is dropped from floor T or higher and does not
break otherwise. Your goal is to devise a strategy to determine the value of
T given the following limitations on the number of eggs and tosses:

|   Eggs    |     Tosses     |  FileNames   |
|:---------:|:--------------:|:------------:|
|     1     |      <= T      |  EggDropOne  |
| ~ 1 lg(n) |   ~ 1 lg(n)    |  EggDropTwo  |
| ~ 1 lg(t) |   ~ 2 lg(t)    | EggDropThree |
|     2     |  ~ 2 sqrt(n)   | EggDropFour  |
|     2     | <= c * sqrt(t) | EggDropFive  | 

## Solution

Understand that our aim is to simulate and estimate time taken by our algorithm.
So, we'll provide both N & T, and see how long the algorithm takes.
Check EggDrop class (abstract) for Function Signature.
I'm imagining building as an Array.

## Observations

### EggDropTwo Vs. EggDropThree

- EggDropThree takes almost double tosses in comparison to EggDropTwo when the
  firstBreakFloor is high. But, it takes ridiculously less time if
  firstBreakFloor is less.

    - Assume n = 1_000_000_000, then lg(n) ~=30.
    - If k = 200_000_000, then lg(k) ~= 28
    - Total TC of EggDropTwo = lg(n) ~= 30
    - Total TC of EggDropThree = 2lg(k) = 2 * 28 ~= 56
    - Below k = 50_000, the tosses will start becoming lesser than EggDropTwo.

- The benefit of EggDropThree over EggDropTwo would be that if the 
  firstBreakFloor is below a certain limit, we'll have less to way less 
  tosses (1 toss if firstBreakFloor = 1 like in linearSearch). But, the 
  price paid is having more than double the tosses if the firstBreakFloor is 
  above that limit. If you can afford ~lg(t) eggs, then this algorithm may 
  perform better, just because double comparisons aren't too many, but 
  ridiculously lower comparisons below a certain limit will make those 
  operations seem like O(1).

## Miscellaneous

### What is Square Root (sqrt)?

- sqrt divides a number into x equal parts of x equal sizes.
- sqrt(n) = (x parts) * (x size/parts)
- This is the most equal division possible for a number.
