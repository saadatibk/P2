import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
         String input = """
                configs "num_users" = 100
                update "num_users" = 200 
                """;
        Lexer lexer = new Lexer(input);
        ArrayList<Lexer.Token> tokens = new ArrayList<>();
        tokens.add(new Lexer.Token(Lexer.TokenType.CONFIG, "Config"));
        tokens.add(new Lexer.Token(Lexer.TokenType.STRING, "num_users"));
        tokens.add(new Lexer.Token(Lexer.TokenType.ASSIGNMENT, "="));
        tokens.add(new Lexer.Token(Lexer.TokenType.NUMBER, "100"));

        for (Lexer.Token token : tokens) {
            System.out.println(token);
        }
    }
}
