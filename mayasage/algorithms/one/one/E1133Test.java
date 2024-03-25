package mayasage.algorithms.one.one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class E1133Test {
  @Test
  public void testInputDot() {
    double[] x = new double[]{1, 2, 3};
    double[] y = new double[]{4, -5, 6};
    double output = 12;
    double res = E1133.dot(x, y);
    assertEquals(output, res);

    RuntimeException e = assertThrows(RuntimeException.class, () -> {
      double[] a = new double[]{1, 2, 3};
      double[] b = new double[]{2, 3};
      E1133.dot(a, b);
    });

    assertEquals("Vector length not equal.", e.getMessage());

    e = assertThrows(RuntimeException.class, () -> {
      double[] a = new double[]{1, 2};
      double[] b = new double[]{2, 3, 4};
      E1133.dot(a, b);
    });

    assertEquals("Vector length not equal.", e.getMessage());
  }

  @Test
  public void testMatrixMul() {
    // 1 x 1
    double[][] a = new double[][]{
      {3},
    };
    double[][] b = new double[][]{
      {4},
    };
    double[][] r = new double[][]{
      {12}
    };

    double[][] res = E1133.mult(a, b);
    assertArrayEquals(r, res);

    // 2 x 2
    a = new double[][]{
      {3, 7},
      {4, 9}
    };
    b = new double[][]{
      {6, 2},
      {5, 8}
    };
    r = new double[][]{
      {53, 62},
      {69, 80}
    };

    res = E1133.mult(a, b);
    assertArrayEquals(r, res);

    // 3 x 3
    a = new double[][]{
      {12, 8, 4},
      {3, 17, 14},
      {9, 8, 10}
    };
    b = new double[][]{
      {5, 19, 3},
      {6, 15, 9},
      {7, 8, 16}
    };
    r = new double[][]{
      {136, 380, 172},
      {215, 424, 386},
      {163, 371, 259}
    };

    res = E1133.mult(a, b);
    assertArrayEquals(r, res);

    // Variable dimensions

    // (2 x 3) (3 x 2)
    a = new double[][]{
      {1, 2, 3},
      {4, 5, 6},
    };
    b = new double[][]{
      {7, 8},
      {9, 10},
      {11, 12}
    };
    r = new double[][]{
      {58, 64},
      {139, 154}
    };

    res = E1133.mult(a, b);
    assertArrayEquals(r, res);

    // Invalid dimensions

    // (2 x 1) (2 x 2)
    RuntimeException e = assertThrows(RuntimeException.class, () -> {
      double[][] x = new double[][]{
        {1},
        {2},
      };
      double[][] y = new double[][]{
        {5, 6},
        {7, 8}
      };
      E1133.mult(x, y);
    });

    assertEquals("columns of matrix 'a' must be equal to rows " +
      "in matrix 'b'", e.getMessage());

    // (1 x 2) (1 x 2)
    e = assertThrows(RuntimeException.class, () -> {
      double[][] x = new double[][]{
        {1, 2},
      };
      double[][] y = new double[][]{
        {5, 6},
      };
      E1133.mult(x, y);
    });

    assertEquals("columns of matrix 'a' must be equal to rows " +
      "in matrix 'b'", e.getMessage());
  }

  @Test
  public void testTranspose() {
    assertArrayEquals(
      new double[][]{
        {1, 3},
        {2, 4},
        {6, 7}
      },
      E1133.transpose(
        new double[][]{
          {1, 2, 6},
          {3, 4, 7},
        }
      )
    );
  }

  @Test
  public void testMatrixVector() {
    RuntimeException e = assertThrows(RuntimeException.class, () -> {
      double[][] x = new double[][]{
        {1, 2},
        {3, 4}
      };
      double[] v = new double[]{6, 9, 9};
      E1133.mult(x, v);
    });

    assertEquals("Vector length must equal matrix column " +
      "length", e.getMessage());

    double[][] x = new double[][]{
      {1, 2},
      {3, 4}
    };
    double[] v = new double[]{6, 9};
    double[] r = new double[]{24, 54};
    assertArrayEquals(r, E1133.mult(x, v));

    x = new double[][]{
      {1, -1, 2},
      {0, -3, 1}
    };
    v = new double[]{2, 1, 0};
    r = new double[]{1, -3};
    assertArrayEquals(r, E1133.mult(x, v));
  }

  @Test
  public void testVectorMatrix() {
    RuntimeException e = assertThrows(RuntimeException.class, () -> {
      double[][] x = new double[][]{
        {1, 2},
        {3, 4}
      };
      double[] v = new double[]{6, 9, 9};
      E1133.mult(v, x);
    });

    assertEquals("Vector length must equal matrix column " +
      "length", e.getMessage());

    double[][] x = new double[][]{
      {1, 2},
      {3, 4}
    };
    double[] v = new double[]{6, 9};
    double[] r = new double[]{33, 48};
    assertArrayEquals(r, E1133.mult(v, x));
  }
}
