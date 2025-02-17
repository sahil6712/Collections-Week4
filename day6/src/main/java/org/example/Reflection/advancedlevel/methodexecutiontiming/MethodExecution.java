package org.example.Reflection.advancedlevel.methodexecutiontiming;


public class MethodExecution {
    public static void main(String[] args) {
        MathOp mathOps = new MathOp();

        // Measure execution time for different methods
        MethodTimer.measureExecutionTime(mathOps, "add", 10, 20);
        MethodTimer.measureExecutionTime(mathOps, "slowMethod");
    }
}