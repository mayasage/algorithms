/*
 * I have to do this in ~1lg(t) eggs & ~1lg(t) tosses.
 * To do this, I'll do the reverse of binary search.
 *
 * You see, binary search DIVIDES the array into half.
 * Q. What is the reverse of DIVIDE?
 * A. DOUBLE
 *
 * So, if I go from 1 to t floor, but instead of incrementing by 1, I double the
 * previous i, I'll have ~1lg(t).
 *
 * How ?
 * 1, 2, 4, 8, 16, ... <till I reach t>
 * => 2^0, 2^1, 2^2, ... 2^i, where 2^i >= t
 *
 * Here we're comparing at 2^0, 2^1, 2^2... we're NOT doing 2^0 + 2^1 + ...
 * comparisons.
 * This means we just need to find the NUMBER of elements in this series, and
 * NOT the SUM of this series.
 * Well, the total number of elements in this series is i.
 *
 * We know, 2^i >= t
 * => i >= 1lg(t)
 * Thus, we can find 2^i in ~1lg(t) time.
 *
 * Now, it is certainly a floor where the Egg breaks, but it probably is NOT
 * the least floor at which it happens.
 * Let's call this "lb".
 *
 * To find the least floor, we have to search for the lowest floor between
 * lb & (lb/2). (ls = lb/2) means the last floor where the Egg didn't broke.
 *
 * This can be a huge array.
 * Imagine 1...1_000_000_000 floors. At 500_000_000 (ls), the Egg didn't broke,
 * and so, the next i = 1_000_000_000 (lb). It broke at "i".
 * Now we have to perform linear search on (lb - ls).
 *
 * What we can instead do is binary search.
 * That will be ~1lg(t) time complexity again.
 *
 * Why ?
 * Let's assume ls = 1, and lb = 1_000_000_000.
 * Binary search on the above will be [1lg(lb-ls)] ~= 30.
 * This is like ~1lg(t).
 *
 * If I cut this down to the example we assumed.
 * ls = 500_000_000, lb = 1_000_000_000
 * Binary search on the above will be [1lg(lb-ls)] ~= 29.
 * This is like ~1lg(t)/2, which we can generalize down back to ~1lg(t).
 * 
 * Total Time Complexity
 * = lg(t) to find the first floor + lg(t) to find the least floor
 * = ~2lg(t)
 */

package mayasage.algorithms.princeton.one.egg_drop;

public class EggDropThree extends EggDrop {
  @Override
  int simulate(int numFloors, int firstBreakFloor) {
    if (numFloors < 1) return -1;
    if (firstBreakFloor < 1) return -1;
    if (firstBreakFloor > numFloors) return -1;
    int tosses = 0;

    int i = 1;

    /*
     * Try to find a floor where Egg breaks.
     */
    while(i <= numFloors) {
      tosses += 1;

      if (throwEgg(i, firstBreakFloor)) {
        break;
      }

      i *= 2;
    }

    int lastSurvivedAt = i / 2;

    /*
     * It is assumed that Egg definitely broke at the topFloor.
     */
    int lastBrokenAt = Math.min(i, numFloors);

    /*
     * Now try to find the least floor where the Egg broke using binary search.
     */
    int left = lastSurvivedAt + 1;
    int right = lastBrokenAt - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      tosses += 1;

      if (throwEgg(mid, firstBreakFloor)) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return tosses;
  }
}
