# Apache Arrow Vector benchmark project

To run benchmarks use the following command:

```bash
./sbt jmh:run
```

More documentation about launch parameters can be found in the [sbt-jmh](https://github.com/ktoso/sbt-jmh) repository.

## Results

### ArrowVectorByteBenchmark

```
[info] Benchmark                                  (size)   Mode  Cnt   Score    Error   Units
[info] ArrowVectorByteBenchmark.randomArray           10  thrpt    5  97.747 ± 28.085  ops/us
[info] ArrowVectorByteBenchmark.randomArray           20  thrpt    5  72.742 ±  7.286  ops/us
[info] ArrowVectorByteBenchmark.randomArray           26  thrpt    5  13.671 ±  1.024  ops/us
[info] ArrowVectorByteBenchmark.randomArrow           10  thrpt    5  77.541 ± 15.839  ops/us
[info] ArrowVectorByteBenchmark.randomArrow           20  thrpt    5  66.406 ±  5.404  ops/us
[info] ArrowVectorByteBenchmark.randomArrow           26  thrpt    5  12.275 ±  3.058  ops/us
[info] ArrowVectorByteBenchmark.randomBuf             10  thrpt    5  96.295 ± 21.734  ops/us
[info] ArrowVectorByteBenchmark.randomBuf             20  thrpt    5  67.975 ± 12.731  ops/us
[info] ArrowVectorByteBenchmark.randomBuf             26  thrpt    5  13.505 ±  3.231  ops/us
[info] ArrowVectorByteBenchmark.randomVector          10  thrpt    5  89.141 ±  2.448  ops/us
[info] ArrowVectorByteBenchmark.randomVector          20  thrpt    5  22.899 ±  2.377  ops/us
[info] ArrowVectorByteBenchmark.randomVector          26  thrpt    5   5.164 ±  0.633  ops/us
[info] ArrowVectorByteBenchmark.sequentialArray       10  thrpt    5   9.102 ±  0.522  ops/us
[info] ArrowVectorByteBenchmark.sequentialArray       20  thrpt    5   6.622 ±  3.092  ops/us
[info] ArrowVectorByteBenchmark.sequentialArray       26  thrpt    5   4.243 ±  0.434  ops/us
[info] ArrowVectorByteBenchmark.sequentialArrow       10  thrpt    5   5.115 ±  0.691  ops/us
[info] ArrowVectorByteBenchmark.sequentialArrow       20  thrpt    5   4.564 ±  1.274  ops/us
[info] ArrowVectorByteBenchmark.sequentialArrow       26  thrpt    5   3.105 ±  0.472  ops/us
[info] ArrowVectorByteBenchmark.sequentialBuf         10  thrpt    5   8.238 ±  1.233  ops/us
[info] ArrowVectorByteBenchmark.sequentialBuf         20  thrpt    5   7.629 ±  0.748  ops/us
[info] ArrowVectorByteBenchmark.sequentialBuf         26  thrpt    5   4.027 ±  0.642  ops/us
[info] ArrowVectorByteBenchmark.sequentialVector      10  thrpt    5   5.212 ±  0.906  ops/us
[info] ArrowVectorByteBenchmark.sequentialVector      20  thrpt    5   2.828 ±  0.479  ops/us
[info] ArrowVectorByteBenchmark.sequentialVector      26  thrpt    5   1.156 ±  0.328  ops/us
[info] ArrowVectorByteBenchmark.sumArray              10  thrpt    5  39.756 ±  2.058  ops/us
[info] ArrowVectorByteBenchmark.sumArray              20  thrpt    5  27.699 ± 17.081  ops/us
[info] ArrowVectorByteBenchmark.sumArray              26  thrpt    5   6.854 ±  3.005  ops/us
[info] ArrowVectorByteBenchmark.sumArrow              10  thrpt    5   8.438 ±  1.260  ops/us
[info] ArrowVectorByteBenchmark.sumArrow              20  thrpt    5   7.634 ±  2.044  ops/us
[info] ArrowVectorByteBenchmark.sumArrow              26  thrpt    5   3.912 ±  0.598  ops/us
[info] ArrowVectorByteBenchmark.sumBuf                10  thrpt    5  31.624 ±  2.298  ops/us
[info] ArrowVectorByteBenchmark.sumBuf                20  thrpt    5  23.849 ±  6.587  ops/us
[info] ArrowVectorByteBenchmark.sumBuf                26  thrpt    5   5.903 ±  2.009  ops/us
[info] ArrowVectorByteBenchmark.sumVector             10  thrpt    5   7.909 ±  3.362  ops/us
[info] ArrowVectorByteBenchmark.sumVector             20  thrpt    5   3.394 ±  1.471  ops/us
[info] ArrowVectorByteBenchmark.sumVector             26  thrpt    5   1.445 ±  0.199  ops/us
```

### ArrowVectorIntBenchmark

```
[info] Benchmark                                 (size)   Mode  Cnt    Score    Error   Units
[info] ArrowVectorIntBenchmark.randomArray           10  thrpt    5  103.585 ±  1.684  ops/us
[info] ArrowVectorIntBenchmark.randomArray           20  thrpt    5   37.162 ± 10.403  ops/us
[info] ArrowVectorIntBenchmark.randomArray           26  thrpt    5   12.665 ±  0.594  ops/us
[info] ArrowVectorIntBenchmark.randomArrow           10  thrpt    5   85.354 ±  3.326  ops/us
[info] ArrowVectorIntBenchmark.randomArrow           20  thrpt    5   35.173 ±  1.273  ops/us
[info] ArrowVectorIntBenchmark.randomArrow           26  thrpt    5   10.872 ±  0.322  ops/us
[info] ArrowVectorIntBenchmark.randomBuf             10  thrpt    5  100.691 ±  8.857  ops/us
[info] ArrowVectorIntBenchmark.randomBuf             20  thrpt    5   29.148 ± 12.180  ops/us
[info] ArrowVectorIntBenchmark.randomBuf             26  thrpt    5   11.726 ±  0.707  ops/us
[info] ArrowVectorIntBenchmark.randomVector          10  thrpt    5   81.339 ± 15.306  ops/us
[info] ArrowVectorIntBenchmark.randomVector          20  thrpt    5   17.460 ±  7.742  ops/us
[info] ArrowVectorIntBenchmark.randomVector          26  thrpt    5    4.616 ±  2.973  ops/us
[info] ArrowVectorIntBenchmark.sequentialArray       10  thrpt    5    9.407 ±  1.740  ops/us
[info] ArrowVectorIntBenchmark.sequentialArray       20  thrpt    5    6.623 ±  2.180  ops/us
[info] ArrowVectorIntBenchmark.sequentialArray       26  thrpt    5    3.722 ±  0.793  ops/us
[info] ArrowVectorIntBenchmark.sequentialArrow       10  thrpt    5    4.390 ±  1.405  ops/us
[info] ArrowVectorIntBenchmark.sequentialArrow       20  thrpt    5    4.007 ±  0.546  ops/us
[info] ArrowVectorIntBenchmark.sequentialArrow       26  thrpt    5    1.973 ±  2.750  ops/us
[info] ArrowVectorIntBenchmark.sequentialBuf         10  thrpt    5    7.258 ±  3.709  ops/us
[info] ArrowVectorIntBenchmark.sequentialBuf         20  thrpt    5    6.118 ±  1.658  ops/us
[info] ArrowVectorIntBenchmark.sequentialBuf         26  thrpt    5    3.131 ±  1.976  ops/us
[info] ArrowVectorIntBenchmark.sequentialVector      10  thrpt    5    5.045 ±  1.526  ops/us
[info] ArrowVectorIntBenchmark.sequentialVector      20  thrpt    5    3.229 ±  1.197  ops/us
[info] ArrowVectorIntBenchmark.sequentialVector      26  thrpt    5    0.999 ±  0.664  ops/us
[info] ArrowVectorIntBenchmark.sumArray              10  thrpt    5   40.529 ±  4.049  ops/us
[info] ArrowVectorIntBenchmark.sumArray              20  thrpt    5   22.998 ±  7.076  ops/us
[info] ArrowVectorIntBenchmark.sumArray              26  thrpt    5    9.053 ±  0.836  ops/us
[info] ArrowVectorIntBenchmark.sumArrow              10  thrpt    5    7.696 ±  1.650  ops/us
[info] ArrowVectorIntBenchmark.sumArrow              20  thrpt    5    5.240 ±  3.249  ops/us
[info] ArrowVectorIntBenchmark.sumArrow              26  thrpt    5    2.829 ±  1.669  ops/us
[info] ArrowVectorIntBenchmark.sumBuf                10  thrpt    5   21.189 ±  6.446  ops/us
[info] ArrowVectorIntBenchmark.sumBuf                20  thrpt    5   10.959 ±  5.939  ops/us
[info] ArrowVectorIntBenchmark.sumBuf                26  thrpt    5    4.277 ±  1.889  ops/us
[info] ArrowVectorIntBenchmark.sumVector             10  thrpt    5   11.796 ±  1.050  ops/us
[info] ArrowVectorIntBenchmark.sumVector             20  thrpt    5    4.842 ±  0.985  ops/us
[info] ArrowVectorIntBenchmark.sumVector             26  thrpt    5    1.132 ±  0.480  ops/us
```

### ArrowVectorDoubleBenchmark

```
[info] Benchmark                                    (size)   Mode  Cnt   Score    Error   Units
[info] ArrowVectorDoubleBenchmark.randomArray           10  thrpt    5  87.974 ± 21.997  ops/us
[info] ArrowVectorDoubleBenchmark.randomArray           20  thrpt    5  18.976 ±  6.798  ops/us
[info] ArrowVectorDoubleBenchmark.randomArray           26  thrpt    5   9.421 ±  2.747  ops/us
[info] ArrowVectorDoubleBenchmark.randomArrow           10  thrpt    5  81.254 ±  6.311  ops/us
[info] ArrowVectorDoubleBenchmark.randomArrow           20  thrpt    5  23.465 ±  0.708  ops/us
[info] ArrowVectorDoubleBenchmark.randomArrow           26  thrpt    5   9.477 ±  0.693  ops/us
[info] ArrowVectorDoubleBenchmark.randomBuf             10  thrpt    5  92.982 ± 17.507  ops/us
[info] ArrowVectorDoubleBenchmark.randomBuf             20  thrpt    5  23.337 ±  2.287  ops/us
[info] ArrowVectorDoubleBenchmark.randomBuf             26  thrpt    5  10.755 ±  1.678  ops/us
[info] ArrowVectorDoubleBenchmark.randomVector          10  thrpt    5  81.858 ± 10.256  ops/us
[info] ArrowVectorDoubleBenchmark.randomVector          20  thrpt    5   7.893 ±  2.555  ops/us
[info] ArrowVectorDoubleBenchmark.randomVector          26  thrpt    5   3.026 ±  0.335  ops/us
[info] ArrowVectorDoubleBenchmark.sequentialArray       10  thrpt    5   9.884 ±  0.835  ops/us
[info] ArrowVectorDoubleBenchmark.sequentialArray       20  thrpt    5   5.887 ±  1.237  ops/us
[info] ArrowVectorDoubleBenchmark.sequentialArray       26  thrpt    5   3.297 ±  0.457  ops/us
[info] ArrowVectorDoubleBenchmark.sequentialArrow       10  thrpt    5   4.088 ±  2.403  ops/us
[info] ArrowVectorDoubleBenchmark.sequentialArrow       20  thrpt    5   3.746 ±  0.560  ops/us
[info] ArrowVectorDoubleBenchmark.sequentialArrow       26  thrpt    5   2.331 ±  0.316  ops/us
[info] ArrowVectorDoubleBenchmark.sequentialBuf         10  thrpt    5   8.314 ±  0.555  ops/us
[info] ArrowVectorDoubleBenchmark.sequentialBuf         20  thrpt    5   5.531 ±  0.671  ops/us
[info] ArrowVectorDoubleBenchmark.sequentialBuf         26  thrpt    5   3.229 ±  0.457  ops/us
[info] ArrowVectorDoubleBenchmark.sequentialVector      10  thrpt    5   4.221 ±  3.136  ops/us
[info] ArrowVectorDoubleBenchmark.sequentialVector      20  thrpt    5   1.861 ±  0.082  ops/us
[info] ArrowVectorDoubleBenchmark.sequentialVector      26  thrpt    5   0.895 ±  0.105  ops/us
[info] ArrowVectorDoubleBenchmark.sumArray              10  thrpt    5  30.800 ±  3.233  ops/us
[info] ArrowVectorDoubleBenchmark.sumArray              20  thrpt    5  12.779 ±  5.074  ops/us
[info] ArrowVectorDoubleBenchmark.sumArray              26  thrpt    5   6.502 ±  2.580  ops/us
[info] ArrowVectorDoubleBenchmark.sumArrow              10  thrpt    5   8.341 ±  0.524  ops/us
[info] ArrowVectorDoubleBenchmark.sumArrow              20  thrpt    5   5.389 ±  0.704  ops/us
[info] ArrowVectorDoubleBenchmark.sumArrow              26  thrpt    5   2.623 ±  0.395  ops/us
[info] ArrowVectorDoubleBenchmark.sumBuf                10  thrpt    5  19.343 ±  3.355  ops/us
[info] ArrowVectorDoubleBenchmark.sumBuf                20  thrpt    5   8.778 ±  0.798  ops/us
[info] ArrowVectorDoubleBenchmark.sumBuf                26  thrpt    5   4.216 ±  0.357  ops/us
[info] ArrowVectorDoubleBenchmark.sumVector             10  thrpt    5  12.224 ±  0.102  ops/us
[info] ArrowVectorDoubleBenchmark.sumVector             20  thrpt    5   2.292 ±  0.115  ops/us
[info] ArrowVectorDoubleBenchmark.sumVector             26  thrpt    5   0.933 ±  0.121  ops/us
```

### SCodecByteBenchmark

```
[info] Benchmark                             (size)   Mode  Cnt    Score    Error   Units
[info] SCodecByteBenchmark.randomArray           10  thrpt    5   97.892 ± 46.875  ops/us
[info] SCodecByteBenchmark.randomArray           20  thrpt    5   71.209 ± 39.339  ops/us
[info] SCodecByteBenchmark.randomArray           26  thrpt    5   14.608 ±  0.184  ops/us
[info] SCodecByteBenchmark.randomBuf             10  thrpt    5  104.223 ±  9.726  ops/us
[info] SCodecByteBenchmark.randomBuf             20  thrpt    5   75.598 ±  2.747  ops/us
[info] SCodecByteBenchmark.randomBuf             26  thrpt    5   14.202 ±  1.990  ops/us
[info] SCodecByteBenchmark.randomSCodec          10  thrpt    5  101.147 ±  1.517  ops/us
[info] SCodecByteBenchmark.randomSCodec          20  thrpt    5   76.181 ±  1.482  ops/us
[info] SCodecByteBenchmark.randomSCodec          26  thrpt    5   14.693 ±  0.986  ops/us
[info] SCodecByteBenchmark.randomVector          10  thrpt    5   91.929 ±  1.176  ops/us
[info] SCodecByteBenchmark.randomVector          20  thrpt    5   24.333 ±  0.888  ops/us
[info] SCodecByteBenchmark.randomVector          26  thrpt    5    5.788 ±  0.160  ops/us
[info] SCodecByteBenchmark.sequentialArray       10  thrpt    5    8.547 ±  1.032  ops/us
[info] SCodecByteBenchmark.sequentialArray       20  thrpt    5    7.128 ±  5.997  ops/us
[info] SCodecByteBenchmark.sequentialArray       26  thrpt    5    3.230 ±  0.881  ops/us
[info] SCodecByteBenchmark.sequentialBuf         10  thrpt    5    7.793 ±  4.170  ops/us
[info] SCodecByteBenchmark.sequentialBuf         20  thrpt    5    6.508 ±  1.677  ops/us
[info] SCodecByteBenchmark.sequentialBuf         26  thrpt    5    4.104 ±  0.774  ops/us
[info] SCodecByteBenchmark.sequentialSCodec      10  thrpt    5    5.812 ±  1.867  ops/us
[info] SCodecByteBenchmark.sequentialSCodec      20  thrpt    5    5.034 ±  1.434  ops/us
[info] SCodecByteBenchmark.sequentialSCodec      26  thrpt    5    2.905 ±  1.417  ops/us
[info] SCodecByteBenchmark.sequentialVector      10  thrpt    5    5.071 ±  0.541  ops/us
[info] SCodecByteBenchmark.sequentialVector      20  thrpt    5    3.032 ±  0.643  ops/us
[info] SCodecByteBenchmark.sequentialVector      26  thrpt    5    1.225 ±  0.442  ops/us
[info] SCodecByteBenchmark.sumArray              10  thrpt    5   41.187 ±  2.513  ops/us
[info] SCodecByteBenchmark.sumArray              20  thrpt    5   30.810 ±  5.627  ops/us
[info] SCodecByteBenchmark.sumArray              26  thrpt    5    7.691 ±  1.399  ops/us
[info] SCodecByteBenchmark.sumBuf                10  thrpt    5   33.670 ±  2.501  ops/us
[info] SCodecByteBenchmark.sumBuf                20  thrpt    5   26.375 ± 14.261  ops/us
[info] SCodecByteBenchmark.sumBuf                26  thrpt    5    6.822 ±  2.093  ops/us
[info] SCodecByteBenchmark.sumSCodec             10  thrpt    5   22.828 ±  2.170  ops/us
[info] SCodecByteBenchmark.sumSCodec             20  thrpt    5   18.091 ±  5.227  ops/us
[info] SCodecByteBenchmark.sumSCodec             26  thrpt    5    6.163 ±  0.883  ops/us
[info] SCodecByteBenchmark.sumVector             10  thrpt    5   10.021 ±  2.794  ops/us
[info] SCodecByteBenchmark.sumVector             20  thrpt    5    4.027 ±  1.078  ops/us
[info] SCodecByteBenchmark.sumVector             26  thrpt    5    1.472 ±  0.231  ops/us
```
