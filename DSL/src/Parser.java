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
        return expression();
    }

    private ASTNode expression() {
        ASTNode node = term();

        while (currentToken != null && (currentToken.type == Lexer.TokenType.PLUS || currentToken.type == Lexer.TokenType.MINUS)) {
            Lexer.Token token = currentToken;
            consume(currentToken.type);
            node = new BinaryOpNode(node, term(), token);

        }
        return node;
    }

    private ASTNode term() {
        ASTNode node = factor();

        while (currentToken != null && (currentToken.type == Lexer.TokenType.MULTIPLY || currentToken.type == Lexer.TokenType.DIVIDE)) {
            Lexer.Token token = currentToken;
            consume(currentToken.type);
            node = new BinaryOpNode(node, factor(), token);

        }
        return node;
    }

    private void consume(Lexer.TokenType type) {
        if (currentToken != null && currentToken.type == type) {
            currentPos++;
            if( currentPos < tokens.size()) {
                currentToken = tokens.get(currentPos);
            } else {
                currentToken = null;
            }
        } else {
            throw new ParserException("Unexpected token: " + currentToken + " expected: " + type);
        }
    }

    private ASTNode factor() {
        Lexer.Token token = currentToken;

        if(token.type == Lexer.TokenType.NUMBER){
            consume(Lexer.TokenType.NUMBER);
            return new NumberNode(token);
        } 

        if (token.type == Lexer.TokenType.LPAREN){
            consume(Lexer.TokenType.LPAREN);
            ASTNode node = expression();
            consume(Lexer.TokenType.RPAREN);
            return node;

        }

        throw new ParserException("Unexpected token found for Factor:" + token);
        
    }

}
