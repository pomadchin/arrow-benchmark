/*
 * Copyright 2019 Azavea
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.azavea.benchmark.arrow

import org.apache.arrow.memory.RootAllocator
import org.apache.arrow.vector.Float8Vector
import org.openjdk.jmh.annotations._
import org.openjdk.jmh.infra.Blackhole
import spire.syntax.cfor._

import java.nio.{ByteBuffer, DoubleBuffer}
import java.util.Random
import java.util.concurrent.TimeUnit

@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 2, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@BenchmarkMode(Array(Mode.Throughput))
@Measurement(iterations = 5, time = 5, timeUnit = TimeUnit.SECONDS)
@Threads(1)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
class ArrowVectorDoubleBenchmark {
  /**
    * The size of the vector to test.
    *
    * To make it more readable, the parameter is, in fact, the base 2 log of
    * the final value.
    */
  @Param(Array("10", "20", "26"))
  var size: Int = 0
  /**
    * How many ints will be read on sum and sequential tests.
    */
  final val toRead = 32

  /**
    * A fixed random value to make the test repeatable.
    */
  final val r = new Random(57182931)
  final val alloc = new RootAllocator(1L << 30)
  private var arrowVector: Float8Vector = _
  private var vector: Vector[Double] = _
  private var array: Array[Double] = _
  private var buffer: DoubleBuffer = _

  @Setup(Level.Trial)
  def setUp(): Unit = {
    val bytesSize = Math.min(1 << 22, 1l << size).toInt
    val bytes = new Array[Byte](bytesSize)
    var filled = 0
    val dataSize = 8 << size
    val buf = ByteBuffer.allocateDirect(dataSize)
    while (filled < dataSize) {
      r.nextBytes(bytes)
      val toWrite = Math.min(bytes.length, dataSize - filled)
      buf.put(bytes, 0, toWrite)
      filled += toWrite
    }
    buf.clear
    createArray(buf)
    createVector(buf)
    createArrow(buf)
    createBuffer(buf)
  }

  @TearDown
  def tearDown(): Unit = {
    if (arrowVector != null) arrowVector.close()
    alloc.close()
  }

  private def createArray(buf: ByteBuffer): Unit =
    array = new Array[Double](buf.asDoubleBuffer.capacity)

  private def createVector(buf: ByteBuffer): Unit =
    vector = new Array[Double](buf.asDoubleBuffer.capacity).toVector

  private def createArrow(buf: ByteBuffer): Unit = {
    arrowVector = new Float8Vector("arrowVector", alloc)
    val bufDouble = buf.asDoubleBuffer
    arrowVector.allocateNew(bufDouble.capacity)
    while (bufDouble.hasRemaining) arrowVector.set(bufDouble.position, bufDouble.get)
    arrowVector.setValueCount(bufDouble.capacity)
  }

  private def createBuffer(buf: ByteBuffer): Unit = buffer = buf.asDoubleBuffer

  @Benchmark
  def sumArray: Double = {
    val pos = r.nextInt((1 << size) - toRead)
    val max = pos + toRead
    var sum = 0d
    cfor(pos)(_ < max, _ + 1) { i => sum += array(i) }
    sum
  }

  @Benchmark
  def sumVector: Double = {
    val pos = r.nextInt((1 << size) - toRead)
    val max = pos + toRead
    var sum = 0d
    cfor(pos)(_ < max, _ + 1) { i => sum += vector(i) }
    sum
  }

  @Benchmark
  def sumArrow: Double = {
    val pos = r.nextInt((1 << size) - toRead)
    val max = pos + toRead
    var sum = 0d

    cfor(pos)(_ < max, _ + 1) { i => sum += arrowVector.get(i) }

    sum
  }

  @Benchmark
  def sumBuf: Double = {
    val pos = r.nextInt((1 << size) - toRead)
    val max = pos + toRead
    var sum = 0d
    cfor(pos)(_ < max, _ + 1) { i => sum += buffer.get(i) }
    sum
  }

  @Benchmark
  def sequentialArray(bh: Blackhole): Unit = {
    val pos = r.nextInt((1 << size) - toRead)
    val max = pos + toRead
    cfor(pos)(_ < max, _ + 1) { i => bh.consume(array(i)) }
  }

  @Benchmark
  def sequentialVector(bh: Blackhole): Unit = {
    val pos = r.nextInt((1 << size) - toRead)
    val max = pos + toRead
    cfor(pos)(_ < max, _ + 1) { i => bh.consume(vector(i)) }
  }

  @Benchmark
  def sequentialArrow(bh: Blackhole): Unit = {
    val pos = r.nextInt((1 << size) - toRead)
    val max = pos + toRead
    cfor(pos)(_ < max, _ + 1) { i => bh.consume(arrowVector.get(i)) }
  }

  @Benchmark
  def sequentialBuf(bh: Blackhole): Unit = {
    val pos = r.nextInt((1 << size) - toRead)
    val max = pos + toRead
    cfor(pos)(_ < max, _ + 1) { i => bh.consume(buffer.get(i)) }
  }

  @Benchmark
  def randomArray: Double = {
    val pos = r.nextInt(1 << size)
    array(pos)
  }

  @Benchmark
  def randomVector: Double = {
    val pos = r.nextInt(1 << size)
    vector(pos)
  }

  @Benchmark
  def randomArrow: Double = {
    val pos = r.nextInt(1 << size)
    arrowVector.get(pos)
  }

  @Benchmark
  def randomBuf: Double = {
    val pos = r.nextInt(1 << size)
    buffer.get(pos)
  }
}
