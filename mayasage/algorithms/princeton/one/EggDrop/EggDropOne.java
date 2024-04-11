/*
 * If I start from 1 to T (the break floor), the time complexity will be O(T).
 *
 * Basically, linear search... go to 1st floor throw the egg, go to 2nd floor
 * and throw the egg, and so on... until it breaks on a floor.
 * That floor is the answer.
 */

package mayasage.algorithms.princeton.one.EggDrop;

public class EggDropOne extends EggDrop {
  public void simulate(int numFloors, int firstBreakFloor) {
    if (numFloors < 1) return;
    if (firstBreakFloor < 1) return;

    for (int currentFloor = 1; currentFloor < numFloors; currentFloor += 1) {
      if (throwEgg(currentFloor, firstBreakFloor)) {
        return;
      }
    }
  }
}
