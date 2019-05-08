package com.zacharadamian.fibonaccisequence;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


/**
 * Class view
 * Is responsible for the presentation of data
 * on the basis of arguments defined by the user
 *
 **/
public class View {
    @FXML public TextField textField;
    @FXML public Label labelStatus;
    /**
     * Method drawChartGui
     * Display fibonnaci sequence on the basis of the data provided by the user.
     * He uses JFreeChart libraries for this purpose.
     **/
    public static void drawChartGui(int[] tab) {
        XYSeries dataSet = new XYSeries( "Sequence" );
        int termsSequence;
        termsSequence = tab.length;
        for (int i = 0; i < termsSequence; i += 1) {
            dataSet.add( i, tab[i] );
        }
        XYDataset xyDataSet = new XYSeriesCollection( dataSet );
        JFreeChart lineGraph = ChartFactory.createXYLineChart
                ( "Wykres Ciągu Fibonacciego",
                        "Wyraz ciągu",
                        "Wartość",
                        xyDataSet,
                        PlotOrientation.VERTICAL,
                        false,
                        false,
                        false
                );
        ChartFrame frame = new ChartFrame( "Wykres Ciągu Fibonacciego", lineGraph );
        frame.pack();
        frame.setVisible( true );
    }
    /**
     * Method drawChartConsole
     * Display fibonnaci sequence on the basis of the data provided by the user.
     * He uses nesting of two loops for.
     * Characters "|" and "-" they represent the axes of the graph
     * about "*" the consecutive terms of sequence
     **/
    public static void drawChartConsole(int[] tab) {
        int termsSequence = tab.length - 1;
        System.out.println( "\t^" );
        for (int i = tab[tab.length - 1]; i >= 0; i--) {
            System.out.print( (i + 1) + "\t|" );
            if (termsSequence >= 0 && (i + 1) == tab[termsSequence]) {
                for (int j = 0; j < termsSequence; j++) {
                    System.out.print( "\t" );
                }
                System.out.print( " *" );
                termsSequence--;
            }
            System.out.println();
        }
        System.out.print( "  0" );
        for (int i = 0; i <= tab.length - 1; i++) {
            System.out.print( "\t -" );
        }
        System.out.println( " >" );
        for (int i = 0; i <= tab.length - 1; i++) {
            System.out.print( "\t " + (i + 1) );
        }
    }
    /**
     *Display start message.
     *
    **/
    public static void printStartMessage() {
        System.out.println( "Podaj ilość wyrazów ciągu do wyliczenia: " );
    }
    /**
     *Display help.
     *
     **/
    public static void printHelp() {
        System.out.println( "Pomoc\n" +
                "1.Aplikacja GUI - Nie podawaj parametrów uruchamiających\n" +
                "2.Aplikacja Terminalowa - Podaj dwa parametry uruchamiające np. 1 1, 1 a, a a\n" +
                "3.Pomoc - pozostałe przypadki\n" );
    }
    /**
     *Display massage about minimum numbers of terms fibonnaci sequence.
     *
     **/
    public static void printMinimumTermsMassageConsole() {System.out.println( "Ciąg musi zawierać przynajmniej 2 wyrazy!" ); }
    /**
     *Display information about the natural number.
     *
     **/
    public static void printNaturalNumberMessageConsole() {
        System.err.println( "Podaj liczbę naturalną!" );
    }
    /**
     *Display massage about minimum numbers
     * of terms fibonnaci sequence.
     *@return {String}
     **/
    public static String printMinimumTermsMassageGui() { return "Ciąg musi zawierać przynajmniej 2 wyrazy!"; }
    /**
     *Display massage about maximum numbers of terms fibonnaci sequence.
     * @return {String}
     **/
    public static String printMaximumTermsMessage(){return "Program obsługuje ciąg do 45-ego wyrazu!";}
    /**
     *Display information about the natural number.
     *
     * @return {String}
     **/
    public static String printNaturalNumberMessageGui(){return  "Podaj liczbę naturalną!";}
    /**
     * Clean Text Field.
     * @return {String}
     */
    public static String printCleanTextField(){return "";}

    /**
     *Display massage about status Draw Chart.
     *
     **/
    public static void printStatusMessage(Label label, TextField textField) {
        label.setText("Wykres dla " + textField.getText() + " wyrazów ciągu");
    }
}
