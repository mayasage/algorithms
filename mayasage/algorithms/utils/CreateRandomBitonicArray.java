package mayasage.algorithms.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class CreateRandomBitonicArray {
  private final int len;
  private final int peakVal;

  CreateRandomBitonicArray(int len, int peakVal) {
    if (len < 3) {
      throw new RuntimeException("Len cannot be less than 3");
    }
    if (len > 1_00_000) {
      throw new RuntimeException("Len cannot be more than 1_00_000");
    }
    if (peakVal < len) {
      throw new RuntimeException("peakVal cannot be less than len");
    }
    this.len = len;
    this.peakVal = peakVal;
  }

  public int[] get() {
    // Init
    int len = this.len;
    int[] arr = new int[len];
    int peakVal = this.peakVal;
    int peakIndx = ThreadLocalRandom.current().nextInt(1, len - 1);
    arr[peakIndx] = peakVal;
    Set<Integer> seen = new HashSet<>();

    // Fill [0, peakIndx - 1]
    int slots = peakIndx;
    int range = peakVal / slots;
    for (int slot = 0; slot < slots; slot += 1) {
      int s = slot * range;
      int e = s + range;
      if (slot == slots - 1 || e > peakVal) {
        e = peakVal;
      }
      int r = ThreadLocalRandom.current().nextInt(s, e);
      seen.add(r);
      arr[slot] = r;
    }

    // Fill [peakIndx + 1, len - 1]
    slots = len - peakIndx - 1;
    range = peakVal / slots;
    int lastUsed = -1;
    for (int i = len - 1; i > peakIndx; i -= 1) {
      // Init
      int slot = len - i - 1;
      int s = slot * range;
      if (s < lastUsed) {
        s = lastUsed;
      }
      int e = s + range;
      if (i == peakIndx + 1 || e > peakVal) {
        e = peakVal;
      }

      // Rand
      Set<Integer> localSeen = new HashSet<>();
      int count = -1;
      int r = -1;
      do {
        if (!localSeen.contains(r)) {
          localSeen.add(r);
          count += 1;
          if (count == range) { // exhausted range
            s += range;
            e = s + range;
            if (s == slots - 1 || e > peakVal) {
              e = peakVal;
            }
            count = 0;
            localSeen = new HashSet<>();
          }
        }
        r = ThreadLocalRandom.current().nextInt(s, e);
      } while (seen.contains(r));
      seen.add(r);
      lastUsed = s;
      arr[i] = r;
    }

    return arr;
  }
}
