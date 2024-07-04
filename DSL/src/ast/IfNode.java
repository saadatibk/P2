package ast;

public class IfNode extends ASTNode{

    private final ASTNode condition;
    private final ASTNode thenBranch;
    private final ASTNode elseBranch;

    public IfNode(ASTNode condition, ASTNode thenBranch, ASTNode elseBranch) {
        this.condition = condition;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }

    public ASTNode getCondition() {
        return condition;
    }

    public ASTNode getThenBranch() {
        return thenBranch;
    }

    public ASTNode getElseBranch() {
        return elseBranch;
    }
    
    @Override
    public void print(String indent) {
        System.out.print(indent + "if (");
        condition.print(indent);
        System.out.print(indent + ") ");
        thenBranch.print(indent);
        if (elseBranch != null) {
            System.out.print(indent + " else ");
            elseBranch.print(indent);
        }
    }

}