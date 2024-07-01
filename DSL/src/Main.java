import java.util.List;

import ast.ASTNode;
import ast.Token;

public class Main {
    public static void main(String[] args) throws Exception {
        String input = "2 * 3 - 23 ";
        Lexer lexer = new Lexer(input);
        List<Token> tokens = lexer.tokenize();
        for (Token token : tokens) {
            System.out.println(token); 
        }
        Parser parser = new Parser(tokens);
        ASTNode root = parser.parse();
        root.print(" ");
    }
}
