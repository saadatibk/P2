public class Token{
    public enum TokenType {
    STRING, NUMBER, IDENTIFIER, OPERATOR, ASSIGN, VAR, LPAREN , RPAREN, LBRACE, RBRACE,  PLUS, MULTIPLY, MINUS, DIVIDE, CONDITION, SEMICOLON ;
}

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




