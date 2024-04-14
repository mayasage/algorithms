package mayasage.algorithms.princeton.one.EggDrop;

abstract class EggDrop {
  /**
   * Use this function to check if the Egg broke.
   * @return True if egg broke, false otherwise.
   */
  boolean throwEgg(int currentFloor, int firstBreakFloor) {
    return currentFloor >= firstBreakFloor;
  }

  /**
   * @return Number of egg tosses.
   */
  abstract int simulate(int numFloors, int firstBreakFloor);
}
