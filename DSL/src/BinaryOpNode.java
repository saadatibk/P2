public class BinaryOpNode extends ASTNode {

    ASTNode left;
    ASTNode right;
    Lexer.Token operationToken;

    public BinaryOpNode(ASTNode left, ASTNode right, Lexer.Token operation) {
        this.left = left;
        this.right = right;
        this.operationToken = operation;

    }

    public void print(String indent){
        System.out.print(indent + "Op{" + operationToken.value + '}');
        left.print(indent + indent);
        right.print(indent + indent);
    }

}
