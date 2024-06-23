import java.util.ArrayList;
import java.util.List;

public class Lexer {

    private final String input;
    private final List<Token> tokens;
    private int current;

    public Lexer(String input) {
        this.input = input;
        this.tokens = new ArrayList<Token>();
        this.current = 0;
        tokenize();

    }

    private void tokenize() {
        while (current < input.length()) {
            char c = input.charAt(current);
            switch (c){
                case ' ':
                case '\t':
                    case '\r':
                        case '\n':
                            current++;
                            break;
                case '=':
                    tokens.add(new Token(TokenType.ASSIGNMENT,"="));
                    current++;
                    break;

                case '+':
                case '-':
                case '*':
                case '/':
                    tokens.add(new Token(TokenType.OPERATOR, Character.toString(c)));
                    current++;
                    break;
                case "\"\"":
                    tokens.add(new Token(TokenType.STRING, readString());
                    break;
                case '%':
                    tokens.add(new Token(TokenType.REFERENCES, readReference()));


            }
        }


    }

    private String readReference() {
        StringBuilder builder = new StringBuilder();
        current++;
        while (current < input.length() && isAlphaNumeric(input.charAt(current)) ) {
            builder.append(input.charAt(current));
            current++;
        }
        return builder.toString();
    }

    private boolean isAlphaNumeric(char c) {
        return isAlpha(c) | isDigit(c);

    }

    private boolean isAlpha(char c){
        return ('a' <= c & c <= 'z') || ('a' <= c & c <= 'z');
    }

    private boolean isDigit(char c){
        return false;
    }

    private String readString() {
        StringBuilder builder = new StringBuilder();
        current++;
        while (current < input.length() && input.charAt(current) != '"') {
            builder.append(input.charAt(current));
            current++;
        }
        return builder.toString();
    }

    public static class Token{
        final TokenType type;
        final String value;

        Token(TokenType type, String value){
            this.type = type;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Token{" +
                    "type=" + type +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    enum TokenType {
        CONFIG, UPDATE, COMPUTE,SHOW, CONFIGS, STRING, NUMBER, IDENTIFIER, REFERENCES, ASSIGNMENT, OPERATOR;
    }
}
