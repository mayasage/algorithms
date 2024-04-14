/*
 * We have ~1lg(n) eggs. So, we can do a binary search.
 * With binary search we'll find the floor in ~1lg(n).
 */

package mayasage.algorithms.princeton.one.EggDrop;

public class EggDropTwo extends EggDrop {
  @Override
  int simulate(int numFloors, int firstBreakFloor) {
    if (numFloors < 1) return -1;
    if (firstBreakFloor < 1) return -1;
    if (firstBreakFloor > numFloors) return -1;

    int left = 1;
    int right = numFloors;
    int tosses = 0;

    while (left <= right) {
      int mid = (left + right) / 2;

      tosses += 1;

      /*
       * If Egg breaks, try to find a lower floor (go Left).
       * If it doesn't, try to find a higher floor where it breaks (go Right).
       */
      if (throwEgg(mid, firstBreakFloor)) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return tosses;
  }
}
