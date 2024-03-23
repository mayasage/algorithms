/**
 * E1115:
 * Write a static method histogram() that takes an array a[] of int values and
 * an integer M as arguments and returns an array of length M whose ith entry is
 * the number of times the integer i appeared in the argument array. If the
 * values in a[] are all between 0 and M–1, the sum of the values in the
 * returned array should be equal to a.length.
 */

package mayasage.algorithms.one.one;

import java.util.HashMap;
import java.util.Map;

public class E1115 {
  private int[] histogram(int[] a, int m) {
    int[] res = new int[m];

    Map<Integer, Integer> map = new HashMap<>();
    for (int i : a) {
      int cur = map.getOrDefault(i, 0);
      map.put(i, cur + 1);
    }

    for (int i = 0; i < m; i += 1) {
      res[i] = map.getOrDefault(i, 0);
    }

    return res;
  }

  public static int[] run(int[] a, int m) {
    return new E1115().histogram(a, m);
  }
}
