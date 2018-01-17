package com.jaksky.jvm.tests.jit

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._

@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 10)
@Measurement(iterations = 10)
class IncWhile {

  @Benchmark
  def testJit(): Int = {
    var i: Int = 0
    var limit = 0

    while (limit < 1000000000) {
      i = inc(i)
      limit = limit + 1
    }
    i
  }

  /**
    * This method is eligible for inlining, experiment with effects of not inlining the method.
    */
//  @CompilerControl(CompilerControl.Mode.DONT_INLINE)
  @CompilerControl(CompilerControl.Mode.INLINE)
  def inc(i: Int): Int = i + 1
}

object IncWhile {
  def main(args: Array[String]): Unit = {
    (new IncWhile).testJit()
  }
}
