package mayasage.algorithms.princeton.one.EggDrop;

abstract class EggDrop {
  /**
   * Use this function to check if the Egg broke.
   * @return True if egg broke, false otherwise.
   */
  boolean throwEgg(int currentFloor, int firstBreakFloor) {
    return currentFloor >= firstBreakFloor;
  }

  abstract void simulate(int numFloors, int firstBreakFloor);
}
