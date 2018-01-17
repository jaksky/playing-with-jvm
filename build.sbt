name := "playing-with-jvm"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.12.4"

enablePlugins(JmhPlugin)

javaOptions in (run) ++= Seq(
//  "-XX:+PrintCompilation",
//  "-XX:+UnlockDiagnosticVMOptions",
//  "-XX:+PrintAssembly",
//  "-XX:+LogCompilation",
//  "-XX:+TraceClassLoading",
//  "-verbose:gc",
//  "-verbose:class",
//  "-XX:+PrintInlining",
//  "-XX:-Inline"
//  "-XX:CompileCommand=dontinline, com/jaksky/jvm/tests/jit/IncFor.inc"
  "-XX:LoopOptsCount=0"
)

mainClass in run := Some("com.jaksky.jvm.tests.jit.IncWhile")

fork in run := true