import java.util.List;

import ast.ASTNode;
import ast.Token;

public class Main {
    public static void main(String[] args) throws Exception {
        String input = """
                var x = 5;
                if (x > 3) {
                    var y = x + 2;
                } else {
                    var y = x * (2 + 3);
                }
                print y;
                """;;
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
