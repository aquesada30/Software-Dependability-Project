package com.dependability.webapp.bench;

import org.apache.commons.lang3.StringUtils;
import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput) // ops/seg
@OutputTimeUnit(TimeUnit.SECONDS)
@Warmup(iterations = 3, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1)
public class ReverseBenchmark {

    @State(Scope.Thread)
    public static class InputState {
        @Param({"10", "100", "1000", "10000"})
        public int size;

        public String data;

        @Setup(Level.Trial)
        public void setup() {
            StringBuilder sb = new StringBuilder(size);
            for (int i = 0; i < size; i++) sb.append((char)('a' + (i % 26)));
            data = sb.toString();
        }
    }

    // Implementación manual simple
    private static String reverseManual(String s) {
        if (s == null) return null;
        char[] a = s.toCharArray();
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            char tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        return new String(a);
    }

    @Benchmark
    public String commons_reverse(InputState st) {
        return StringUtils.reverse(st.data);
    }

    @Benchmark
    public String manual_reverse(InputState st) {
        return reverseManual(st.data);
    }
}
