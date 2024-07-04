package ast;

public class PrintNode extends ASTNode{
    private final Var variable;

    public PrintNode(Var variable) {
        this.variable = variable;
    }
    @Override
    public void print(String indent) {
        System.out.print(indent + "print ");
        variable.print(indent);
    }
    public ASTNode getVariable() {
        return variable;
    }
}
