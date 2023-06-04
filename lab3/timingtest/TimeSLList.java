package timingtest;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.SymbolDigraph;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        int M = 100_00;
        for (int i = 1_000; i < 128_000; i *= 2) {
            Ns.addLast(i);
            SLList<Integer> test_list = new SLList<>();
            for (int j = 0; j < i ; j++) {
                test_list.addLast(j);
            }
            int opCount = 0;
            double start = System.currentTimeMillis();
            for (int k = 0; k < M; k++) {
                test_list.getLast();
                opCount += 1;
            }
            double end = System.currentTimeMillis();
            double time = (end - start) / 1000;
            opCounts.addLast(opCount);
            times.addLast(time);
        }
        printTimingTable(Ns, times, opCounts);
    }

}
