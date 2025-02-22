package mayasage.algorithms.princeton.one.queue;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
        public static void main(String[] args) {
                int k = Integer.parseInt(args[0]);
                RandomizedQueue<String> rQueue = new RandomizedQueue<>();
                while (!StdIn.isEmpty()) {
                        String s = StdIn.readString();
                        rQueue.enqueue(s);
                }
                for (int i = 0; i < k; i++) {
                        String s = rQueue.dequeue();
                        StdOut.println(s);
                }
        }
}
