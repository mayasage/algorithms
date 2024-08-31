package mayasage.algorithms.princeton.one.social_network_connectivity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SocialNetworkTest {
  @Test
  public void test() {
    SocialNetwork network = new SocialNetwork(5);

    LogFile logFile = new LogFile();
    logFile.add(new Log(1, 1, 2));
    logFile.add(new Log(2, 3, 4));
    logFile.add(new Log(3, 5, 5));
    logFile.add(new Log(4, 2, 5));
    logFile.add(new Log(5, 1, 4));
    logFile.add(new Log(6, 3, 5));

    int res = network.connect(logFile);
    assertEquals(5, res);

    int n = 100_000_000;
    logFile = new LogFile();
    for (int i = 1; i <= n - 1; i += 1) {
      logFile.add(new Log(i, i, i + 1));
    }

    network = new SocialNetwork(n);
    res = network.connect(logFile);
    assertEquals(n - 1, res);
  }
}