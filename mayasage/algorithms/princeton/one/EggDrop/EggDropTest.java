package mayasage.algorithms.princeton.one.EggDrop;

abstract class EggDropTest {
  void runNSimulations(EggDrop eggDrop, int simulationCount, int n,
                               int t) {
    for (int i = 0; i < simulationCount; i += 1) {
      eggDrop.simulate(n, t);
    }
  }
}
