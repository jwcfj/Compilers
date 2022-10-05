package main;

import exceptions.UnexpectedCharacterException;
import exceptions.UnexpectedOperatorException;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class RpnStack {
    private ArrayList<Token> tokens = new ArrayList<>();

    public void scan(FileReader file) throws UnexpectedCharacterException {
        Scanner in =  new Scanner(file);

        while(in.hasNext()) {
            Token token;
            if(in.hasNextInt()){
                token = new Token(TokenType.NUM, in.nextLine());
                this.tokens.add(token);
            }else{
                String operator = in.nextLine();
                switch (operator) {
                    case "+":
                        token = new Token(TokenType.PLUS, operator);
                        tokens.add(token);
                        break;
                    case "-":
                        token = new Token(TokenType.MINUS, operator);
                        tokens.add(token);
                        break;
                    case "*":
                        token = new Token(TokenType.STAR, operator);
                        tokens.add(token);
                        break;
                    case "/":
                        token = new Token(TokenType.SLASH, operator);
                        tokens.add(token);
                        break;
                    default:
                        UnexpectedCharacterException error = new UnexpectedCharacterException(operator);
                        throw error;
                }
            }
        }
    }

    public int run() throws UnexpectedOperatorException {
        Stack<Integer> stack = new Stack<>();
        for(Token token : this.tokens) {
            try{
                stack.push(Integer.parseInt(token.lexeme));
            }catch (NumberFormatException e){
                int x = 0, y = 0;
                y = stack.pop();
                x = stack.pop();

                switch (token.type){
                    case MINUS -> stack.push(x-y);
                    case PLUS -> stack.push(x+y);
                    case STAR -> stack.push(x*y);
                    case SLASH -> stack.push(x/y);
                    case EOF -> {}
                    case NUM -> {}
                    default -> {
                        UnexpectedOperatorException error = new UnexpectedOperatorException(token.lexeme);
                        throw error;
                    }
                }
            }
        }
        return stack.get(0);
    }
}