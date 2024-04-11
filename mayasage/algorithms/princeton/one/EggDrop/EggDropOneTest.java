package mayasage.algorithms.princeton.one.EggDrop;

import edu.princeton.cs.algs4.Stopwatch;
import org.junit.jupiter.api.Test;

class EggDropOneTest extends EggDropTest {
  @Test
  void run() {
    EggDropOne eggDrop = new EggDropOne();

    Stopwatch watch = new Stopwatch();

    runNSimulations(
      eggDrop,
      1_000_000_000,
      1_000_000_000,
      1_000_000_000
    );

    runNSimulations(
      eggDrop,
      2_000_000_000,
      2_000_000_000,
      2_000_000_000
    );

    System.out.println(watch.elapsedTime());
  }
}