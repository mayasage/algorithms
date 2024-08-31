package mayasage.algorithms.princeton.one.social_network_connectivity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogFile implements Iterable<Log> {
  private final List<Log> logs = new ArrayList<>();

  public void add(int timestamp, int memberOne, int memberTwo) {
    logs.add(new Log(timestamp, memberOne, memberTwo));
  }

  public void add(Log log) {
    logs.add(log);
  }

  @Override
  public Iterator<Log> iterator() {
    return logs.iterator();
  }
}
