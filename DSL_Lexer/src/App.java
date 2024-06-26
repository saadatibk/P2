

public class App {
    public static void main(String[] args) throws Exception {
         String input = """
                 cconfig "num_users" = 100 
                 config "num_requests" = 100
                 update "num_users" = 200
                 compute "result" = %num_users + %num_requests
                 """;
        Lexer lexer = new Lexer(input);
        for (Lexer.Token token: lexer){
            System.out.println(token);
        }
        
    }
}
