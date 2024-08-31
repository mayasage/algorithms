/*
 * I have a social network with N members.
 *
 * I have a LogFile which stores which member connected with which member at
 * what time:
 * - Time
 * - Member A
 * - Member B
 *
 * I wanna know by what time they are all connected to each other.
 *
 * So, we use the good old WeightedUnionFind with Path Compression.
 *
 * There may be a slight problem here though.
 * We need to know when all of 'em folks are connected to each other.
 * I mean transitively... ?
 *
 * How do we know when all of 'em are connected ?
 * Well in our WeightedUnionFind algorithm, we know which node has what
 * number of children. So, I can just keep track of the largest node.
 * When the largest node (any node can be the largest node) becomes equal to
 * the size of the network, then it means all the nodes are connected to each
 * other.
 *
 * Remember that IF all the members connected with each other at some point
 * of time, then they must have built a really big tree.
 *
 * Thank you for listening kind reader, Maya out!
 *
 * Wait...
 *
 * Here is the time complexity:
 *
 * Iterating over LogFile is what ? O(M) ?
 * Then you run weighted union which was O(log*N) if you remember.
 * Overall it will be the same O(N + MLog*N), where M is the length of LogFile.
 */

package mayasage.algorithms.princeton.one.social_network_connectivity;

public class SocialNetwork {
  final private UnionFind uf;
  private final int nodeCount;

  SocialNetwork(int count) {
    uf = new UnionFind(count);
    nodeCount = count;
  }

  public int connect(LogFile logFile) {
    for (Log log : logFile) {
      int timestamp = log.timestamp();
      int memberOne = log.memberOne();
      int memberTwo = log.memberTwo();

      uf.union(memberOne, memberTwo);

      if (uf.getConnectedNodes() == nodeCount) {
        return timestamp;
      }
    }

    return -1;
  }
}
