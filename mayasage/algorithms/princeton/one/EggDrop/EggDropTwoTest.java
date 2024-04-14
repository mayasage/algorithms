package mayasage.algorithms.princeton.one.EggDrop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EggDropTwoTest {
  void edgeCases(EggDrop eggDrop) {
    assertEquals(-1, eggDrop.simulate(0, 0));
    assertEquals(-1, eggDrop.simulate(0, 1));
    assertEquals(-1, eggDrop.simulate(1, 0));
    assertEquals(-1, eggDrop.simulate(1, 2));

    assertEquals(1, eggDrop.simulate(1, 1));

    assertEquals(1, eggDrop.simulate(2, 1));
    assertEquals(2, eggDrop.simulate(2, 2));

    assertEquals(2, eggDrop.simulate(3, 1));
    assertEquals(2, eggDrop.simulate(3, 2));
    assertEquals(2, eggDrop.simulate(3, 3));
  }

  void performance(EggDrop eggDrop) {
    assertEquals(
      29,
      eggDrop.simulate(1_000_000_000, 1)
    );

    assertEquals(
      30,
      eggDrop.simulate(1_000_000_000, 50_000)
    );

    assertEquals(
      30,
      eggDrop.simulate(1_000_000_000, 900_000_000)
    );
  }

  @Test
  void simulate() {
    EggDrop eggDrop = new EggDropTwo();

    edgeCases(eggDrop);
    performance(eggDrop);
  }
}
