import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        String input = "2 * 3 -  ";
        Lexer lexer = new Lexer(input);
        List<Lexer.Token> tokens = lexer.tokenize();
        for (Lexer.Token token : tokens) {
            System.out.println(token); 
        }
        Parser parser = new Parser(tokens);
        ASTNode root = parser.parse();
        root.print(" ");
    }
}
