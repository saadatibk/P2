import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        String input = " 3 + 5 * 10";
        Lexer lexer = new Lexer(input);
        List<Lexer.Token> tokens = lexer.tokenize();
        for (Lexer.Token token : tokens) {
            System.out.println(token); 
        }
        Parser parser = new Parser(tokens);
        ASTNode root = parser.parse();
    }
}
