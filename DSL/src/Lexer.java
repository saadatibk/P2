import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ast.Token;
import ast.Token.TokenType;

public class Lexer implements Iterable<Token>{

    private final String input;
    private final List<Token> tokens;
    private int current;

    public Lexer(String input) {
        this.input = input;
        this.tokens = new ArrayList<>();
        this.current = 0;
        tokenize();

    }

    public List<Token> tokenize() {
        while (current < input.length()) {
            char c = input.charAt(current);
            if (Character.isWhitespace(c)) {
                skipWhitespace();
                continue;
            }
            if (isDigit(c)) {
                tokens.add(number());
                continue;
            }
            if (isAlpha(c)) {
                Token id = identifier();
                if (id.value.equals("var")) {
                    tokens.add(new Token(Token.TokenType.VAR, "var"));
                } else if (id.value.equals("if")) {
                    tokens.add(new Token(Token.TokenType.IF, "if"));
                } else if (id.value.equals("else")){
                    tokens.add(new Token(Token.TokenType.ELSE, "else"));
                } else if (id.value.equals("print")){
                    tokens.add(new Token(Token.TokenType.PRINT, "print"));
                } else {
                    tokens.add(id);
                }
                continue;
            }
            switch (c) {
                case '+':
                    tokens.add(new Token(Token.TokenType.PLUS, "+"));
                    advance();
                    break;
                case '-':
                    tokens.add(new Token(Token.TokenType.MINUS, "-"));
                    advance();
                    break;
                case '*':
                    tokens.add(new Token(Token.TokenType.MULTIPLY, "*"));
                    advance();
                    break;
                case '/':
                    tokens.add(new Token(Token.TokenType.DIVIDE, "/"));
                    advance();
                    break;
                case '>':
                    tokens.add(new Token(Token.TokenType.GREATERTHAN, ">"));
                    advance();
                    break;
                case '<':
                    tokens.add(new Token(Token.TokenType.LESSTHAN, "<"));
                    advance();
                    break;
                case '(':
                    tokens.add(new Token(Token.TokenType.LPAREN, "("));
                    advance();
                    break;
                case ')':
                    tokens.add(new Token(Token.TokenType.RPAREN, ")"));
                    advance();
                    break;
                case '=':
                    tokens.add(new Token(Token.TokenType.ASSIGN, "="));
                    advance();
                    break;
                case '{':
                    tokens.add(new Token(Token.TokenType.LBRACE, "{"));
                    advance();
                    break;
                case '}':
                    tokens.add(new Token(Token.TokenType.RBRACE, "}"));
                    advance();
                    break;
                case ';':
                    tokens.add(new Token(TokenType.SEMICOLON, ";"));
                    advance();
                    break;
                case '"':
                    tokens.add(new Token(Token.TokenType.STRING, readString()));
                    break;
                default:
                    throw new RuntimeException("Unexpected character: " + c);
            }
        }
        return tokens;
    }

    private void advance() {
        current++;
    }

    private void skipWhitespace() {
        while (current < input.length() && Character.isWhitespace(input.charAt(current))) {
            advance();
        }
    }

    private Token identifier(){
        StringBuilder builder = new StringBuilder();
        while (current < input.length() && (isAlphaNumeric(input.charAt(current)))) {
            builder.append(input.charAt(current));
            advance();
        }
        return new Token(Token.TokenType.IDENTIFIER, builder.toString());
    }
   
    private Token number(){
        StringBuilder builder = new StringBuilder();
        while (current < input.length() && (isDigit(input.charAt(current)))) {
            builder.append(input.charAt(current));
            advance();
        }
        return new Token(Token.TokenType.NUMBER, builder.toString());
    }

    private boolean isAlphaNumeric(char c) {
        return isAlpha(c) | isDigit(c);

    }

    private boolean isAlpha(char c){
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || c == '_';
    }

    private boolean isDigit(char c){
        return ('0' <= c & c <= '9');
    }

    private String readString() {
        StringBuilder builder = new StringBuilder();
        advance();
        while (current < input.length() && input.charAt(current) != '"') {
            builder.append(input.charAt(current));
            advance();
        }
        advance();
        return builder.toString();
    }

    @Override
    public Iterator<Token> iterator() {
        return tokens.iterator();
    }

}
