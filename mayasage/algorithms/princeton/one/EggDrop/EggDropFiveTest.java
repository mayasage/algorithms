package mayasage.algorithms.princeton.one.EggDrop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EggDropFiveTest {
  void edgeCases(EggDrop eggDrop) {
    assertEquals(-1, eggDrop.simulate(0, 0));
    assertEquals(-1, eggDrop.simulate(0, 1));
    assertEquals(-1, eggDrop.simulate(1, 0));
    assertEquals(-1, eggDrop.simulate(1, 2));

    assertEquals(1, eggDrop.simulate(1, 1));

    assertEquals(1, eggDrop.simulate(2, 1));
    assertEquals(2, eggDrop.simulate(2, 2));

    assertEquals(1, eggDrop.simulate(3, 1));
    assertEquals(2, eggDrop.simulate(3, 2));
    assertEquals(3, eggDrop.simulate(3, 3));

    assertEquals(11, eggDrop.simulate(100, 55));
    assertEquals(11, eggDrop.simulate(100, 56));
    assertEquals(12, eggDrop.simulate(100, 57));
    assertEquals(12, eggDrop.simulate(100, 58));
    assertEquals(12, eggDrop.simulate(100, 59));
    assertEquals(12, eggDrop.simulate(100, 60));
  }

  void performance(EggDrop eggDrop) {
    assertEquals(
      1,
      eggDrop.simulate(1_000_000_000, 1)
    );

    assertEquals(
      317,
      eggDrop.simulate(1_000_000_000, 50_000)
    );

    // Takes more tosses than ~ 2 sqrt(n) tosses
    assertEquals(
      42427,
      eggDrop.simulate(1_000_000_000, 900_000_000)
    );
  }

  @Test
  void simulate() {
    EggDrop eggDrop = new EggDropFive();

    edgeCases(eggDrop);
    performance(eggDrop);
  }
}