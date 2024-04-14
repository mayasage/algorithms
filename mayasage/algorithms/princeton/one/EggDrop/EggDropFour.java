/*
 * 2 eggs, ~ 2 sqrt(n) tosses
 * The sqrt(n) time complexity is a hint. We're going to do something with Sqrt.
 * Also, note that we ONLY have 2 eggs. An egg is lost when it breaks.
 * Since we have 2 eggs only, binary search is impossible.
 *
 * Algorithm.
 *
 * First of all, note that we only have 2 chances to break the egg.
 * If we had only 1 chance, linear search would have been the only option.
 *
 * But why does linear search work?
 * Linear search actually divides the N into x equal parts of size 1.
 * You can imagine this as a huge array created with N arrays of size 1.
 * 1 2 3 4 5
 * This array of size 5, is divided into 5 arrays of size 1.
 * Or, the number 5 is divided into 5 1s.
 *
 * We had 1 egg, we went from left to right, where it broke, it was our answer.
 *
 * But when we have 2 eggs, we can use the 1st egg to reduce the array.
 * Instead of searching from 1 to N, we can divide the array into some parts,
 * then throw egg at the beginning of those parts.
 * When the first egg breaks, we'll know that from this part onwards, the
 * eggs will definitely break.
 * But also, that the egg didn't break in the previous part.
 * By doing this, we reduce the number of floors we'll have to linearly search.
 *
 * The question is, how we should divide the number such that we have to do
 * the least possible searching.
 * The answer is to divide it in the most equal manner.
 * And to divide a number in the most equal manner, you take its square root.
 *
 * sqrt(N) will divide the number into x equal parts of x equal sizes.
 *
 * We'll search for the first floor where the egg breaks from 1 -> N, by
 * incrementing with sqrtN.
 * Time Complexity = ~sqrt(n)
 * This breaks our first egg.
 *
 * We also find the container above which the egg breaks, and the previous
 * container where the egg didn't break (current - sqrt(n)).
 *
 * We use the next and final egg to linearly search from previous to current
 * container.
 * Time Complexity = ~sqrt(n)
 * Why?
 * x equal parts of x equal sizes... remember?
 * It's like saying 2x - x = x.
 *
 * Our 2nd Egg breaks, and we have the answer.
 *
 * Total Time Complexity = ~sqrt(n) for first floor + ~sqrt(n) for least floor
 *                       = ~2sqrt(n)
 */

package mayasage.algorithms.princeton.one.EggDrop;

public class EggDropFour extends EggDrop {
  @Override
  int simulate(int numFloors, int firstBreakFloor) {
    if (numFloors < 1) return -1;
    if (firstBreakFloor < 1) return -1;

    /*
     * This also ensures that firstBreakFloor is DEFINITELY present.
     */
    if (firstBreakFloor > numFloors) return -1;

    int tosses = 0;

    int sqRootN = (int) Math.sqrt(numFloors);

    /*
     * Find a floor where Egg breaks.
     */

    int i = 1;

    while (i <= numFloors) {
      tosses += 1;

      if (throwEgg(i, firstBreakFloor)) {
        break;
      }

      i += sqRootN;
    }

    /*
     * The egg at least broke at numFloors.
     */
    int lastBrokenAt = Math.min(i, numFloors);
    int lastSurvivedAt = i - sqRootN;

    /*
     * Find the least floor.
     */

    for (i = lastSurvivedAt + 1; i < lastBrokenAt; i += 1) {
      tosses += 1;

      if (throwEgg(i, firstBreakFloor)) {
        break;
      }
    }

    return tosses;
  }
}
