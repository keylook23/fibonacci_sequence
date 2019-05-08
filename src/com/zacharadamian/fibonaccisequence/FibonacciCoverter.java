package com.zacharadamian.fibonaccisequence;
/** FibonacciCoverter class
 * Is responsible for specified term sequence calculations.
 */
public class FibonacciCoverter {
    /**
     * Method calculateSequence
     * The sum of two previous terms is the next terms sequence
     * if first term = 1 and second term = 2.
     * @param {integer} i
     * @return {(number|Array)} termsSequence
     */
    public int[] calculateSequence(int i){
        int termsSequence[] = new int[i];
        termsSequence[0] = 1;
        termsSequence[1] = 2;
        for (int n = 2; n < termsSequence.length; n++){
            termsSequence[n] = termsSequence[n - 2] + termsSequence[n - 1];
        }return termsSequence;
    }
}
//public class HistoryEntry {

//}
    
    
    
    // zamienic na metodę niestatyczną
   // historia wystąpienia
//
