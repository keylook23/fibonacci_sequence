package com.zacharadamian.fibonaccisequence;
/**
 * Main class calculates a term of fibonacci sequence.
 * Accessing arguments through from console or GUI text field.
 * The result is printed in console or GUI interface.
 *
 * @version 1.0
 * @author Zachara Damian <zachara_damian@wp.pl>
 */
public class Main {
    /**
     * Main program method. Communicates with user and print results.
     * For proper use of command line functionality enter one argument:
     * (integer) draw chart for the specified term sequence.
     *
     * @param args
     */
    public static void main(String[] args) {
        Controller mainController = new Controller();
        mainController.startController(args);
    }
}
