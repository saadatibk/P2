import java.util.List;

public class Parser {

    private final List<Lexer.Token> tokens;
    private int currentPos;
    private Lexer.Token currentToken;

    Parser(List<Lexer.Token> tokens) {
        this.tokens = tokens;
        currentPos = 0;
        currentToken = tokens.get(currentPos);
    }
    
    public ASTNode parse() {
        return term();
    }

    private ASTNode term() {
        ASTNode node = factor();
        while (currentToken.type == Lexer.TokenType.MULTIPLY || currentToken.type == Lexer.TokenType.DIVIDE) {
            Lexer.Token token = currentToken;
            consume(currentToken.type);
            node = new BinaryOpNode(node, factor(), token);

        }
        return node;
    }

    private void consume(Lexer.TokenType type) {
        if (currentToken.type == type) {
            currentPos++;
            if( currentPos < tokens.size()) {
                currentToken = tokens.get(currentPos);
            } else {
                currentToken = null;
            }
        } else {
            throw new ParserException("Unexpected token:" + type);
        }
    }

    private ASTNode factor() {
       return null;
    }

}
