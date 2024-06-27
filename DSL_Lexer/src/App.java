

public class App {
    public static void main(String[] args) throws Exception {
         String input = " 3 + 5 * 10";
        Lexer lexer = new Lexer(input);
        for (Lexer.Token token: lexer){
            System.out.println(token);
        }
        
    }
}
