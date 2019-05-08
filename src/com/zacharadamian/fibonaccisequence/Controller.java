package com.zacharadamian.fibonaccisequence;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.InputMismatchException;
import java.util.Scanner;
import static com.zacharadamian.fibonaccisequence.View.*;
/**
 * Controller class
 * Is responsible for receiving input data from usage
 * and their appropriate interpretation in
 * order to select a specific variant
 */
public class Controller extends Application {
    @FXML public TextField textField;
    @FXML public Label labelStatus;
    private FibonacciCoverter fibonacciCoverter;

    public Controller() {
        fibonacciCoverter = new FibonacciCoverter();
    }

    /**
    * Method startController
    * Starts specified software variant:
    * if arguments = 0 print GUI,
    * if arguments = 2 print Console
    * in the other cases = print help
    */
    public void startController(String[] args) {
        if (args.length == 0) {
            launch( args );
            System.exit( 0 );
        }
        if (args.length == 2) {
            printStartMessage();
            try {
            int valueText = (getNumber());
                if (valueText < 2) {
                    printMinimumTermsMassageConsole();
                } else {
                    drawChartConsole( fibonacciCoverter.calculateSequence( valueText ) );
                }
            } catch (InputMismatchException e) {
                printNaturalNumberMessageConsole();
            }
            System.exit( 0 );
        } else { printHelp(); }
        System.exit( 0 );
    }
    /**
     Method start
     Is responsible for opening stage GUI from FXMLMain.fxml
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load( getClass().getResource( "FXMLMain.fxml" ) );
        Scene scene = new Scene( root );
        stage.setScene( scene );
        stage.show();
        stage.setTitle( "fibonacci_sequence_gui" );
    }
    /**
     * Method handleButtonAction
     * Is responsible for interactions after number
     * is placed in text field.
     */
    public void handleButtonAction() {
    try{
        int valueTextField = Integer.parseInt( textField.getText() );
        if (valueTextField < 2)
            labelStatus.setText( printMinimumTermsMassageGui() );
        else if (valueTextField >= 46) {
                labelStatus.setText( printMaximumTermsMessage() );
            } else {
            int[] tab = fibonacciCoverter.calculateSequence(Integer.parseInt(textField.getText()));
            drawChartGui(tab);
            printStatusMessage(this.labelStatus, this.textField);
            }
        } catch (NumberFormatException e) {
        labelStatus.setText( printNaturalNumberMessageGui() );
    }textField.setText(printCleanTextField());
    }
    /**
     * Method getNumber
     * Charges from user integer number in console
     * @return {number}
     */
    private static int getNumber() {
        Scanner scanner = new Scanner( System.in );
        return scanner.nextInt();
    }
}