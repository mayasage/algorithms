/*
 * 2 eggs, ~ c.sqrt(t) tosses, c should be 2sqrt(2)
 * Partial sum is what it is... this c.sqrt(t).
 * What it means is this:
 * 1 2 3 4 5 6 7 8 9 10
 * 1, (2,3), (4,5,6), (7,8,9,10)
 * Jump 1, Jump 2, Jump 3, Jump 4.
 *
 * Time Complexity will be calculated like this:
 * 1 + 2 + 3 + 4 ... + x = t, where t is the break floor
 * x/2(2a + (x-1)d) = t
 * 2x + x^2 - x = 2t
 * x^2 + x -2t = 0
 *
 * Then that (-b +- sqrt(b^2-4ac))/2a formula.
 * x^2 + x -2t = 0
 * compare ax^2 + bx + c = 0
 * => a = 1, b = 1, c = -2t
 * Substituting the values in that formula, we get
 * 2sqrt(2)sqrt(t).
 *
 * It takes this much to reach a floor where egg breaks.
 * Then you do linear search from the previous jump to here.
 * That's another sqrt(t).
 *
 * So overall its ~ c.sqrt(t).
 */

package mayasage.algorithms.princeton.one.egg_drop;

public class EggDropFive extends EggDrop {
  @Override
  int simulate(int numFloors, int firstBreakFloor) {
    if (numFloors < 1) return -1;
    if (firstBreakFloor < 1) return -1;

    /*
     * This also ensures that firstBreakFloor is DEFINITELY present.
     */
    if (firstBreakFloor > numFloors) return -1;

    int tosses = 0;

    int prev = 1;
    int i = 1;

    // Find a floor where egg breaks
    tosses += 1; // Increase tosses first, then throw
    while (!throwEgg(i, firstBreakFloor)) {
      // Jump incrementally.
      // 1 + 2 + 3 ...
      i += prev;
      prev += 1;
      tosses += 1; // Increment tosses before you throw
    }

    // Egg definitely breaks at "i"
    // And it didn't break on prev
    // So, go from (i - prev + 1) to (i - 1) to find the first floor
    // where it breaks.
    // (i - prev + 1) because Egg didn't break at (i - prev).
    int left = Math.min(i - prev + 1, 1);
    int right = Math.min(i - 1, 1);

    for (; left < right; left += 1) {
      tosses += 1; // increment tosses
      if (throwEgg(left, firstBreakFloor)) { // throw egg
        // egg broke
        // left is the first floor (t)
        break; // exit loop
      }
    }

    return tosses;
  }
}
