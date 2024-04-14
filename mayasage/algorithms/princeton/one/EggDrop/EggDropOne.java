/*
 * If I start from 1 to T (the break floor), the time complexity will be O(T).
 *
 * Basically, linear search... go to 1st floor throw the egg, go to 2nd floor
 * and throw the egg, and so on... until it breaks on a floor.
 * That floor is the answer.
 */

package mayasage.algorithms.princeton.one.EggDrop;

public class EggDropOne extends EggDrop {
  @Override
  public int simulate(int numFloors, int firstBreakFloor) {
    if (numFloors < 1) return -1;
    if (firstBreakFloor < 1) return -1;
    if (firstBreakFloor > numFloors) return -1;

    int tosses = 0;

    for (int currentFloor = 1; currentFloor <= numFloors; currentFloor += 1) {
      tosses += 1;
      if (throwEgg(currentFloor, firstBreakFloor)) {
        break;
      }
    }

    return tosses;
  }
}
