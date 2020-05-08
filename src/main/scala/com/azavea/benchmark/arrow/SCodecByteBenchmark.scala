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

import org.openjdk.jmh.annotations._
import org.openjdk.jmh.infra.Blackhole
import spire.syntax.cfor._
import scodec.bits._

import java.nio.ByteBuffer
import java.util.Random
import java.util.concurrent.TimeUnit

/**
  * jmh:run -i 10 -wi 5 -f1 -t1 .*SCodecByteBenchmark.*
  */
@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 2, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@BenchmarkMode(Array(Mode.Throughput))
@Measurement(iterations = 5, time = 5, timeUnit = TimeUnit.SECONDS)
@Threads(1)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
class SCodecByteBenchmark {
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
  private var vector: Vector[Byte] = _
  private var array: Array[Byte] = _
  private var buffer: ByteBuffer = _
  private var byteVector: ByteVector = _

  @Setup(Level.Trial)
  def setUp(): Unit = {
    val bytesSize = Math.min(1 << 22, 1l << size).toInt
    val bytes = new Array[Byte](bytesSize)
    var filled = 0
    val dataSize = 1 << size
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
    createBuffer(buf)
    createBitVector(buf)
  }

  private def createArray(buf: ByteBuffer): Unit =
    array = new Array[Byte](buf.capacity)

  private def createVector(buf: ByteBuffer): Unit =
    vector = new Array[Byte](buf.capacity).toVector

  private def createBuffer(buf: ByteBuffer): Unit =
    buffer = buf

  private def createBitVector(buf: ByteBuffer): Unit =
    byteVector = ByteVector(buf)

  @Benchmark
  def sumArray: Long = {
    val pos = r.nextInt((1 << size) - toRead)
    val max = pos + toRead
    var sum = 0l
    cfor(pos)(_ < max, _ + 1) { i => sum += array(i) }
    sum
  }

  @Benchmark
  def sumVector: Long = {
    val pos = r.nextInt((1 << size) - toRead)
    val max = pos + toRead
    var sum = 0l
    cfor(pos)(_ < max, _ + 1) { i => sum += vector(i) }
    sum
  }

  @Benchmark
  def sumSCodec: Long = {
    val pos = r.nextInt((1 << size) - toRead)
    val max = pos + toRead
    var sum = 0l

    cfor(pos)(_ < max, _ + 1) { i => sum += byteVector.get(i) }

    sum
  }

  @Benchmark
  def sumBuf: Long = {
    val pos = r.nextInt((1 << size) - toRead)
    val max = pos + toRead
    var sum = 0l
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
  def sequentialSCodec(bh: Blackhole): Unit = {
    val pos = r.nextInt((1 << size) - toRead)
    val max = pos + toRead
    cfor(pos)(_ < max, _ + 1) { i => bh.consume(byteVector.get(i)) }
  }

  @Benchmark
  def sequentialBuf(bh: Blackhole): Unit = {
    val pos = r.nextInt((1 << size) - toRead)
    val max = pos + toRead
    cfor(pos)(_ < max, _ + 1) { i => bh.consume(buffer.get(i)) }
  }

  @Benchmark
  def randomArray: Byte = {
    val pos = r.nextInt(1 << size)
    array(pos)
  }

  @Benchmark
  def randomVector: Byte = {
    val pos = r.nextInt(1 << size)
    vector(pos)
  }

  @Benchmark
  def randomSCodec: Byte = {
    val pos = r.nextInt(1 << size)
    byteVector.get(pos)
  }

  @Benchmark
  def randomBuf: Byte = {
    val pos = r.nextInt(1 << size)
    buffer.get(pos)
  }
}
