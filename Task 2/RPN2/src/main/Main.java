package main;

import exceptions.UnexpectedCharacterException;
import exceptions.UnexpectedOperatorException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, UnexpectedCharacterException, UnexpectedOperatorException {
	// write your code here
        RpnStack rpn = new RpnStack();
        rpn.scan(new FileReader("src/Calc1.stk"));
        int resultado = rpn.run();
        System.out.println(resultado);
    }


}