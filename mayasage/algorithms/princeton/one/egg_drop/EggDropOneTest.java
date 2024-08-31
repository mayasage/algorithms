package mayasage.algorithms.princeton.one.egg_drop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EggDropOneTest {
  void edgeCases(EggDrop eggDrop) {
    assertEquals(-1, eggDrop.simulate(0, 0));
    assertEquals(-1, eggDrop.simulate(0, 1));
    assertEquals(-1, eggDrop.simulate(1, 0));
    assertEquals(-1, eggDrop.simulate(1, 2));

    assertEquals(1, eggDrop.simulate(1, 1));

    assertEquals(1, eggDrop.simulate(1, 1));
    assertEquals(2, eggDrop.simulate(2, 2));

    assertEquals(1, eggDrop.simulate(3, 1));
    assertEquals(2, eggDrop.simulate(3, 2));
    assertEquals(3, eggDrop.simulate(3, 3));
  }

  void performance(EggDrop eggDrop) {
    assertEquals(
      900_000_000,
      eggDrop.simulate(1_000_000_000, 900_000_000)
    );
  }

  @Test
  void simulate() {
    EggDrop eggDrop = new EggDropOne();

    edgeCases(eggDrop);
    performance(eggDrop);
  }
}