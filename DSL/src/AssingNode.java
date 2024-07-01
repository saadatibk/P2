public class AssingNode extends ASTNode{
    Var left;
    Token op;
    ASTNode right;

    AssingNode(Var left, Token op, ASTNode right){
        this.left = left;
        this.op = op;
        this.right = right;
    }

    @Override
    public void print(String indent){

    }

}
