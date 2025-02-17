# algorithms

Algorithms by Sedgewick.

Requires [algs4.jar](https://algs4.cs.princeton.edu/code/algs4.jar) in your classpath.  
In IntelliJ, File -> Project Structure -> Modules -> Dependencies -> Add algs4.jar

Also requires "org.junit.jupiter:junit-jupiter:5.8.1."  
The easiest way is to open any test file, hover over any import with "jupiter" written on it,
and let intellij handle the rest.

## A Note on Time Complexity

Why is O(N^2) such a bad time complexity?  
Suppose my input is one billion, and it takes 10 nanoseconds per input.

The Total time taken  
= 1 billion ^ 2 * 10 nanoseconds  
= 1 billion ^ 2 * 10 ^ -8 seconds  
= 10 billion / (60 * 60 * 24 * 365) years  
= 317 years
