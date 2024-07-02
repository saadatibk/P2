package ast;
public class Var extends ASTNode{
    public Token token;
    public String name;

    public Var(Token token){
        this.token = token;
        this.name = token.value;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Var{" + name + '}');
    }
}
