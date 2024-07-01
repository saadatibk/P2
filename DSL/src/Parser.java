import java.util.*;
import ast.*;

public class Parser {

    private final List<Token> tokens;
    private int currentPos;
    private Token currentToken;

    Parser(List<Token> tokens) {
        this.tokens = tokens;
        currentPos = 0;
        currentToken = tokens.get(currentPos);
    }
    
    public ASTNode parse() {
        List<ASTNode> statements = new ArrayList<>();
        while ( currentToken != null){
            statements.add(statement());
            if (currentToken != null && currentToken.type == Token.TokenType.SEMICOLON){
                consume(currentToken.type);
            }
        }
        return new BlockNode(statements);
    }

    private ASTNode statement() {
        if (currentToken.type == Token.TokenType.LBRACE) {
            return block();
        }
        if (currentToken.type == Token.TokenType.VAR) {
            return declaration();
        }
        if (currentToken.type == Token.TokenType.IDENTIFIER) {
            return assignment();
        }
        return expression();
    }

    private ASTNode assignment() {
        Var varNode = var();
        consume(Token.TokenType.ASSIGN);
        return new AssignNode(varNode, expression());
    }

    private ASTNode declaration() {
        consume(Token.TokenType.VAR);
        Var varNode = var();
        consume(Token.TokenType.ASSIGN);
        return new VarDecl(varNode, expression());
    }

    private Var var() {
        Token token = currentToken;
        consume(Token.TokenType.IDENTIFIER);
        return new Var(token);
    }

    private ASTNode block() {
        consume(Token.TokenType.LBRACE);
        ArrayList<ASTNode> statements = new ArrayList<>();
        while(currentToken.type != Token.TokenType.RBRACE){
            statements.add(statement());
            if (currentToken.type == Token.TokenType.SEMICOLON){
                consume(currentToken.type);
            }
        }
        consume(Token.TokenType.RBRACE);
        return new BlockNode(statements);
    }

    private ASTNode expression() {
        ASTNode node = term();

        while (currentToken != null && (currentToken.type == Token.TokenType.PLUS || currentToken.type == Token.TokenType.MINUS)) {
            Token token = currentToken;
            consume(currentToken.type);
            node = new BinaryOpNode(node, term(), token);
        }
        return node;
    }

    private ASTNode term() {
        ASTNode node = factor();

        while (currentToken != null && (currentToken.type == Token.TokenType.MULTIPLY || currentToken.type == Token.TokenType.DIVIDE)) {
            Token token = currentToken;
            consume(currentToken.type);
            node = new BinaryOpNode(node, factor(), token);

        }
        return node;
    }

    private void consume(Token.TokenType type) {
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
        Token token = currentToken;

        if(token.type == Token.TokenType.NUMBER){
            consume(Token.TokenType.NUMBER);
            return new NumberNode(token);
        } 

        if (token.type == Token.TokenType.LPAREN){
            consume(Token.TokenType.LPAREN);
            ASTNode node = expression();
            consume(Token.TokenType.RPAREN);
            return node;

        }

        throw new ParserException("Unexpected token found for Factor:" + token);
        
    }

}
