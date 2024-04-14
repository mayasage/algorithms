package mayasage.algorithms.princeton.one.EggDrop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EggDropFourTest {
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
    assertEquals(12, eggDrop.simulate(100, 56));
    assertEquals(13, eggDrop.simulate(100, 57));
    assertEquals(14, eggDrop.simulate(100, 58));
    assertEquals(15, eggDrop.simulate(100, 59));
    assertEquals(16, eggDrop.simulate(100, 60));
  }

  void performance(EggDrop eggDrop) {
    assertEquals(
      31622,
      eggDrop.simulate(1_000_000_000, 1)
    );

    assertEquals(
      18380,
      eggDrop.simulate(1_000_000_000, 50_000)
    );

    assertEquals(
      34720,
      eggDrop.simulate(1_000_000_000, 900_000_000)
    );
  }

  @Test
  void simulate() {
    EggDrop eggDrop = new EggDropFour();

    edgeCases(eggDrop);
    performance(eggDrop);
  }
}