package com.dependability.webapp.bench;

import org.apache.commons.lang3.RandomStringUtils;
import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput) // cuántas cadenas/s
@OutputTimeUnit(TimeUnit.SECONDS)
@Warmup(iterations = 3, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1)
public class RandomStringBenchmark {

    @State(Scope.Thread)
    public static class Params {
        @Param({"8", "32", "128"})
        public int length;

        @Param({"true", "false"})
        public boolean letters;

        @Param({"true", "false"})
        public boolean numbers;
    }

    @Benchmark
    public String randomString(Params p) {
        return RandomStringUtils.random(p.length, p.letters, p.numbers);
    }
}
