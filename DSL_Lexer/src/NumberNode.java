public class NumberNode {
    
    int value = 0;
        Lexer.Token numberToken;

        public NumberNode (Lexer.Token numberToken) {
            this.numberToken = numberToken;
            this.value = Integer.parseInt(numberToken.value);
        }

}
