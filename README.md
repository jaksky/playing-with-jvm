# Playing-with-jvm
Repository where I experiment with JVM internal such as JIT and various performance optimizations techniques.

## How to run
To run a particular benchmark:
```sbtshell
jmh:run  .*IncWhile.*
```
or you can run all benchmarks at once
```sbtshell
jmh:run
```
You can also overload benchmark settings with provided parameters to command line
```sbtshell
jmh:run -i 3 -wi 3 -f1 -t1 .*IncWhile.*
```
### JVM options worth checking before starting experiments
Following list I found useful during experiments with JVM. Details can be found in [Java SE Tools Reference](https://docs.oracle.com/javase/9/tools/java.htm#JSWOR624)
- -XX:+PrintCompilation - Prints a message when method is compiled 
- -XX:+UnlockDiagnosticVMOptions - option that unlocks diagnostic JVM options which are not collected during runtime otherwise
- -XX:+PrintAssembly - prints assembly code for bytecode and native methods 
- -XX:+LogCompilation - logs compilation activity to a file
- -XX:+TraceClassLoading - trace a class as they are loaded 
- -verbose:gc - displays information about each GC event 
- -verbose:class - displays information about each class loaded
- -XX:+PrintInlining - prints inlining decesions 
- -XX:-Inline - disables method inlining 
- -XX:CompileCommand - specifies a command to perform on a method, e.g.
```
-XX:CompileCommand=dontinline, com/jaksky/jvm/tests/jit/IncFor.inc
``` 
prevents inlining of com.jaksky.jvm.tests.jit.IncFor.inc method

