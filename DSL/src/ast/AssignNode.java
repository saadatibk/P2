package ast;
public class AssignNode extends ASTNode{
    public Var left;
    public ASTNode right;

    public AssignNode(Var left, ASTNode right){
        this.left = left;
        this.right = right;
    }

    @Override
    public void print(String indent){

    }
}
