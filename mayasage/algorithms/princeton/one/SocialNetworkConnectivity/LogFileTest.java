package mayasage.algorithms.princeton.one.SocialNetworkConnectivity;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class LogFileTest {
  @Test
  public void test() {
    LogFile logFile = new LogFile();

    int count = 0;
    for (Log log : logFile) {
      count += 1;
    }
    assertEquals(count, 0);

    logFile.add(1, 2, 3);

    count = 0;
    for (Log log : logFile) {
      count += 1;

      assertEquals(1, log.timestamp());
      assertEquals(2, log.memberOne());
      assertEquals(3, log.memberTwo());
    }
    assertEquals(count, 1);

    logFile.add(new Log(4, 5, 6));

    count = 0;
    Iterator<Log> logFileItr = logFile.iterator();
    assertTrue(logFileItr.hasNext());
    Log log = logFileItr.next();
    assertEquals(1, log.timestamp());
    assertEquals(2, log.memberOne());
    assertEquals(3, log.memberTwo());
    count += 1;
    assertTrue(logFileItr.hasNext());
    log = logFileItr.next();
    assertEquals(4, log.timestamp());
    assertEquals(5, log.memberOne());
    assertEquals(6, log.memberTwo());
    count += 1;
    assertEquals(count, 2);
  }
}