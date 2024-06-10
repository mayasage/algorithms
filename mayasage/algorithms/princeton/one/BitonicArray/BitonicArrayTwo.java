package mayasage.algorithms.princeton.one.BitonicArray;

public class BitonicArrayTwo {
  private final int t;
  private final int[] a;
  private final int n;

  BitonicArrayTwo(int t, int[] a) {
    this.t = t;
    this.a = a;
    this.n = a.length;
  }

  int find() {
    return r(0, a.length - 1);
  }

  private int r(int s, int e) {
    if (s > e) return -1;
    if (s == e) return a[s] == t ? s : -1;
    int m = (s + e) / 2;
    if (a[m] == t) return m;
    if (m > 0 && a[m - 1] < a[m] && a[m] < t) return r(m + 1, e);
    if (m < n - 1 && a[m + 1] < a[m] && a[m] < t) return r(s, m - 1);
    int l = r(0, m - 1);
    if (l > -1) return l;
    return r(m + 1, e);
  }
}
