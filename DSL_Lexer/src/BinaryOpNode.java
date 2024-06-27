public class BinaryOpNode {

    ASTNode left;
        ASTNode right;
        Lexer.Token operationToken;

        public BinaryOpNode(ASTNode left, ASTNode right, Lexer.Token operation) {
            this.left = left;
            this.right = right;
            this.operationToken = operationToken;

        }

}
